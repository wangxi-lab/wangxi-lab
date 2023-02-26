package com.wanglab.geektime.designpattern.ratelimiter.rule;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiLimit {

    private static final int DEFAULT_TIME_UNIT = 1;

    private String api;

    private int limit;

    private int unit = DEFAULT_TIME_UNIT;

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_TIME_UNIT);
    }

    public ApiLimit(String api, int limit, int unit) {
        this.api = api;
        this.limit = limit;
        this.unit = unit;
    }

}
