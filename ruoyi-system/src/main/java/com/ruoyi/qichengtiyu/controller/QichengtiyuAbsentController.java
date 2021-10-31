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
import com.ruoyi.qichengtiyu.domain.QichengtiyuAbsent;
import com.ruoyi.qichengtiyu.service.IQichengtiyuAbsentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 请假Controller
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
@Controller
@RequestMapping("/qichengtiyu/absent")
public class QichengtiyuAbsentController extends BaseController
{
    private String prefix = "qichengtiyu/absent";

    @Autowired
    private IQichengtiyuAbsentService qichengtiyuAbsentService;

    @RequiresPermissions("qichengtiyu:absent:view")
    @GetMapping()
    public String absent()
    {
        return prefix + "/absent";
    }

    /**
     * 查询请假列表
     */
    @RequiresPermissions("qichengtiyu:absent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuAbsent qichengtiyuAbsent)
    {
        startPage();
        List<QichengtiyuAbsent> list = qichengtiyuAbsentService.selectQichengtiyuAbsentList(qichengtiyuAbsent);
        return getDataTable(list);
    }

    /**
     * 导出请假列表
     */
    @RequiresPermissions("qichengtiyu:absent:export")
    @Log(title = "请假", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuAbsent qichengtiyuAbsent)
    {
        List<QichengtiyuAbsent> list = qichengtiyuAbsentService.selectQichengtiyuAbsentList(qichengtiyuAbsent);
        ExcelUtil<QichengtiyuAbsent> util = new ExcelUtil<QichengtiyuAbsent>(QichengtiyuAbsent.class);
        return util.exportExcel(list, "请假数据");
    }

    /**
     * 新增请假
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存请假
     */
    @RequiresPermissions("qichengtiyu:absent:add")
    @Log(title = "请假", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuAbsent qichengtiyuAbsent)
    {
        return toAjax(qichengtiyuAbsentService.insertQichengtiyuAbsent(qichengtiyuAbsent));
    }

    /**
     * 修改请假
     */
    @GetMapping("/edit/{absentId}")
    public String edit(@PathVariable("absentId") Long absentId, ModelMap mmap)
    {
        QichengtiyuAbsent qichengtiyuAbsent = qichengtiyuAbsentService.selectQichengtiyuAbsentByAbsentId(absentId);
        mmap.put("qichengtiyuAbsent", qichengtiyuAbsent);
        return prefix + "/edit";
    }

    /**
     * 修改保存请假
     */
    @RequiresPermissions("qichengtiyu:absent:edit")
    @Log(title = "请假", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuAbsent qichengtiyuAbsent)
    {
        return toAjax(qichengtiyuAbsentService.updateQichengtiyuAbsent(qichengtiyuAbsent));
    }

    /**
     * 删除请假
     */
    @RequiresPermissions("qichengtiyu:absent:remove")
    @Log(title = "请假", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuAbsentService.deleteQichengtiyuAbsentByAbsentIds(ids));
    }
}
