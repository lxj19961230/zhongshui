package com.ruoyi.system.service.zs.impl;

import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import com.ruoyi.system.mapper.zs.AnnualReportAuditModelMapper;
import com.ruoyi.system.service.zs.AnnualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/2/28 13:40
 */
@Service
public class AnnualServiceImpl implements AnnualService {

    @Autowired
    private AnnualReportAuditModelMapper annualReportAuditModelMapper;

    @Override
    public List<AnnualReportAuditModel> selectDeptList(AnnualReportAuditModel model) {
        return annualReportAuditModelMapper.selectActiveList(model);
    }
}
