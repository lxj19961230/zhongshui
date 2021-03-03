package com.ruoyi.system.service.zs.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.zs.RecordState;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.zs.AnnualReportAuditModelMapper;
import com.ruoyi.system.service.zs.AnnualService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/2/28 13:40
 */
@Service
public class AnnualServiceImpl implements AnnualService {

    @Autowired
    private AnnualReportAuditModelMapper annualReportAuditModelMapper;
    @Autowired
    private SysUserMapper userMapper;

    private final int startNum = 1001;

    @Override
    public List<AnnualReportAuditModel> selectDeptList(AnnualReportAuditModel model) {
        return annualReportAuditModelMapper.selectActiveList(model);
    }

    @Override
    public synchronized int insert(AnnualReportAuditModel data) {
        data.setYear(data.getAuditYear());
        Integer maxId = annualReportAuditModelMapper.findMaxId();
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

        return annualReportAuditModelMapper.save(data);
    }

    @Override
    public int deleteByIds(String ids) {
        if(StringUtils.isNotBlank(ids)){
            Integer[] ss = Convert.toIntArray(ids);
            for(Integer id:ss){
                AnnualReportAuditModel annualReportAuditModel = new AnnualReportAuditModel();
                annualReportAuditModel.setId(id);
                annualReportAuditModel.setIsDeleted(1);
                annualReportAuditModelMapper.updateById(annualReportAuditModel);
            }
        }
        return 1;
    }
}
