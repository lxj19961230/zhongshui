package com.ruoyi.web.controller.report.other.resp;

import com.ruoyi.system.domain.zs.SpecialAuditModel;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/3 09:27
 */
public class OtherAuditResp extends SpecialAuditModel {

    //是否需要审核 0不能1能
    private int needAudit;

    //是否能操作 0不能1能
    private int needOper;

    public OtherAuditResp() {
    }

    public int getNeedAudit() {
        return needAudit;
    }

    public void setNeedAudit(int needAudit) {
        this.needAudit = needAudit;
    }

    public int getNeedOper() {
        return needOper;
    }

    public void setNeedOper(int needOper) {
        this.needOper = needOper;
    }
}
