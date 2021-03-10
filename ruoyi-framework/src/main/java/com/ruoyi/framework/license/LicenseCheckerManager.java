package com.ruoyi.framework.license;

import com.ruoyi.framework.license.loader.DccLicenseDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lxj 2019年6月3日
 */
//@Component
public class LicenseCheckerManager {

    private static final Logger log = LoggerFactory.getLogger(LicenseCheckerManager.class);

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    @Resource
    private License license;

    @Resource
    private LicenseChecker checker;

    @Resource
    private LicenseDataLoader loader;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void check() {
        this.license = License.get();
        if(this.loader != null) {
            this.license.setLicenseDataLoader(this.loader);
        } else {
            this.license.setLicenseDataLoader(new DccLicenseDataLoader());
        }
        doCheck();
        // 每30分钟检测一次授权
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                doCheck();
            }
        }, 30, 30, TimeUnit.MINUTES);
    }

    public void doCheck() {
        try {
            this.license.init();
            checker.check(license);
        } catch (LicenseException e) {
            log.error("Invalidation of authorization, stop service ", e);
            SpringApplication.exit(applicationContext, new ExitCodeGenerator() {

                @Override
                public int getExitCode() {
                    return -1;
                }
            });
            System.exit(-1);
        } catch (Throwable e) {
            log.error("", e);
        }
    }
}
