package com.ruoyi.qichengtiyu.service;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuAbsent;

/**
 * 请假Service接口
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
public interface IQichengtiyuAbsentService 
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
     * 批量删除请假
     * 
     * @param absentIds 需要删除的请假主键集合
     * @return 结果
     */
    public int deleteQichengtiyuAbsentByAbsentIds(String absentIds);

    /**
     * 删除请假信息
     * 
     * @param absentId 请假主键
     * @return 结果
     */
    public int deleteQichengtiyuAbsentByAbsentId(Long absentId);
}
