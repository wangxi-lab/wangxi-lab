package com.wanglab.geektime.designpattern.ratelimiter.alg.impl;


import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimitAlg {
    private static final long TRY_LOCK_TIMEOUT = 200L;

    private StopWatch stopWatch;

    private AtomicInteger countCurrent = new AtomicInteger(0);

    private final int limit;

    private Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this.limit = limit;
    }


    protected RateLimitAlg(int limit, StopWatch stopWatch) {
        this.limit = limit;
        this.stopWatch = stopWatch;
    }

    public boolean tryAcquire() {
        int updateCount = countCurrent.incrementAndGet();
        if (updateCount <= limit) {
            return true;
        }

        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MICROSECONDS)) {
                try {
                    if (stopWatch.getLastTaskTimeMillis() > TimeUnit.SECONDS.toMillis(1)) {
                        countCurrent.set(0);
                        stopWatch.start();
                    }
                     updateCount = countCurrent.incrementAndGet();
                    return updateCount  <= limit;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("");
    }
}
