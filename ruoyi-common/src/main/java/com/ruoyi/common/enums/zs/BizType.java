package com.ruoyi.common.enums.zs;

/**
 * 业务类型
 *
 */
public enum BizType {
    ANNUAL_REPORT_AUDIT("年报",1000,1),
    CAPITAL_VERIFICATION("验资",1000,2),
    SPECIAL_AUDIT("专项审计",1000,3),
    TAX_AUDIT("税务审计",2000,4),
    OTHER_TAX_ASSURANCE("其他税务鉴证业务",1000,5),
    ASSESSMENT("评估",1000,6)
    ;
    private String name;
    private Integer code;
    private Integer type;

    BizType(String name, Integer code,Integer type){
        this.name = name;
        this.code = code;
        this.type = type;
    }

    public static BizType valueOf(Integer code){
        if(null == code){
            throw new IllegalArgumentException("Business Type's code is null.");
        }
        for(BizType type : BizType.values()){
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
