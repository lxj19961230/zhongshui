package com.ruoyi.web.controller.report.annual.resp;

import com.ruoyi.system.domain.zs.AnnualReportAuditModel;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/3 09:27
 */
public class AnnualReportAuditResp extends AnnualReportAuditModel {

    //是否需要审核 0不能1能
    private int needAudit;

    //是否能操作 0不能1能
    private int needOper;

    public AnnualReportAuditResp() {
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
