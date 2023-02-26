package com.wanglab.geektime.designpattern.ratelimiter.rule;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RuleConfig {
    private List<AppRuleConfig> configs;

    @Getter
    @Setter
    public static class AppRuleConfig {
        private String  appId;

        private List<ApiLimit> limits;
    }
}
