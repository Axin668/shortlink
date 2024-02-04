package com.axinstar.shortlink.project.common.constant;

/**
 * Redis Key 常量类
 */
public class RedisKeyConstant {

    /**
     * 短链接跳转前缀 Key
     */
    public static final String GOTO_SHORT_LINK_KEY = "short-link_goto_%s";

    /**
     * 短链接空值跳转前缀 Key
     */
    public static final String GOTO_IS_NULL_SHORT_LINK_KEY = "short-link_is_null_goto_%s";

    /**
     * 短链接跳转分布式锁前缀 Key
     */
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "short-link_lock_goto_%s";
}
