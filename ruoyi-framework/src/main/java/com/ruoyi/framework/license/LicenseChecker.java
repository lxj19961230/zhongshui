package com.ruoyi.framework.license;

/**
 * @author zcy 2019年6月3日
 */
public interface LicenseChecker {

    public void check(License license) throws LicenseException;
}
