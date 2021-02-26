package com.ruoyi.common.enums.zs;

/**
 * 企业类型
 *
 */
public enum CompanyType {
    LISTED_COMPANY("上市公司",1),
    GENERAL_ENTERPRISE("一般企业",2),
    STATE_OWNED_ENTERPRISE("国有企业",3),
    GOVERNMENT_AFFILIATED_INSTITUTION("事业单位",4),
    NONGOVERNMENTAL_NONPROFIT_ORGANIZATION("民间非营利组织",5),
    OTHER_ENTERPRISE("其他企业",6)
    ;
    private String name;
    private Integer code;
    CompanyType(String name, Integer code){
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
