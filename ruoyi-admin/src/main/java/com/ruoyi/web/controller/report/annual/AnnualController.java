package com.ruoyi.web.controller.report.annual;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import com.ruoyi.system.service.zs.AnnualService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 年度
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/report/annual")
public class AnnualController extends BaseController {
    private String prefix = "report/annual";

    @Autowired
    private AnnualService annualService;

    @RequiresPermissions("report:annual:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/annual";
    }

    @RequiresPermissions("report:annual:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AnnualReportAuditModel annualReportAuditModel) {
        startPage();
        List<AnnualReportAuditModel> list = annualService.selectDeptList(annualReportAuditModel);
        return getDataTable(list);
    }

}
