package com.ruoyi.system.service.zs;

import com.ruoyi.system.domain.zs.OtherTaxAssuranceModel;
import com.ruoyi.system.domain.zs.other.AuditReq;

import java.util.List;

/**
 * @desc: 年报审计
 * @auther: lxj
 * @date: 2021/2/28 13:39
 */
public interface OtherService {

    /**
     * 查询
     */
    List<OtherTaxAssuranceModel> selectDeptList(OtherTaxAssuranceModel model);

    int insert(OtherTaxAssuranceModel data);

    int deleteByIds(String ids);

    OtherTaxAssuranceModel selectById(Integer id);

    int update(OtherTaxAssuranceModel annualReportAuditModel);

    int audit(AuditReq req);

    int back(Integer id);
}
