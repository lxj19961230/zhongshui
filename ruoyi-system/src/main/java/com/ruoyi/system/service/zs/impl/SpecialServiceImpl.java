package com.ruoyi.system.service.zs.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.zs.AuditEnum;
import com.ruoyi.common.enums.zs.BizType;
import com.ruoyi.common.enums.zs.RecordState;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.zs.SpecialAuditModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.zs.SpecialAuditModelMapper;
import com.ruoyi.system.service.zs.SpecialService;
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
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialAuditModelMapper specialAuditModelMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private CodeRuleManager codeRuleManager;

    private final int startNum = 1;

    @Override
    public List<SpecialAuditModel> selectDeptList(SpecialAuditModel model) {
        return specialAuditModelMapper.selectActiveList(model);
    }

    @Override
    @Transactional
    public synchronized int insert(SpecialAuditModel data) {

        Set<Long> audits = Sets.newHashSet(data.getFirstAuditPersonId(),data.getSecondAuditPersonId(),data.getThirdAudtiPersonId());
        if(audits.size()!=3){
            throw new BusinessException("审核人员不能重复！");
        }

        data.setYear(data.getAuditYear());
        Integer maxId = specialAuditModelMapper.findMaxId();
        if(Objects.isNull(maxId) || maxId<startNum){
            data.setId(startNum);
        }else {
            data.setId(maxId+1);
        }

        data.setReportSerial(codeRuleManager.getNextCode(BizType.SPECIAL_AUDIT,data.getId(),Objects.isNull(data.getAuditYear())? LocalDate.now().getYear():data.getAuditYear()));
        data.setIsDeleted(0);
        data.setFirstAuditPersonName(userMapper.selectUserById(data.getFirstAuditPersonId()).getLoginName());
        data.setSecondAuditPersonName(userMapper.selectUserById(data.getSecondAuditPersonId()).getLoginName());
        data.setThirdAuditPersonName(userMapper.selectUserById(data.getThirdAudtiPersonId()).getLoginName());
        data.setState(RecordState.NEW.getCode());
        data.setUserId(userMapper.selectUserByLoginName(data.getUserName()).getUserId());

        return specialAuditModelMapper.save(data);
    }

    @Override
    @Transactional
    public int deleteByIds(String ids) {
        if(StringUtils.isNotBlank(ids)){
            Integer[] ss = Convert.toIntArray(ids);
            for(Integer id:ss){
                SpecialAuditModel annualReportAuditModel = new SpecialAuditModel();
                annualReportAuditModel.setId(id);
                annualReportAuditModel.setIsDeleted(1);
                specialAuditModelMapper.updateById(annualReportAuditModel);
                codeRuleManager.disactive(BizType.SPECIAL_AUDIT,annualReportAuditModel.getId());
            }
        }
        return 1;
    }

    @Override
    public SpecialAuditModel selectById(Integer id) {
        return specialAuditModelMapper.findById(id);
    }

    @Override
    public int update(SpecialAuditModel data) {
        Set<Long> audits = Sets.newHashSet(data.getFirstAuditPersonId(),data.getSecondAuditPersonId(),data.getThirdAudtiPersonId());
        if(audits.size()!=3){
            throw new BusinessException("审核人员不能重复！");
        }
        data.setYear(data.getAuditYear());
        data.setFirstAuditPersonName(userMapper.selectUserById(data.getFirstAuditPersonId()).getLoginName());
        data.setSecondAuditPersonName(userMapper.selectUserById(data.getSecondAuditPersonId()).getLoginName());
        data.setThirdAuditPersonName(userMapper.selectUserById(data.getThirdAudtiPersonId()).getLoginName());
        return specialAuditModelMapper.updateById(data);
    }

    @Override
    public int audit(AuditReq req) {
        SpecialAuditModel annualReportAuditModel = specialAuditModelMapper.findById(req.getId());
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
        specialAuditModelMapper.updateById(annualReportAuditModel);
        return 1;
    }

    @Override
    public int back(Integer id) {
        SpecialAuditModel annualReportAuditModel = new SpecialAuditModel();
        annualReportAuditModel.setId(id);
        annualReportAuditModel.setState(RecordState.ABANDONED.getCode());
        return specialAuditModelMapper.updateById(annualReportAuditModel);
    }
}
