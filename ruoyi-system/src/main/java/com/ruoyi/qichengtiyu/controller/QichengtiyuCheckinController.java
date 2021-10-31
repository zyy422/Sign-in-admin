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
import com.ruoyi.qichengtiyu.domain.QichengtiyuCheckin;
import com.ruoyi.qichengtiyu.service.IQichengtiyuCheckinService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 签到Controller
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
@Controller
@RequestMapping("/qichengtiyu/checkin")
public class QichengtiyuCheckinController extends BaseController
{
    private String prefix = "qichengtiyu/checkin";

    @Autowired
    private IQichengtiyuCheckinService qichengtiyuCheckinService;

    @RequiresPermissions("qichengtiyu:checkin:view")
    @GetMapping()
    public String checkin()
    {
        return prefix + "/checkin";
    }

    /**
     * 查询签到列表
     */
    @RequiresPermissions("qichengtiyu:checkin:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuCheckin qichengtiyuCheckin)
    {
        startPage();
        List<QichengtiyuCheckin> list = qichengtiyuCheckinService.selectQichengtiyuCheckinList(qichengtiyuCheckin);
        return getDataTable(list);
    }

    /**
     * 导出签到列表
     */
    @RequiresPermissions("qichengtiyu:checkin:export")
    @Log(title = "签到", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuCheckin qichengtiyuCheckin)
    {
        List<QichengtiyuCheckin> list = qichengtiyuCheckinService.selectQichengtiyuCheckinList(qichengtiyuCheckin);
        ExcelUtil<QichengtiyuCheckin> util = new ExcelUtil<QichengtiyuCheckin>(QichengtiyuCheckin.class);
        return util.exportExcel(list, "签到数据");
    }

    /**
     * 新增签到
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存签到
     */
    @RequiresPermissions("qichengtiyu:checkin:add")
    @Log(title = "签到", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuCheckin qichengtiyuCheckin)
    {
        return toAjax(qichengtiyuCheckinService.insertQichengtiyuCheckin(qichengtiyuCheckin));
    }

    /**
     * 修改签到
     */
    @GetMapping("/edit/{signId}")
    public String edit(@PathVariable("signId") Long signId, ModelMap mmap)
    {
        QichengtiyuCheckin qichengtiyuCheckin = qichengtiyuCheckinService.selectQichengtiyuCheckinBySignId(signId);
        mmap.put("qichengtiyuCheckin", qichengtiyuCheckin);
        return prefix + "/edit";
    }

    /**
     * 修改保存签到
     */
    @RequiresPermissions("qichengtiyu:checkin:edit")
    @Log(title = "签到", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuCheckin qichengtiyuCheckin)
    {
        return toAjax(qichengtiyuCheckinService.updateQichengtiyuCheckin(qichengtiyuCheckin));
    }

    /**
     * 删除签到
     */
    @RequiresPermissions("qichengtiyu:checkin:remove")
    @Log(title = "签到", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuCheckinService.deleteQichengtiyuCheckinBySignIds(ids));
    }
}
