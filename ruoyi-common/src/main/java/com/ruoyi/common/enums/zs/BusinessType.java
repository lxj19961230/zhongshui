package com.ruoyi.common.enums.zs;

/**
 * 业务类型
 *
 */
public enum BusinessType {
    ANNUAL_REPORT_AUDIT("年报",1),
    CAPITAL_VERIFICATION("验资",2),
    SPECIAL_AUDIT("专项审计",3),
    TAX_AUDIT("税务审计",4),
    OTHER_TAX_ASSURANCE("其他税务鉴证业务",5),
    ASSESSMENT("评估",6)
    ;
    private String name;
    private Integer code;

    BusinessType(String name, Integer code){
        this.name = name;
        this.code = code;
    }

    public static BusinessType valueOf(Integer code){
        if(null == code){
            throw new IllegalArgumentException("Business Type's code is null.");
        }
        for(BusinessType type : BusinessType.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        throw new IllegalArgumentException(code + " is not in Business Type.");
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
