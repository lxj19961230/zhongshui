package com.ruoyi.common.enums.zs;

/**
 * 税务类型
 *
 *
 */
public enum TaxType {
    TAX_REPORT("税务报告",1),
    NATIONAL_AND_LOCAL_TAX_CANCELLATION_AUDIT_REPORT("国地税注销审计报告",2),
    CORPORATE_INCOME_TAX_FINAL_AND_PAYMENT_AUDIT_REPORT("企业所得税汇算清缴审计报告",3),
    SUPER_DEDUCTION_PROPERTY_TAX_RETURN_AUDIT_REPORT("加计扣除财产报税审计报告",4),
    VAT_DEDUCTION_AUDIT_REPORT("增值税减免审计报告",5),
    TAX_MIGRATION_AUDIT_REPORT("",6),
    OTHER("其他",7)
    ;
    private String name;

    private Integer code;

    TaxType(String name, Integer code){
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
