package com.ruoyi.qichengtiyu.mapper;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuTontacts;

/**
 * 联系人Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public interface QichengtiyuTontactsMapper 
{
    /**
     * 查询联系人
     * 
     * @param tontactsId 联系人主键
     * @return 联系人
     */
    public QichengtiyuTontacts selectQichengtiyuTontactsByTontactsId(Long tontactsId);

    /**
     * 查询联系人列表
     * 
     * @param qichengtiyuTontacts 联系人
     * @return 联系人集合
     */
    public List<QichengtiyuTontacts> selectQichengtiyuTontactsList(QichengtiyuTontacts qichengtiyuTontacts);

    /**
     * 新增联系人
     * 
     * @param qichengtiyuTontacts 联系人
     * @return 结果
     */
    public int insertQichengtiyuTontacts(QichengtiyuTontacts qichengtiyuTontacts);

    /**
     * 修改联系人
     * 
     * @param qichengtiyuTontacts 联系人
     * @return 结果
     */
    public int updateQichengtiyuTontacts(QichengtiyuTontacts qichengtiyuTontacts);

    /**
     * 删除联系人
     * 
     * @param tontactsId 联系人主键
     * @return 结果
     */
    public int deleteQichengtiyuTontactsByTontactsId(Long tontactsId);

    /**
     * 批量删除联系人
     * 
     * @param tontactsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQichengtiyuTontactsByTontactsIds(String[] tontactsIds);
}
