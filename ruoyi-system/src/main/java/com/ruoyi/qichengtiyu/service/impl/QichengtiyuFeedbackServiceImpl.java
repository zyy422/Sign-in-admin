package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuFeedbackMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuFeedback;
import com.ruoyi.qichengtiyu.service.IQichengtiyuFeedbackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Service
public class QichengtiyuFeedbackServiceImpl implements IQichengtiyuFeedbackService 
{
    @Autowired
    private QichengtiyuFeedbackMapper qichengtiyuFeedbackMapper;

    /**
     * 查询用户评价
     * 
     * @param userId 用户评价主键
     * @return 用户评价
     */
    @Override
    public QichengtiyuFeedback selectQichengtiyuFeedbackByUserId(Long userId)
    {
        return qichengtiyuFeedbackMapper.selectQichengtiyuFeedbackByUserId(userId);
    }

    /**
     * 查询用户评价列表
     * 
     * @param qichengtiyuFeedback 用户评价
     * @return 用户评价
     */
    @Override
    public List<QichengtiyuFeedback> selectQichengtiyuFeedbackList(QichengtiyuFeedback qichengtiyuFeedback)
    {
        return qichengtiyuFeedbackMapper.selectQichengtiyuFeedbackList(qichengtiyuFeedback);
    }

    /**
     * 新增用户评价
     * 
     * @param qichengtiyuFeedback 用户评价
     * @return 结果
     */
    @Override
    public int insertQichengtiyuFeedback(QichengtiyuFeedback qichengtiyuFeedback)
    {
        return qichengtiyuFeedbackMapper.insertQichengtiyuFeedback(qichengtiyuFeedback);
    }

    /**
     * 修改用户评价
     * 
     * @param qichengtiyuFeedback 用户评价
     * @return 结果
     */
    @Override
    public int updateQichengtiyuFeedback(QichengtiyuFeedback qichengtiyuFeedback)
    {
        return qichengtiyuFeedbackMapper.updateQichengtiyuFeedback(qichengtiyuFeedback);
    }

    /**
     * 批量删除用户评价
     * 
     * @param userIds 需要删除的用户评价主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuFeedbackByUserIds(String userIds)
    {
        return qichengtiyuFeedbackMapper.deleteQichengtiyuFeedbackByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除用户评价信息
     * 
     * @param userId 用户评价主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuFeedbackByUserId(Long userId)
    {
        return qichengtiyuFeedbackMapper.deleteQichengtiyuFeedbackByUserId(userId);
    }
}
