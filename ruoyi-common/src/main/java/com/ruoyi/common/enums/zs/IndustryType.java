package com.ruoyi.common.enums.zs;

/**
 * 行业类型
 *
 */
public enum IndustryType {
    FINANCIAL_INDUSTRY("金融行业",1),
    MANUFACTURING_INDUSTRY("制造业",2),
    WHOLESALE_AND_RETAIL_TRADE("批发和零售业",3),
    REAL_ESTATE_INDUSTRY("房地产业",4)
    ;
    private String name;
    private Integer code;
    IndustryType(String name,Integer code){
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
