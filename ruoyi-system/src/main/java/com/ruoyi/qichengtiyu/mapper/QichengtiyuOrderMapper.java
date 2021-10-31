package com.ruoyi.qichengtiyu.mapper;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuOrder;

/**
 * 订单Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
public interface QichengtiyuOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public QichengtiyuOrder selectQichengtiyuOrderByOrderId(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param qichengtiyuOrder 订单
     * @return 订单集合
     */
    public List<QichengtiyuOrder> selectQichengtiyuOrderList(QichengtiyuOrder qichengtiyuOrder);

    /**
     * 新增订单
     * 
     * @param qichengtiyuOrder 订单
     * @return 结果
     */
    public int insertQichengtiyuOrder(QichengtiyuOrder qichengtiyuOrder);

    /**
     * 修改订单
     * 
     * @param qichengtiyuOrder 订单
     * @return 结果
     */
    public int updateQichengtiyuOrder(QichengtiyuOrder qichengtiyuOrder);

    /**
     * 删除订单
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteQichengtiyuOrderByOrderId(Long orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQichengtiyuOrderByOrderIds(String[] orderIds);
}
