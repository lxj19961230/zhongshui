package com.ruoyi.system.service.zs.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.zs.AuditEnum;
import com.ruoyi.common.enums.zs.RecordState;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.zs.CapitalVerificationModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.zs.CapitalVerificationModelMapper;
import com.ruoyi.system.mapper.zs.CapitalVerificationModelMapper;
import com.ruoyi.system.service.zs.CapitalService;
import com.ruoyi.system.service.zs.SpecialService;
import org.apache.commons.compress.utils.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CapitalServiceImpl implements CapitalService {

    @Autowired
    private CapitalVerificationModelMapper capitalVerificationModelMapper;
    @Autowired
    private SysUserMapper userMapper;

    private final int startNum = 200001;

    @Override
    public List<CapitalVerificationModel> selectDeptList(CapitalVerificationModel model) {
        return capitalVerificationModelMapper.selectActiveList(model);
    }

    @Override
    public synchronized int insert(CapitalVerificationModel data) {

        Set<Long> audits = Sets.newHashSet(data.getFirstAuditPersonId(),data.getSecondAuditPersonId(),data.getThirdAudtiPersonId());
        if(audits.size()!=3){
            throw new BusinessException("审核人员不能重复！");
        }

        data.setYear(LocalDate.now().getYear());
        Integer maxId = capitalVerificationModelMapper.findMaxId();
        if(Objects.isNull(maxId) || maxId<startNum){
            data.setId(startNum);
        }else {
            data.setId(maxId+1);
        }

        data.setReportSerial(Integer.valueOf(data.getYear()+""+data.getId()));
        data.setIsDeleted(0);
        data.setFirstAuditPersonName(userMapper.selectUserById(data.getFirstAuditPersonId()).getLoginName());
        data.setSecondAuditPersonName(userMapper.selectUserById(data.getSecondAuditPersonId()).getLoginName());
        data.setThirdAuditPersonName(userMapper.selectUserById(data.getThirdAudtiPersonId()).getLoginName());
        data.setState(RecordState.NEW.getCode());
        data.setUserId(userMapper.selectUserByLoginName(data.getUserName()).getUserId());

        return capitalVerificationModelMapper.save(data);
    }

    @Override
    public int deleteByIds(String ids) {
        if(StringUtils.isNotBlank(ids)){
            Integer[] ss = Convert.toIntArray(ids);
            for(Integer id:ss){
                CapitalVerificationModel annualReportAuditModel = new CapitalVerificationModel();
                annualReportAuditModel.setId(id);
                annualReportAuditModel.setIsDeleted(1);
                capitalVerificationModelMapper.updateById(annualReportAuditModel);
            }
        }
        return 1;
    }

    @Override
    public CapitalVerificationModel selectById(Integer id) {
        return capitalVerificationModelMapper.findById(id);
    }

    @Override
    public int update(CapitalVerificationModel data) {
        Set<Long> audits = Sets.newHashSet(data.getFirstAuditPersonId(),data.getSecondAuditPersonId(),data.getThirdAudtiPersonId());
        if(audits.size()!=3){
            throw new BusinessException("审核人员不能重复！");
        }
        data.setYear(data.getAuditYear());
        data.setFirstAuditPersonName(userMapper.selectUserById(data.getFirstAuditPersonId()).getLoginName());
        data.setSecondAuditPersonName(userMapper.selectUserById(data.getSecondAuditPersonId()).getLoginName());
        data.setThirdAuditPersonName(userMapper.selectUserById(data.getThirdAudtiPersonId()).getLoginName());
        return capitalVerificationModelMapper.updateById(data);
    }

    @Override
    public int audit(AuditReq req) {
        CapitalVerificationModel annualReportAuditModel = capitalVerificationModelMapper.findById(req.getId());
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
        capitalVerificationModelMapper.updateById(annualReportAuditModel);
        return 1;
    }

    @Override
    public int back(Integer id) {
        CapitalVerificationModel annualReportAuditModel = new CapitalVerificationModel();
        annualReportAuditModel.setId(id);
        annualReportAuditModel.setState(RecordState.ABANDONED.getCode());
        return capitalVerificationModelMapper.updateById(annualReportAuditModel);
    }
}
