package com.ruoyi.common.enums.zs;

/**
 * 年报审计的意见类型
 *
 *
 */
public enum AnnualReportAuditOpinionType {
    one("无保留意见",1),
    tow("带强调事项段无保留意见",2),
    three("保留意见",3),
    four("否定意见",4),
    five("无法表示意见",5),
    OTHER("其他",6)
    ;
    private String description;
    private Integer code;

    AnnualReportAuditOpinionType(String description,Integer code){
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
