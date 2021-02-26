package com.ruoyi.common.enums.zs;

/**
 * 验资报告的属性
 *
 *
 */
public enum CapitalVerificationReportProperties {
    ESTABLISH("设立",1),
    CHANGE_OF_EQUITY("变更股权",2),
    SECOND_CAPITAL_VERIFICATION("二次验资",3),
    OTHER("其他",4)
    ;

    private String name;

    private Integer code;

    CapitalVerificationReportProperties(String name, Integer code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
