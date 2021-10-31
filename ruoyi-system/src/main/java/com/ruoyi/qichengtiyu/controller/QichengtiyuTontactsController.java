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
import com.ruoyi.qichengtiyu.domain.QichengtiyuTontacts;
import com.ruoyi.qichengtiyu.service.IQichengtiyuTontactsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 联系人Controller
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Controller
@RequestMapping("/qichengtiyu/tontacts")
public class QichengtiyuTontactsController extends BaseController
{
    private String prefix = "qichengtiyu/tontacts";

    @Autowired
    private IQichengtiyuTontactsService qichengtiyuTontactsService;

    @RequiresPermissions("qichengtiyu:tontacts:view")
    @GetMapping()
    public String tontacts()
    {
        return prefix + "/tontacts";
    }

    /**
     * 查询联系人列表
     */
    @RequiresPermissions("qichengtiyu:tontacts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuTontacts qichengtiyuTontacts)
    {
        startPage();
        List<QichengtiyuTontacts> list = qichengtiyuTontactsService.selectQichengtiyuTontactsList(qichengtiyuTontacts);
        return getDataTable(list);
    }

    /**
     * 导出联系人列表
     */
    @RequiresPermissions("qichengtiyu:tontacts:export")
    @Log(title = "联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuTontacts qichengtiyuTontacts)
    {
        List<QichengtiyuTontacts> list = qichengtiyuTontactsService.selectQichengtiyuTontactsList(qichengtiyuTontacts);
        ExcelUtil<QichengtiyuTontacts> util = new ExcelUtil<QichengtiyuTontacts>(QichengtiyuTontacts.class);
        return util.exportExcel(list, "联系人数据");
    }

    /**
     * 新增联系人
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存联系人
     */
    @RequiresPermissions("qichengtiyu:tontacts:add")
    @Log(title = "联系人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuTontacts qichengtiyuTontacts)
    {
        return toAjax(qichengtiyuTontactsService.insertQichengtiyuTontacts(qichengtiyuTontacts));
    }

    /**
     * 修改联系人
     */
    @GetMapping("/edit/{tontactsId}")
    public String edit(@PathVariable("tontactsId") Long tontactsId, ModelMap mmap)
    {
        QichengtiyuTontacts qichengtiyuTontacts = qichengtiyuTontactsService.selectQichengtiyuTontactsByTontactsId(tontactsId);
        mmap.put("qichengtiyuTontacts", qichengtiyuTontacts);
        return prefix + "/edit";
    }

    /**
     * 修改保存联系人
     */
    @RequiresPermissions("qichengtiyu:tontacts:edit")
    @Log(title = "联系人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuTontacts qichengtiyuTontacts)
    {
        return toAjax(qichengtiyuTontactsService.updateQichengtiyuTontacts(qichengtiyuTontacts));
    }

    /**
     * 删除联系人
     */
    @RequiresPermissions("qichengtiyu:tontacts:remove")
    @Log(title = "联系人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuTontactsService.deleteQichengtiyuTontactsByTontactsIds(ids));
    }
}
