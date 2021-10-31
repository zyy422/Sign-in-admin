package com.ruoyi.qichengtiyu.mapper;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuNews;

/**
 * 信息公告Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public interface QichengtiyuNewsMapper 
{
    /**
     * 查询信息公告
     * 
     * @param newsId 信息公告主键
     * @return 信息公告
     */
    public QichengtiyuNews selectQichengtiyuNewsByNewsId(Long newsId);

    /**
     * 查询信息公告列表
     * 
     * @param qichengtiyuNews 信息公告
     * @return 信息公告集合
     */
    public List<QichengtiyuNews> selectQichengtiyuNewsList(QichengtiyuNews qichengtiyuNews);

    /**
     * 新增信息公告
     * 
     * @param qichengtiyuNews 信息公告
     * @return 结果
     */
    public int insertQichengtiyuNews(QichengtiyuNews qichengtiyuNews);

    /**
     * 修改信息公告
     * 
     * @param qichengtiyuNews 信息公告
     * @return 结果
     */
    public int updateQichengtiyuNews(QichengtiyuNews qichengtiyuNews);

    /**
     * 删除信息公告
     * 
     * @param newsId 信息公告主键
     * @return 结果
     */
    public int deleteQichengtiyuNewsByNewsId(Long newsId);

    /**
     * 批量删除信息公告
     * 
     * @param newsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQichengtiyuNewsByNewsIds(String[] newsIds);
}
