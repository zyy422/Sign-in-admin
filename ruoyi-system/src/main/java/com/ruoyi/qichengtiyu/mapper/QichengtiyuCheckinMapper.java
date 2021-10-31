package com.ruoyi.qichengtiyu.mapper;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCheckin;

/**
 * 签到Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
public interface QichengtiyuCheckinMapper 
{
    /**
     * 查询签到
     * 
     * @param signId 签到主键
     * @return 签到
     */
    public QichengtiyuCheckin selectQichengtiyuCheckinBySignId(Long signId);

    /**
     * 查询签到列表
     * 
     * @param qichengtiyuCheckin 签到
     * @return 签到集合
     */
    public List<QichengtiyuCheckin> selectQichengtiyuCheckinList(QichengtiyuCheckin qichengtiyuCheckin);

    /**
     * 新增签到
     * 
     * @param qichengtiyuCheckin 签到
     * @return 结果
     */
    public int insertQichengtiyuCheckin(QichengtiyuCheckin qichengtiyuCheckin);

    /**
     * 修改签到
     * 
     * @param qichengtiyuCheckin 签到
     * @return 结果
     */
    public int updateQichengtiyuCheckin(QichengtiyuCheckin qichengtiyuCheckin);

    /**
     * 删除签到
     * 
     * @param signId 签到主键
     * @return 结果
     */
    public int deleteQichengtiyuCheckinBySignId(Long signId);

    /**
     * 批量删除签到
     * 
     * @param signIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQichengtiyuCheckinBySignIds(String[] signIds);
}
