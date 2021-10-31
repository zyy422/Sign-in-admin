package com.ruoyi.qichengtiyu.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.qichengtiyu.domain.QichengtiyuUser;
import com.ruoyi.qichengtiyu.service.IQichengtiyuUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Controller
@RequestMapping("/qichengtiyu/user")
public class QichengtiyuUserController extends BaseController
{
    private String prefix = "qichengtiyu/user";

    @Autowired
    private IQichengtiyuUserService qichengtiyuUserService;

    @RequiresPermissions("qichengtiyu:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("qichengtiyu:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuUser qichengtiyuUser)
    {
        startPage();
        List<QichengtiyuUser> list = qichengtiyuUserService.selectQichengtiyuUserList(qichengtiyuUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("qichengtiyu:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuUser qichengtiyuUser)
    {
        List<QichengtiyuUser> list = qichengtiyuUserService.selectQichengtiyuUserList(qichengtiyuUser);
        ExcelUtil<QichengtiyuUser> util = new ExcelUtil<QichengtiyuUser>(QichengtiyuUser.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("qichengtiyu:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuUser qichengtiyuUser)
    {
        return toAjax(qichengtiyuUserService.insertQichengtiyuUser(qichengtiyuUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        QichengtiyuUser qichengtiyuUser = qichengtiyuUserService.selectQichengtiyuUserByUserId(userId);
        mmap.put("qichengtiyuUser", qichengtiyuUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("qichengtiyu:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuUser qichengtiyuUser)
    {
        return toAjax(qichengtiyuUserService.updateQichengtiyuUser(qichengtiyuUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("qichengtiyu:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuUserService.deleteQichengtiyuUserByUserIds(ids));
    }
}
