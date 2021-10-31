package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuOrderMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuOrder;
import com.ruoyi.qichengtiyu.service.IQichengtiyuOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
@Service
public class QichengtiyuOrderServiceImpl implements IQichengtiyuOrderService 
{
    @Autowired
    private QichengtiyuOrderMapper qichengtiyuOrderMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public QichengtiyuOrder selectQichengtiyuOrderByOrderId(Long orderId)
    {
        return qichengtiyuOrderMapper.selectQichengtiyuOrderByOrderId(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param qichengtiyuOrder 订单
     * @return 订单
     */
    @Override
    public List<QichengtiyuOrder> selectQichengtiyuOrderList(QichengtiyuOrder qichengtiyuOrder)
    {
        return qichengtiyuOrderMapper.selectQichengtiyuOrderList(qichengtiyuOrder);
    }

    /**
     * 新增订单
     * 
     * @param qichengtiyuOrder 订单
     * @return 结果
     */
    @Override
    public int insertQichengtiyuOrder(QichengtiyuOrder qichengtiyuOrder)
    {
        return qichengtiyuOrderMapper.insertQichengtiyuOrder(qichengtiyuOrder);
    }

    /**
     * 修改订单
     * 
     * @param qichengtiyuOrder 订单
     * @return 结果
     */
    @Override
    public int updateQichengtiyuOrder(QichengtiyuOrder qichengtiyuOrder)
    {
        return qichengtiyuOrderMapper.updateQichengtiyuOrder(qichengtiyuOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuOrderByOrderIds(String orderIds)
    {
        return qichengtiyuOrderMapper.deleteQichengtiyuOrderByOrderIds(Convert.toStrArray(orderIds));
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuOrderByOrderId(Long orderId)
    {
        return qichengtiyuOrderMapper.deleteQichengtiyuOrderByOrderId(orderId);
    }
}
