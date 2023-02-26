package com.wanglab.geektime.designpattern.ratelimiter;

import com.wanglab.geektime.designpattern.ratelimiter.alg.IRateLimiterAlg;
import com.wanglab.geektime.designpattern.ratelimiter.rule.RateLimitRule;
import com.wanglab.geektime.designpattern.ratelimiter.rule.RuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RateLimiter {

    private ConcurrentMap<String, IRateLimiterAlg> counters = new ConcurrentHashMap<>();

    private RateLimitRule rule;

    public RateLimiter() {
        try (InputStream in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml")) {
            Yaml yaml = new Yaml();
            RuleConfig ruleConfig = yaml.loadAs(in, RuleConfig.class);
            this.rule = new RateLimitRule(ruleConfig);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean limit(String appId, String url) {
        return true;
    }
}
