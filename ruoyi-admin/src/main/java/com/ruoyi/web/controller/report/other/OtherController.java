package com.ruoyi.web.controller.report.other;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.domain.zs.OtherTaxAssuranceModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.zs.OtherService;
import com.ruoyi.web.controller.report.other.resp.OtherAuditResp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/report/other")
public class OtherController extends BaseController {
    private String prefix = "report/other";

    @Autowired
    private OtherService otherService;
    @Autowired
    private ISysUserOnlineService iSysUserOnlineService;
    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("report:other:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/other";
    }

    @RequiresPermissions("report:other:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OtherTaxAssuranceModel otherTaxAssuranceModel) {

        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        otherTaxAssuranceModel.setUserId(loginId);
        startPage();
        List<OtherTaxAssuranceModel> list = otherService.selectDeptList(otherTaxAssuranceModel);
        TableDataInfo tableDataInfo = getDataTable(list);
        List<OtherAuditResp> results = new ArrayList<>();
        for(OtherTaxAssuranceModel data:list){
            OtherAuditResp annualReportAuditResp = new OtherAuditResp();
            BeanUtils.copyProperties(data,annualReportAuditResp);
            if(data.getFirstAuditPersonId().longValue()==loginId.longValue() && Objects.nonNull(data.getFirstAuditDate())){
                annualReportAuditResp.setNeedAudit(2);
            }else if(data.getSecondAuditPersonId().longValue()==loginId.longValue() && Objects.nonNull(data.getSecondAuditDate())){
                annualReportAuditResp.setNeedAudit(2);
            }else if(data.getThirdAudtiPersonId().longValue()==loginId.longValue() && Objects.nonNull(data.getThirdAuditDate())){
                annualReportAuditResp.setNeedAudit(2);
            }else {
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
    @RequiresPermissions("report:other:add")
    @Log(title = "其他验资", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated OtherTaxAssuranceModel data)
    {
        return toAjax(otherService.insert(data));
    }

    @RequiresPermissions("report:other:remove")
    @Log(title = "其他验资", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(otherService.deleteByIds(ids));
    }

    @Log(title = "其他验资", businessType = BusinessType.EXPORT)
    @RequiresPermissions("report:other:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OtherTaxAssuranceModel auditModel)
    {
        List<OtherTaxAssuranceModel> list = (List<OtherTaxAssuranceModel>) list(auditModel).getRows();
        ExcelUtil<OtherTaxAssuranceModel> util = new ExcelUtil<>(OtherTaxAssuranceModel.class);
        return util.exportExcel(list, "_其他验资");
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", otherService.selectById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("report:other:edit")
    @Log(title = "其他验资", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated OtherTaxAssuranceModel annualReportAuditModel)
    {
        return toAjax(otherService.update(annualReportAuditModel));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", otherService.selectById(id));
        return prefix + "/detail";
    }

    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("data", otherService.selectById(id));
        return prefix + "/audit";
    }

    @RequiresPermissions("report:other:audit")
    @Log(title = "其他验资", businessType = BusinessType.UPDATE)
    @PostMapping("/audit")
    @ResponseBody
    public AjaxResult audit(@Validated AuditReq req)
    {
        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        req.setLoginUserId(loginId);
        return toAjax(otherService.audit(req));
    }

    @RequiresPermissions("report:other:edit")
    @Log(title = "其他验资", businessType = BusinessType.UPDATE)
    @PostMapping("/back")
    @ResponseBody
    public AjaxResult back(@Validated Integer id)
    {
        return toAjax(otherService.back(id));
    }
}
