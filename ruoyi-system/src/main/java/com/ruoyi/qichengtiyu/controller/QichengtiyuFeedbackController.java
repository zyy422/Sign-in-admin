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
import com.ruoyi.qichengtiyu.domain.QichengtiyuFeedback;
import com.ruoyi.qichengtiyu.service.IQichengtiyuFeedbackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户评价Controller
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Controller
@RequestMapping("/qichengtiyu/feedback")
public class QichengtiyuFeedbackController extends BaseController
{
    private String prefix = "qichengtiyu/feedback";

    @Autowired
    private IQichengtiyuFeedbackService qichengtiyuFeedbackService;

    @RequiresPermissions("qichengtiyu:feedback:view")
    @GetMapping()
    public String feedback()
    {
        return prefix + "/feedback";
    }

    /**
     * 查询用户评价列表
     */
    @RequiresPermissions("qichengtiyu:feedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuFeedback qichengtiyuFeedback)
    {
        startPage();
        List<QichengtiyuFeedback> list = qichengtiyuFeedbackService.selectQichengtiyuFeedbackList(qichengtiyuFeedback);
        return getDataTable(list);
    }

    /**
     * 导出用户评价列表
     */
    @RequiresPermissions("qichengtiyu:feedback:export")
    @Log(title = "用户评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuFeedback qichengtiyuFeedback)
    {
        List<QichengtiyuFeedback> list = qichengtiyuFeedbackService.selectQichengtiyuFeedbackList(qichengtiyuFeedback);
        ExcelUtil<QichengtiyuFeedback> util = new ExcelUtil<QichengtiyuFeedback>(QichengtiyuFeedback.class);
        return util.exportExcel(list, "用户评价数据");
    }

    /**
     * 新增用户评价
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户评价
     */
    @RequiresPermissions("qichengtiyu:feedback:add")
    @Log(title = "用户评价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuFeedback qichengtiyuFeedback)
    {
        return toAjax(qichengtiyuFeedbackService.insertQichengtiyuFeedback(qichengtiyuFeedback));
    }

    /**
     * 修改用户评价
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        QichengtiyuFeedback qichengtiyuFeedback = qichengtiyuFeedbackService.selectQichengtiyuFeedbackByUserId(userId);
        mmap.put("qichengtiyuFeedback", qichengtiyuFeedback);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户评价
     */
    @RequiresPermissions("qichengtiyu:feedback:edit")
    @Log(title = "用户评价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuFeedback qichengtiyuFeedback)
    {
        return toAjax(qichengtiyuFeedbackService.updateQichengtiyuFeedback(qichengtiyuFeedback));
    }

    /**
     * 删除用户评价
     */
    @RequiresPermissions("qichengtiyu:feedback:remove")
    @Log(title = "用户评价", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuFeedbackService.deleteQichengtiyuFeedbackByUserIds(ids));
    }
}
