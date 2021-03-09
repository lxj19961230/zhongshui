package com.ruoyi.web.controller.report.capital;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.domain.zs.CapitalVerificationModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.zs.CapitalService;
import com.ruoyi.web.controller.report.capital.resp.CapitalAuditResp;
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
@RequestMapping("/report/capital")
public class CapitalController extends BaseController {
    private String prefix = "report/capital";

    @Autowired
    private CapitalService capitalService;
    @Autowired
    private ISysUserOnlineService iSysUserOnlineService;
    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("report:capital:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/capital";
    }

    @RequiresPermissions("report:capital:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CapitalVerificationModel capitalVerificationModel) {

        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        capitalVerificationModel.setUserId(loginId);
        startPage();
        List<CapitalVerificationModel> list = capitalService.selectDeptList(capitalVerificationModel);
        TableDataInfo tableDataInfo = getDataTable(list);
        List<CapitalAuditResp> results = new ArrayList<>();
        for(CapitalVerificationModel data:list){
            CapitalAuditResp annualReportAuditResp = new CapitalAuditResp();
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
    @RequiresPermissions("report:capital:add")
    @Log(title = "验资", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated CapitalVerificationModel data)
    {
        return toAjax(capitalService.insert(data));
    }

    @RequiresPermissions("report:capital:remove")
    @Log(title = "验资", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(capitalService.deleteByIds(ids));
    }

    @Log(title = "验资", businessType = BusinessType.EXPORT)
    @RequiresPermissions("report:capital:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CapitalVerificationModel auditModel)
    {
        List<CapitalAuditResp> list = (List<CapitalAuditResp>) list(auditModel).getRows();
        ExcelUtil<CapitalAuditResp> util = new ExcelUtil<>(CapitalAuditResp.class);
        return util.exportExcel(list, "_验资");
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", capitalService.selectById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("report:capital:edit")
    @Log(title = "验资", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated CapitalVerificationModel data)
    {
        return toAjax(capitalService.update(data));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", capitalService.selectById(id));
        return prefix + "/detail";
    }

    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", capitalService.selectById(id));
        return prefix + "/audit";
    }

    @RequiresPermissions("report:capital:audit")
    @Log(title = "验资", businessType = BusinessType.UPDATE)
    @PostMapping("/audit")
    @ResponseBody
    public AjaxResult audit(@Validated AuditReq req)
    {
        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        req.setLoginUserId(loginId);
        return toAjax(capitalService.audit(req));
    }

    @RequiresPermissions("report:capital:edit")
    @Log(title = "验资", businessType = BusinessType.UPDATE)
    @PostMapping("/back")
    @ResponseBody
    public AjaxResult back(@Validated Integer id)
    {
        return toAjax(capitalService.back(id));
    }
}
