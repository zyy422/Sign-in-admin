package com.ruoyi.qichengtiyu.service;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuFeedback;

/**
 * 用户评价Service接口
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public interface IQichengtiyuFeedbackService 
{
    /**
     * 查询用户评价
     * 
     * @param userId 用户评价主键
     * @return 用户评价
     */
    public QichengtiyuFeedback selectQichengtiyuFeedbackByUserId(Long userId);

    /**
     * 查询用户评价列表
     * 
     * @param qichengtiyuFeedback 用户评价
     * @return 用户评价集合
     */
    public List<QichengtiyuFeedback> selectQichengtiyuFeedbackList(QichengtiyuFeedback qichengtiyuFeedback);

    /**
     * 新增用户评价
     * 
     * @param qichengtiyuFeedback 用户评价
     * @return 结果
     */
    public int insertQichengtiyuFeedback(QichengtiyuFeedback qichengtiyuFeedback);

    /**
     * 修改用户评价
     * 
     * @param qichengtiyuFeedback 用户评价
     * @return 结果
     */
    public int updateQichengtiyuFeedback(QichengtiyuFeedback qichengtiyuFeedback);

    /**
     * 批量删除用户评价
     * 
     * @param userIds 需要删除的用户评价主键集合
     * @return 结果
     */
    public int deleteQichengtiyuFeedbackByUserIds(String userIds);

    /**
     * 删除用户评价信息
     * 
     * @param userId 用户评价主键
     * @return 结果
     */
    public int deleteQichengtiyuFeedbackByUserId(Long userId);
}
