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
import com.ruoyi.qichengtiyu.domain.QichengtiyuOrder;
import com.ruoyi.qichengtiyu.service.IQichengtiyuOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
@Controller
@RequestMapping("/qichengtiyu/order")
public class QichengtiyuOrderController extends BaseController
{
    private String prefix = "qichengtiyu/order";

    @Autowired
    private IQichengtiyuOrderService qichengtiyuOrderService;

    @RequiresPermissions("qichengtiyu:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("qichengtiyu:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QichengtiyuOrder qichengtiyuOrder)
    {
        startPage();
        List<QichengtiyuOrder> list = qichengtiyuOrderService.selectQichengtiyuOrderList(qichengtiyuOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("qichengtiyu:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QichengtiyuOrder qichengtiyuOrder)
    {
        List<QichengtiyuOrder> list = qichengtiyuOrderService.selectQichengtiyuOrderList(qichengtiyuOrder);
        ExcelUtil<QichengtiyuOrder> util = new ExcelUtil<QichengtiyuOrder>(QichengtiyuOrder.class);
        return util.exportExcel(list, "订单数据");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("qichengtiyu:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QichengtiyuOrder qichengtiyuOrder)
    {
        return toAjax(qichengtiyuOrderService.insertQichengtiyuOrder(qichengtiyuOrder));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
    {
        QichengtiyuOrder qichengtiyuOrder = qichengtiyuOrderService.selectQichengtiyuOrderByOrderId(orderId);
        mmap.put("qichengtiyuOrder", qichengtiyuOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("qichengtiyu:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QichengtiyuOrder qichengtiyuOrder)
    {
        return toAjax(qichengtiyuOrderService.updateQichengtiyuOrder(qichengtiyuOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("qichengtiyu:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qichengtiyuOrderService.deleteQichengtiyuOrderByOrderIds(ids));
    }
}
