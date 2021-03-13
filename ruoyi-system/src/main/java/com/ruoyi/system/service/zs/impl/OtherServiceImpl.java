package com.ruoyi.system.service.zs.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.zs.AuditEnum;
import com.ruoyi.common.enums.zs.BizType;
import com.ruoyi.common.enums.zs.RecordState;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.zs.OtherTaxAssuranceModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.zs.OtherTaxAssuranceModelMapper;
import com.ruoyi.system.service.zs.OtherService;
import com.ruoyi.system.service.zs.manager.CodeRuleManager;
import org.apache.commons.compress.utils.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/2/28 13:40
 */
@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherTaxAssuranceModelMapper otherTaxAssuranceModelMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private CodeRuleManager codeRuleManager;

    private final int startNum = 1;

    @Override
    public List<OtherTaxAssuranceModel> selectDeptList(OtherTaxAssuranceModel model) {
        return otherTaxAssuranceModelMapper.selectActiveList(model);
    }

    @Override
    @Transactional
    public synchronized int insert(OtherTaxAssuranceModel data) {

        Set<Long> audits = Sets.newHashSet(data.getFirstAuditPersonId(),data.getSecondAuditPersonId(),data.getThirdAudtiPersonId());
        if(audits.size()!=3){
            throw new BusinessException("审核人员不能重复！");
        }

        Integer maxId = otherTaxAssuranceModelMapper.findMaxId();
        if(Objects.isNull(maxId) || maxId<startNum){
            data.setId(startNum);
        }else {
            data.setId(maxId+1);
        }

        data.setYear(data.getAuditYear());
        data.setReportSerial(codeRuleManager.getNextCode(BizType.OTHER_TAX_ASSURANCE,data.getId(),Objects.isNull(data.getAuditYear())? LocalDate.now().getYear():data.getAuditYear()));
        data.setIsDeleted(0);
        data.setFirstAuditPersonName(userMapper.selectUserById(data.getFirstAuditPersonId()).getLoginName());
        data.setSecondAuditPersonName(userMapper.selectUserById(data.getSecondAuditPersonId()).getLoginName());
        data.setThirdAuditPersonName(userMapper.selectUserById(data.getThirdAudtiPersonId()).getLoginName());
        data.setState(RecordState.NEW.getCode());
        data.setUserId(userMapper.selectUserByLoginName(data.getUserName()).getUserId());

        return otherTaxAssuranceModelMapper.save(data);
    }

    @Override
    @Transactional
    public int deleteByIds(String ids) {
        if(StringUtils.isNotBlank(ids)){
            Integer[] ss = Convert.toIntArray(ids);
            for(Integer id:ss){
                OtherTaxAssuranceModel annualReportAuditModel = new OtherTaxAssuranceModel();
                annualReportAuditModel.setId(id);
                annualReportAuditModel.setIsDeleted(1);
                otherTaxAssuranceModelMapper.updateById(annualReportAuditModel);
                codeRuleManager.disactive(BizType.OTHER_TAX_ASSURANCE,annualReportAuditModel.getId());
            }
        }
        return 1;
    }

    @Override
    public OtherTaxAssuranceModel selectById(Integer id) {
        return otherTaxAssuranceModelMapper.findById(id);
    }

    @Override
    public int update(OtherTaxAssuranceModel data) {
        Set<Long> audits = Sets.newHashSet(data.getFirstAuditPersonId(),data.getSecondAuditPersonId(),data.getThirdAudtiPersonId());
        if(audits.size()!=3){
            throw new BusinessException("审核人员不能重复！");
        }
        data.setYear(data.getAuditYear());
        data.setFirstAuditPersonName(userMapper.selectUserById(data.getFirstAuditPersonId()).getLoginName());
        data.setSecondAuditPersonName(userMapper.selectUserById(data.getSecondAuditPersonId()).getLoginName());
        data.setThirdAuditPersonName(userMapper.selectUserById(data.getThirdAudtiPersonId()).getLoginName());
        return otherTaxAssuranceModelMapper.updateById(data);
    }

    @Override
    public int audit(AuditReq req) {
        OtherTaxAssuranceModel annualReportAuditModel = otherTaxAssuranceModelMapper.findById(req.getId());
        if(req.getLoginUserId().longValue()==annualReportAuditModel.getFirstAuditPersonId().longValue()){
            annualReportAuditModel.setFirstAuditDate(new Date());
            annualReportAuditModel.setFirstAuditOpinion(StringUtils.isNotBlank(req.getRemake())?AuditEnum.valueOf(req.getAudit()).getName().concat(",").concat(req.getRemake()):AuditEnum.valueOf(req.getAudit()).getName());
        }
        if(req.getLoginUserId().longValue()==annualReportAuditModel.getSecondAuditPersonId().longValue()){
            annualReportAuditModel.setSecondAuditDate(new Date());
            annualReportAuditModel.setSecondAuditOpinion(StringUtils.isNotBlank(req.getRemake())?AuditEnum.valueOf(req.getAudit()).getName().concat(",").concat(req.getRemake()):AuditEnum.valueOf(req.getAudit()).getName());
        }
        if(req.getLoginUserId().longValue()==annualReportAuditModel.getThirdAudtiPersonId().longValue()){
            annualReportAuditModel.setThirdAuditDate(new Date());
            annualReportAuditModel.setThirdAuditOpinion(StringUtils.isNotBlank(req.getRemake())?AuditEnum.valueOf(req.getAudit()).getName().concat(",").concat(req.getRemake()):AuditEnum.valueOf(req.getAudit()).getName());
        }
        otherTaxAssuranceModelMapper.updateById(annualReportAuditModel);
        return 1;
    }

    @Override
    public int back(Integer id) {
        OtherTaxAssuranceModel annualReportAuditModel = new OtherTaxAssuranceModel();
        annualReportAuditModel.setId(id);
        annualReportAuditModel.setState(RecordState.ABANDONED.getCode());
        return otherTaxAssuranceModelMapper.updateById(annualReportAuditModel);
    }
}
