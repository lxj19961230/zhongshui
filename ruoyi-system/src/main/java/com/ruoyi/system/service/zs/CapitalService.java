package com.ruoyi.system.service.zs;

import com.ruoyi.system.domain.zs.CapitalVerificationModel;
import com.ruoyi.system.domain.zs.other.AuditReq;

import java.util.List;

/**
 * @desc: 年报审计
 * @auther: lxj
 * @date: 2021/2/28 13:39
 */
public interface CapitalService {

    /**
     * 查询
     */
    List<CapitalVerificationModel> selectDeptList(CapitalVerificationModel model);

    int insert(CapitalVerificationModel data);

    int deleteByIds(String ids);

    CapitalVerificationModel selectById(Integer id);

    int update(CapitalVerificationModel annualReportAuditModel);

    int audit(AuditReq req);

    int back(Integer id);
}
