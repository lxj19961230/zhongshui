package com.ruoyi.system.service.zs;

import com.ruoyi.system.domain.zs.AnnualReportAuditModel;

import java.util.List;

/**
 * @desc: 年报审计
 * @auther: lxj
 * @date: 2021/2/28 13:39
 */
public interface AnnualService {

    /**
     * 查询
     */
    List<AnnualReportAuditModel> selectDeptList(AnnualReportAuditModel model);
}
