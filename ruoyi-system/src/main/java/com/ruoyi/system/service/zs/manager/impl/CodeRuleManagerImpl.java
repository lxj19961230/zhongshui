package com.ruoyi.system.service.zs.manager.impl;

import com.ruoyi.common.enums.zs.BizType;
import com.ruoyi.system.domain.zs.CodeRule;
import com.ruoyi.system.mapper.zs.CodeRuleMapper;
import com.ruoyi.system.service.zs.manager.CodeRuleManager;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/12 10:29
 */
@Component
public class CodeRuleManagerImpl implements CodeRuleManager {

    @Autowired
    private CodeRuleMapper codeRuleMapper;

    @Override
    public synchronized int getNextCode(BizType bizType, int year) {
        int code = 1;
        List<CodeRule> codeRules = codeRuleMapper.getAllDataForUpdateByTypeAndYear(year,bizType.getType());
        if(CollectionUtils.isEmpty(codeRules)){
            CodeRule codeRule = new CodeRule();
            codeRule.setActive(0);
            codeRule.setSequence(code);
            codeRule.setType(bizType.getType());
            codeRule.setYear(year);
            codeRuleMapper.save(codeRule);
            code = bizType.getCode()+code;
            return Integer.valueOf(year+""+code);
        }else {
            Map<Integer,List<CodeRule>> map = codeRules.stream().collect(Collectors.groupingBy(CodeRule::getActive));
            List<CodeRule> disactives = map.get(1);
            if(CollectionUtils.isNotEmpty(disactives)){
                OptionalInt data = codeRules.stream().mapToInt(CodeRule::getSequence).min();
                if(data.isPresent()){
                    code = data.getAsInt();
                    codeRuleMapper.updateActive(bizType.getType(),year,code);
                    code = bizType.getCode()+code;
                    return Integer.valueOf(year+""+code);
                }else {
                    throw new RuntimeException("查询失效码失败");
                }
            }else {
                OptionalInt data = codeRules.stream().mapToInt(CodeRule::getSequence).max();
                if(data.isPresent()){
                    code = data.getAsInt()+code;
                    CodeRule codeRule = new CodeRule();
                    codeRule.setActive(0);
                    codeRule.setSequence(code);
                    codeRule.setType(bizType.getType());
                    codeRule.setYear(year);
                    codeRuleMapper.save(codeRule);
                    code = bizType.getCode()+code;
                    return Integer.valueOf(year+""+code);
                }else {
                    throw new RuntimeException("查询失效码失败");
                }
            }
        }
    }
}
