package com.ruoyi.framework.license.check;

import com.ruoyi.framework.license.License;
import com.ruoyi.framework.license.LicenseChecker;


/**
 * @author zcy 2019年11月14日
 */
public abstract class BaseChecker implements LicenseChecker {

    /**
     * 计算目标key的值是否为true，如果key不存在或者脚本运行失败，则返回默认值 defaultEnable
     * 
     * @param key
     * @param license
     * @param defaultEnable
     * @return
     */
    protected boolean checkerEnable(String key, License license, boolean defaultEnable) {
        return true;
    }
}
