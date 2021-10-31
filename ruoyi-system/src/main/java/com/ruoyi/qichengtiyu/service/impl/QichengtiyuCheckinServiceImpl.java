package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuCheckinMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCheckin;
import com.ruoyi.qichengtiyu.service.IQichengtiyuCheckinService;
import com.ruoyi.common.core.text.Convert;

/**
 * 签到Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
@Service
public class QichengtiyuCheckinServiceImpl implements IQichengtiyuCheckinService 
{
    @Autowired
    private QichengtiyuCheckinMapper qichengtiyuCheckinMapper;

    /**
     * 查询签到
     * 
     * @param signId 签到主键
     * @return 签到
     */
    @Override
    public QichengtiyuCheckin selectQichengtiyuCheckinBySignId(Long signId)
    {
        return qichengtiyuCheckinMapper.selectQichengtiyuCheckinBySignId(signId);
    }

    /**
     * 查询签到列表
     * 
     * @param qichengtiyuCheckin 签到
     * @return 签到
     */
    @Override
    public List<QichengtiyuCheckin> selectQichengtiyuCheckinList(QichengtiyuCheckin qichengtiyuCheckin)
    {
        return qichengtiyuCheckinMapper.selectQichengtiyuCheckinList(qichengtiyuCheckin);
    }

    /**
     * 新增签到
     * 
     * @param qichengtiyuCheckin 签到
     * @return 结果
     */
    @Override
    public int insertQichengtiyuCheckin(QichengtiyuCheckin qichengtiyuCheckin)
    {
        return qichengtiyuCheckinMapper.insertQichengtiyuCheckin(qichengtiyuCheckin);
    }

    /**
     * 修改签到
     * 
     * @param qichengtiyuCheckin 签到
     * @return 结果
     */
    @Override
    public int updateQichengtiyuCheckin(QichengtiyuCheckin qichengtiyuCheckin)
    {
        return qichengtiyuCheckinMapper.updateQichengtiyuCheckin(qichengtiyuCheckin);
    }

    /**
     * 批量删除签到
     * 
     * @param signIds 需要删除的签到主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuCheckinBySignIds(String signIds)
    {
        return qichengtiyuCheckinMapper.deleteQichengtiyuCheckinBySignIds(Convert.toStrArray(signIds));
    }

    /**
     * 删除签到信息
     * 
     * @param signId 签到主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuCheckinBySignId(Long signId)
    {
        return qichengtiyuCheckinMapper.deleteQichengtiyuCheckinBySignId(signId);
    }
}
