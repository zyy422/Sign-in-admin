package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuTontactsMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuTontacts;
import com.ruoyi.qichengtiyu.service.IQichengtiyuTontactsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 联系人Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Service
public class QichengtiyuTontactsServiceImpl implements IQichengtiyuTontactsService 
{
    @Autowired
    private QichengtiyuTontactsMapper qichengtiyuTontactsMapper;

    /**
     * 查询联系人
     * 
     * @param tontactsId 联系人主键
     * @return 联系人
     */
    @Override
    public QichengtiyuTontacts selectQichengtiyuTontactsByTontactsId(Long tontactsId)
    {
        return qichengtiyuTontactsMapper.selectQichengtiyuTontactsByTontactsId(tontactsId);
    }

    /**
     * 查询联系人列表
     * 
     * @param qichengtiyuTontacts 联系人
     * @return 联系人
     */
    @Override
    public List<QichengtiyuTontacts> selectQichengtiyuTontactsList(QichengtiyuTontacts qichengtiyuTontacts)
    {
        return qichengtiyuTontactsMapper.selectQichengtiyuTontactsList(qichengtiyuTontacts);
    }

    /**
     * 新增联系人
     * 
     * @param qichengtiyuTontacts 联系人
     * @return 结果
     */
    @Override
    public int insertQichengtiyuTontacts(QichengtiyuTontacts qichengtiyuTontacts)
    {
        return qichengtiyuTontactsMapper.insertQichengtiyuTontacts(qichengtiyuTontacts);
    }

    /**
     * 修改联系人
     * 
     * @param qichengtiyuTontacts 联系人
     * @return 结果
     */
    @Override
    public int updateQichengtiyuTontacts(QichengtiyuTontacts qichengtiyuTontacts)
    {
        return qichengtiyuTontactsMapper.updateQichengtiyuTontacts(qichengtiyuTontacts);
    }

    /**
     * 批量删除联系人
     * 
     * @param tontactsIds 需要删除的联系人主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuTontactsByTontactsIds(String tontactsIds)
    {
        return qichengtiyuTontactsMapper.deleteQichengtiyuTontactsByTontactsIds(Convert.toStrArray(tontactsIds));
    }

    /**
     * 删除联系人信息
     * 
     * @param tontactsId 联系人主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuTontactsByTontactsId(Long tontactsId)
    {
        return qichengtiyuTontactsMapper.deleteQichengtiyuTontactsByTontactsId(tontactsId);
    }
}
