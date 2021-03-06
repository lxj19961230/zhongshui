package com.ruoyi.web.controller.report.annual;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.domain.zs.AnnualReportAuditModel;
import com.ruoyi.system.domain.zs.other.AuditReq;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.zs.AnnualService;
import com.ruoyi.web.controller.report.annual.resp.AnnualReportAuditResp;
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
    @Autowired
    private ISysUserService iSysUserService;

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

        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        annualReportAuditModel.setUserId(loginId);
        startPage();
        List<AnnualReportAuditModel> list = annualService.selectDeptList(annualReportAuditModel);
        TableDataInfo tableDataInfo = getDataTable(list);
        List<AnnualReportAuditResp> results = new ArrayList<>();
        for(AnnualReportAuditModel data:list){
            AnnualReportAuditResp annualReportAuditResp = new AnnualReportAuditResp();
            BeanUtils.copyProperties(data,annualReportAuditResp);
            if(data.getFirstAuditPersonId().longValue()==loginId.longValue() || data.getSecondAuditPersonId().longValue()==loginId.longValue()||data.getThirdAudtiPersonId().longValue()==loginId.longValue()){
                if(data.getFirstAuditPersonId().longValue()==loginId.longValue() && Objects.nonNull(data.getFirstAuditDate())){
                    annualReportAuditResp.setNeedAudit(2);
                }else if(data.getSecondAuditPersonId().longValue()==loginId.longValue() && Objects.nonNull(data.getSecondAuditDate())){
                    annualReportAuditResp.setNeedAudit(2);
                }else if(data.getThirdAudtiPersonId().longValue()==loginId.longValue() && Objects.nonNull(data.getThirdAuditDate())){
                    annualReportAuditResp.setNeedAudit(2);
                }else {
                    annualReportAuditResp.setNeedAudit(1);
                }
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
    @RequiresPermissions("report:annual:add")
    @Log(title = "年报审计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AnnualReportAuditModel data)
    {
        return toAjax(annualService.insert(data));
    }

    @RequiresPermissions("report:annual:remove")
    @Log(title = "年报审计", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(annualService.deleteByIds(ids));
    }

    @Log(title = "年报审计", businessType = BusinessType.EXPORT)
    @RequiresPermissions("report:annual:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AnnualReportAuditModel auditModel)
    {
        List<AnnualReportAuditModel> list = (List<AnnualReportAuditModel>) list(auditModel).getRows();
        ExcelUtil<AnnualReportAuditModel> util = new ExcelUtil<>(AnnualReportAuditModel.class);
        return util.exportExcel(list, "_年报审计");
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("annual", annualService.selectById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("report:annual:edit")
    @Log(title = "年报审计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated AnnualReportAuditModel annualReportAuditModel)
    {
        return toAjax(annualService.update(annualReportAuditModel));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("annual", annualService.selectById(id));
        return prefix + "/detail";
    }

    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("annual", annualService.selectById(id));
        return prefix + "/audit";
    }

    @GetMapping("/file/{id}")
    public String upload(@PathVariable("id") Integer id, ModelMap mmap)
    {
        //mmap.put("data", annualService.selectById(id));
        return prefix + "/file";
    }


    @RequiresPermissions("report:annual:audit")
    @Log(title = "年报审计", businessType = BusinessType.UPDATE)
    @PostMapping("/audit")
    @ResponseBody
    public AjaxResult audit(@Validated AuditReq req)
    {
        SysUserOnline sysUserOnline = iSysUserOnlineService.selectOnlineById(getSession().getId());
        Long loginId = iSysUserService.selectUserByLoginName(sysUserOnline.getLoginName()).getUserId();
        req.setLoginUserId(loginId);
        return toAjax(annualService.audit(req));
    }

    @RequiresPermissions("report:annual:edit")
    @Log(title = "年报审计", businessType = BusinessType.UPDATE)
    @PostMapping("/back")
    @ResponseBody
    public AjaxResult back(@Validated Integer id)
    {
        return toAjax(annualService.back(id));
    }
}
