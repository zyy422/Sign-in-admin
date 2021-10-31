package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuAbsentMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuAbsent;
import com.ruoyi.qichengtiyu.service.IQichengtiyuAbsentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 请假Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
@Service
public class QichengtiyuAbsentServiceImpl implements IQichengtiyuAbsentService 
{
    @Autowired
    private QichengtiyuAbsentMapper qichengtiyuAbsentMapper;

    /**
     * 查询请假
     * 
     * @param absentId 请假主键
     * @return 请假
     */
    @Override
    public QichengtiyuAbsent selectQichengtiyuAbsentByAbsentId(Long absentId)
    {
        return qichengtiyuAbsentMapper.selectQichengtiyuAbsentByAbsentId(absentId);
    }

    /**
     * 查询请假列表
     * 
     * @param qichengtiyuAbsent 请假
     * @return 请假
     */
    @Override
    public List<QichengtiyuAbsent> selectQichengtiyuAbsentList(QichengtiyuAbsent qichengtiyuAbsent)
    {
        return qichengtiyuAbsentMapper.selectQichengtiyuAbsentList(qichengtiyuAbsent);
    }

    /**
     * 新增请假
     * 
     * @param qichengtiyuAbsent 请假
     * @return 结果
     */
    @Override
    public int insertQichengtiyuAbsent(QichengtiyuAbsent qichengtiyuAbsent)
    {
        return qichengtiyuAbsentMapper.insertQichengtiyuAbsent(qichengtiyuAbsent);
    }

    /**
     * 修改请假
     * 
     * @param qichengtiyuAbsent 请假
     * @return 结果
     */
    @Override
    public int updateQichengtiyuAbsent(QichengtiyuAbsent qichengtiyuAbsent)
    {
        return qichengtiyuAbsentMapper.updateQichengtiyuAbsent(qichengtiyuAbsent);
    }

    /**
     * 批量删除请假
     * 
     * @param absentIds 需要删除的请假主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuAbsentByAbsentIds(String absentIds)
    {
        return qichengtiyuAbsentMapper.deleteQichengtiyuAbsentByAbsentIds(Convert.toStrArray(absentIds));
    }

    /**
     * 删除请假信息
     * 
     * @param absentId 请假主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuAbsentByAbsentId(Long absentId)
    {
        return qichengtiyuAbsentMapper.deleteQichengtiyuAbsentByAbsentId(absentId);
    }
}
