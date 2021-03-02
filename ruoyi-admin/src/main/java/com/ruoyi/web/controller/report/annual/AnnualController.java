package com.ruoyi.web.controller.report.annual;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.zs.AnnualService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    private ISysUserOnlineService iSysUserOnlineService;

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

    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.addAttribute("loginUser",iSysUserOnlineService.selectOnlineById(getSession().getId()));
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("annual:report:add")
    @Log(title = "年报审计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AnnualReportAuditModel data)
    {
        return toAjax(annualService.insert(data));
    }


}
