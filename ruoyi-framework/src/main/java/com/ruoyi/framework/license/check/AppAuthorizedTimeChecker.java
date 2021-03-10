package com.ruoyi.framework.license.check;

import com.ruoyi.framework.license.License;
import com.ruoyi.framework.license.LicenseCheckerManager;
import com.ruoyi.framework.license.LicenseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @author zcy 2019年6月3日
 */
@Component
public class AppAuthorizedTimeChecker extends BaseAppChecker {

    private static final Logger log = LoggerFactory.getLogger(AppAuthorizedTimeChecker.class);

    public static final String KEY_START_TIME = "startTime";

    public static final String KEY_END_TIME = "endTime";

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void doCheck(License license) throws LicenseException {
        String startTimeKey = KEY_START_TIME;
        String endTimeKey = KEY_END_TIME;
        String startTimeStr = license.getString(startTimeKey);
        String endTimeStr = license.getString(endTimeKey);
        long startTime = 0, endTime = 0;
        try {
            startTime = formatter.parse(startTimeStr).getTime();
            endTime = formatter.parse(endTimeStr).getTime();
        } catch (Exception e) {
            log.warn("invalid format [{} {}]", startTimeStr, endTimeStr);
        }
        long nowTime = System.currentTimeMillis();
        if (nowTime < startTime || nowTime > endTime) {
            throw new LicenseException(startTimeKey + "-" + endTimeKey + "[" + startTimeStr + "-" + endTimeStr + "] unauthorized");
        }
    }
}
