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
import com.ruoyi.qichengtiyu.domain.QichengtiyuNews;
import com.ruoyi.qichengtiyu.service.IQichengtiyuNewsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 信息公告Controller
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Controller
@RequestMapping("/qichengtiyu/news")
public class QichengtiyuNewsController extends BaseController
{
    private String prefix = "qichengtiyu/news";

    @Autowired
    private IQichengtiyuNewsService qichengtiyuNewsService;

    @RequiresPermissions("qichengtiyu:news:view")
    @GetMapping()
    public String news()
    {
        return prefix + "/news";
    }

    /**
     * 查询信息公告列表
     */
    @RequiresPermissions("qichengtiyu:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuNews qichengtiyuNews)
    {
        startPage();
        List<QichengtiyuNews> list = qichengtiyuNewsService.selectQichengtiyuNewsList(qichengtiyuNews);
        return getDataTable(list);
    }

    /**
     * 导出信息公告列表
     */
    @RequiresPermissions("qichengtiyu:news:export")
    @Log(title = "信息公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuNews qichengtiyuNews)
    {
        List<QichengtiyuNews> list = qichengtiyuNewsService.selectQichengtiyuNewsList(qichengtiyuNews);
        ExcelUtil<QichengtiyuNews> util = new ExcelUtil<QichengtiyuNews>(QichengtiyuNews.class);
        return util.exportExcel(list, "信息公告数据");
    }

    /**
     * 新增信息公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存信息公告
     */
    @RequiresPermissions("qichengtiyu:news:add")
    @Log(title = "信息公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuNews qichengtiyuNews)
    {
        return toAjax(qichengtiyuNewsService.insertQichengtiyuNews(qichengtiyuNews));
    }

    /**
     * 修改信息公告
     */
    @GetMapping("/edit/{newsId}")
    public String edit(@PathVariable("newsId") Long newsId, ModelMap mmap)
    {
        QichengtiyuNews qichengtiyuNews = qichengtiyuNewsService.selectQichengtiyuNewsByNewsId(newsId);
        mmap.put("qichengtiyuNews", qichengtiyuNews);
        return prefix + "/edit";
    }

    /**
     * 修改保存信息公告
     */
    @RequiresPermissions("qichengtiyu:news:edit")
    @Log(title = "信息公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuNews qichengtiyuNews)
    {
        return toAjax(qichengtiyuNewsService.updateQichengtiyuNews(qichengtiyuNews));
    }

    /**
     * 删除信息公告
     */
    @RequiresPermissions("qichengtiyu:news:remove")
    @Log(title = "信息公告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuNewsService.deleteQichengtiyuNewsByNewsIds(ids));
    }
}
