package com.ruoyi.common.enums.zs;

/**
 * 验资类型
 *
 *
 */
public enum CapitalVerificationType {
    ESTABLISH("设立",1),
    CAPITAL_INCREASE("增资",2),
    INITIAL_CONTRIBUTION("首次出资",3),
    SECONDARY_CONTRIBUTION("二次出资",4),
    CHANGE("变更",5),
    OTHER("其他",6)
    ;
    private Integer code;

    private String name;

    CapitalVerificationType(String name, Integer code){
        this.name = name;
        this.code = code;
    }
}
