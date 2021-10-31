package com.ruoyi.qichengtiyu.mapper;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuAbsent;

/**
 * 请假Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
public interface QichengtiyuAbsentMapper 
{
    /**
     * 查询请假
     * 
     * @param absentId 请假主键
     * @return 请假
     */
    public QichengtiyuAbsent selectQichengtiyuAbsentByAbsentId(Long absentId);

    /**
     * 查询请假列表
     * 
     * @param qichengtiyuAbsent 请假
     * @return 请假集合
     */
    public List<QichengtiyuAbsent> selectQichengtiyuAbsentList(QichengtiyuAbsent qichengtiyuAbsent);

    /**
     * 新增请假
     * 
     * @param qichengtiyuAbsent 请假
     * @return 结果
     */
    public int insertQichengtiyuAbsent(QichengtiyuAbsent qichengtiyuAbsent);

    /**
     * 修改请假
     * 
     * @param qichengtiyuAbsent 请假
     * @return 结果
     */
    public int updateQichengtiyuAbsent(QichengtiyuAbsent qichengtiyuAbsent);

    /**
     * 删除请假
     * 
     * @param absentId 请假主键
     * @return 结果
     */
    public int deleteQichengtiyuAbsentByAbsentId(Long absentId);

    /**
     * 批量删除请假
     * 
     * @param absentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQichengtiyuAbsentByAbsentIds(String[] absentIds);
}
