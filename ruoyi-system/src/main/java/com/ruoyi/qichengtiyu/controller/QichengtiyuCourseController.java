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
import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;
import com.ruoyi.qichengtiyu.service.IQichengtiyuCourseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程Controller
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
@Controller
@RequestMapping("/qichengtiyu/course")
public class QichengtiyuCourseController extends BaseController
{
    private String prefix = "qichengtiyu/course";

    @Autowired
    private IQichengtiyuCourseService qichengtiyuCourseService;

    @RequiresPermissions("qichengtiyu:course:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("qichengtiyu:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuCourse qichengtiyuCourse)
    {
        startPage();
        List<QichengtiyuCourse> list = qichengtiyuCourseService.selectQichengtiyuCourseList(qichengtiyuCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @RequiresPermissions("qichengtiyu:course:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuCourse qichengtiyuCourse)
    {
        List<QichengtiyuCourse> list = qichengtiyuCourseService.selectQichengtiyuCourseList(qichengtiyuCourse);
        ExcelUtil<QichengtiyuCourse> util = new ExcelUtil<QichengtiyuCourse>(QichengtiyuCourse.class);
        return util.exportExcel(list, "课程数据");
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程
     */
    @RequiresPermissions("qichengtiyu:course:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuCourse qichengtiyuCourse)
    {
        return toAjax(qichengtiyuCourseService.insertQichengtiyuCourse(qichengtiyuCourse));
    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{courseId}")
    public String edit(@PathVariable("courseId") Long courseId, ModelMap mmap)
    {
        QichengtiyuCourse qichengtiyuCourse = qichengtiyuCourseService.selectQichengtiyuCourseByCourseId(courseId);
        mmap.put("qichengtiyuCourse", qichengtiyuCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("qichengtiyu:course:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuCourse qichengtiyuCourse)
    {
        return toAjax(qichengtiyuCourseService.updateQichengtiyuCourse(qichengtiyuCourse));
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("qichengtiyu:course:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuCourseService.deleteQichengtiyuCourseByCourseIds(ids));
    }
}
