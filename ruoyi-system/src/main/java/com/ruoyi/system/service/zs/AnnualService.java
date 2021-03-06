package com.ruoyi.system.service.zs;

import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import com.ruoyi.system.domain.zs.other.AuditReq;

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

    int insert(AnnualReportAuditModel data);

    int deleteByIds(String ids);

    AnnualReportAuditModel selectById(Integer id);

    int update(AnnualReportAuditModel annualReportAuditModel);

    int audit(AuditReq req);

    int back(Integer id);
}
