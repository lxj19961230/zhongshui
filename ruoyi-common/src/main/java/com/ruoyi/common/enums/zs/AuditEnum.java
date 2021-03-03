package com.ruoyi.common.enums.zs;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/3 23:25
 */
public enum AuditEnum {
    ON("无异议",1),
    DIS("有异议",2)
    ;
    private String name;
    private Integer code;

    AuditEnum(String name, Integer code){
        this.name = name;
        this.code = code;
    }

    public static AuditEnum valueOf(Integer code){
        if(null == code){
            throw new IllegalArgumentException("AuditEnum Type's code is null.");
        }
        for(AuditEnum type : AuditEnum.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        throw new IllegalArgumentException(code + " is not in AuditEnum Type.");
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
