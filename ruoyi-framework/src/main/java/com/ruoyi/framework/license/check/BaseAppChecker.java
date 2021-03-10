package com.ruoyi.framework.license.check;

import com.ruoyi.framework.license.License;
import com.ruoyi.framework.license.LicenseException;

/**
 * @author zcy 2019年11月14日
 */
public abstract class BaseAppChecker extends BaseChecker {

    @Override
    public void check(License license) throws LicenseException {
        doCheck(license);
    }
    
    protected abstract void doCheck(License license) throws LicenseException;
}
