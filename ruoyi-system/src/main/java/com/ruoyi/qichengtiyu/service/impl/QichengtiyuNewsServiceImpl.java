package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuNewsMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuNews;
import com.ruoyi.qichengtiyu.service.IQichengtiyuNewsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 信息公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Service
public class QichengtiyuNewsServiceImpl implements IQichengtiyuNewsService 
{
    @Autowired
    private QichengtiyuNewsMapper qichengtiyuNewsMapper;

    /**
     * 查询信息公告
     * 
     * @param newsId 信息公告主键
     * @return 信息公告
     */
    @Override
    public QichengtiyuNews selectQichengtiyuNewsByNewsId(Long newsId)
    {
        return qichengtiyuNewsMapper.selectQichengtiyuNewsByNewsId(newsId);
    }

    /**
     * 查询信息公告列表
     * 
     * @param qichengtiyuNews 信息公告
     * @return 信息公告
     */
    @Override
    public List<QichengtiyuNews> selectQichengtiyuNewsList(QichengtiyuNews qichengtiyuNews)
    {
        return qichengtiyuNewsMapper.selectQichengtiyuNewsList(qichengtiyuNews);
    }

    /**
     * 新增信息公告
     * 
     * @param qichengtiyuNews 信息公告
     * @return 结果
     */
    @Override
    public int insertQichengtiyuNews(QichengtiyuNews qichengtiyuNews)
    {
        return qichengtiyuNewsMapper.insertQichengtiyuNews(qichengtiyuNews);
    }

    /**
     * 修改信息公告
     * 
     * @param qichengtiyuNews 信息公告
     * @return 结果
     */
    @Override
    public int updateQichengtiyuNews(QichengtiyuNews qichengtiyuNews)
    {
        return qichengtiyuNewsMapper.updateQichengtiyuNews(qichengtiyuNews);
    }

    /**
     * 批量删除信息公告
     * 
     * @param newsIds 需要删除的信息公告主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuNewsByNewsIds(String newsIds)
    {
        return qichengtiyuNewsMapper.deleteQichengtiyuNewsByNewsIds(Convert.toStrArray(newsIds));
    }

    /**
     * 删除信息公告信息
     * 
     * @param newsId 信息公告主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuNewsByNewsId(Long newsId)
    {
        return qichengtiyuNewsMapper.deleteQichengtiyuNewsByNewsId(newsId);
    }
}
