package com.axinstar.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 有效期枚举类型
 */
@RequiredArgsConstructor
public enum ValidateTypeEnum {

    /**
     * 永久有效期
     */
    PERMNANT(0),

    /**
     * 自定义有效期
     */
    COSTOM(1);

    @Getter
    private final int type;
}
