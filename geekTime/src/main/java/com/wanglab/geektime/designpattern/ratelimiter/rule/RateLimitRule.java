package com.wanglab.geektime.designpattern.ratelimiter.rule;

public class RateLimitRule {

    public RateLimitRule(RuleConfig ruleConfig) {
        // todo
    }

    public ApiLimit getLimit(String appId, String api) {
        // todo
        return new ApiLimit(api, 10, 1);


    }
}
