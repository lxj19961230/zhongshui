package com.ruoyi.system.service.zs.manager;

import com.ruoyi.common.enums.zs.BizType;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/12 10:28
 */
public interface CodeRuleManager {


    /**
     * 功能描述: 获取文件号
     * @auther: lxj 2021/3/12 10:28
     */
    int getNextCode(BizType bizType, Integer bizId,int year);

    Boolean disactive(BizType otherTaxAssurance, Integer id);
}
