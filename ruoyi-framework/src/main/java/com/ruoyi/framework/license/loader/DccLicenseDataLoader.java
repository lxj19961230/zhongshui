package com.ruoyi.framework.license.loader;


import com.ruoyi.common.utils.IOUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.license.LicenseDataLoader;
import com.ruoyi.framework.license.LicenseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Base64;

/**
 * @author lxj 2021
 */
@Component
public class DccLicenseDataLoader implements LicenseDataLoader {

    public static String LICENSE = null;

    @Override
    public byte[] load() {
        try {
            if(StringUtils.isBlank(LICENSE)){
                URL resource = getClass().getClassLoader().getResource("arc.lic");
                byte[] data = IOUtils.readAllBytes(new File(resource.getFile()));
                LICENSE = Base64.getEncoder().encodeToString(data);
            }
            return Base64.getDecoder().decode(LICENSE);
        } catch (Throwable e) {
            throw new LicenseException("load license data from dcc fail", e);
        }
    }
}
