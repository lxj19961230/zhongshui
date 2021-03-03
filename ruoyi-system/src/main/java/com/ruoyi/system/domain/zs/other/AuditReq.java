package com.ruoyi.system.domain.zs.other;

import java.io.Serializable;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/3 23:27
 */
public class AuditReq implements Serializable {

    private Integer id;

    private Integer audit;

    private String remake;

    private Long loginUserId;

    public AuditReq() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }
}
