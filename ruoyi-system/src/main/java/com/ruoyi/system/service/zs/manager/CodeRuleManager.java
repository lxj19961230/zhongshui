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
    public int getNextCode(BizType bizType, int year);


}
