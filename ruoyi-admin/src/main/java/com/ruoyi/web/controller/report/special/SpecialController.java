package com.ruoyi.web.controller.report.special;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.domain.zs.SpecialAuditModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.zs.SpecialService;
import com.ruoyi.web.controller.report.special.resp.SpecialReportAuditResp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/report/special")
public class SpecialController extends BaseController {
    private String prefix = "report/special";

    @Autowired
    private SpecialService specialService;
    @Autowired
    private ISysUserOnlineService iSysUserOnlineService;
    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("report:special:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/special";
    }

    @RequiresPermissions("report:special:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpecialAuditModel specialAuditModel) {

        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        specialAuditModel.setUserId(loginId);
        startPage();
        List<SpecialAuditModel> list = specialService.selectDeptList(specialAuditModel);
        TableDataInfo tableDataInfo = getDataTable(list);
        List<SpecialReportAuditResp> results = new ArrayList<>();
        for(SpecialAuditModel data:list){
            SpecialReportAuditResp annualReportAuditResp = new SpecialReportAuditResp();
            BeanUtils.copyProperties(data,annualReportAuditResp);
            if(data.getFirstAuditPersonId().longValue()==loginId.longValue() || data.getSecondAuditPersonId().longValue()==loginId.longValue()||data.getThirdAudtiPersonId().longValue()==loginId.longValue()){
                annualReportAuditResp.setNeedAudit(1);
            }
            if(data.getUserId().longValue()==loginId.longValue()){
                annualReportAuditResp.setNeedOper(1);
            }
            results.add(annualReportAuditResp);
        }
        tableDataInfo.setRows(results);
        return tableDataInfo;
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
    @RequiresPermissions("report:special:add")
    @Log(title = "专项审计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SpecialAuditModel data)
    {
        return toAjax(specialService.insert(data));
    }

    @RequiresPermissions("report:special:remove")
    @Log(title = "专项审计", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(specialService.deleteByIds(ids));
    }

    @Log(title = "专项审计", businessType = BusinessType.EXPORT)
    @RequiresPermissions("report:special:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpecialAuditModel auditModel)
    {
        List<SpecialAuditModel> list = (List<SpecialAuditModel>) list(auditModel).getRows();
        ExcelUtil<SpecialAuditModel> util = new ExcelUtil<>(SpecialAuditModel.class);
        return util.exportExcel(list, "_专项审计");
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", specialService.selectById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("report:special:edit")
    @Log(title = "专项审计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SpecialAuditModel annualReportAuditModel)
    {
        return toAjax(specialService.update(annualReportAuditModel));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", specialService.selectById(id));
        return prefix + "/detail";
    }

    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", specialService.selectById(id));
        return prefix + "/audit";
    }

    @RequiresPermissions("report:special:audit")
    @Log(title = "专项审计", businessType = BusinessType.UPDATE)
    @PostMapping("/audit")
    @ResponseBody
    public AjaxResult audit(@Validated AuditReq req)
    {
        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        req.setLoginUserId(loginId);
        return toAjax(specialService.audit(req));
    }

    @RequiresPermissions("report:special:edit")
    @Log(title = "专项审计", businessType = BusinessType.UPDATE)
    @PostMapping("/back")
    @ResponseBody
    public AjaxResult back(@Validated Integer id)
    {
        return toAjax(specialService.back(id));
    }
}
