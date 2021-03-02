package com.ruoyi.framework.web.service;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/3/2 23:49
 */
@Service("sysdict")
public class SysDict {

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ISysDeptService iSysDeptService;

    public List<SysUser> getUserList()
    {
        SysUser sysUser = new SysUser();
        sysUser.setDelFlag(0+"");
        return iSysUserService.selectUserList(sysUser);
    }
    public List<SysDept> getDeptList()
    {
        SysDept sysDept = new SysDept();
        sysDept.setDelFlag(0+"");
        return iSysDeptService.selectDeptList(sysDept);
    }
}
