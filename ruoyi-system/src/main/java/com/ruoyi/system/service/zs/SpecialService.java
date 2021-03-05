package com.ruoyi.system.service.zs;

import com.ruoyi.system.domain.zs.SpecialAuditModel;
import com.ruoyi.system.domain.zs.other.AuditReq;

import java.util.List;

/**
 * @desc: 年报审计
 * @auther: lxj
 * @date: 2021/2/28 13:39
 */
public interface SpecialService {

    /**
     * 查询
     */
    List<SpecialAuditModel> selectDeptList(SpecialAuditModel model);

    int insert(SpecialAuditModel data);

    int deleteByIds(String ids);

    SpecialAuditModel selectById(Integer id);

    int update(SpecialAuditModel annualReportAuditModel);

    int audit(AuditReq req);

    int back(Integer id);
}
