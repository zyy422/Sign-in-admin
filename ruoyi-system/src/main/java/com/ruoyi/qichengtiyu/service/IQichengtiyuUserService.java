package com.ruoyi.qichengtiyu.service;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuUser;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public interface IQichengtiyuUserService 
{
    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    public QichengtiyuUser selectQichengtiyuUserByUserId(Long userId);

    /**
     * 查询用户列表
     * 
     * @param qichengtiyuUser 用户
     * @return 用户集合
     */
    public List<QichengtiyuUser> selectQichengtiyuUserList(QichengtiyuUser qichengtiyuUser);

    /**
     * 新增用户
     * 
     * @param qichengtiyuUser 用户
     * @return 结果
     */
    public int insertQichengtiyuUser(QichengtiyuUser qichengtiyuUser);

    /**
     * 修改用户
     * 
     * @param qichengtiyuUser 用户
     * @return 结果
     */
    public int updateQichengtiyuUser(QichengtiyuUser qichengtiyuUser);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteQichengtiyuUserByUserIds(String userIds);

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteQichengtiyuUserByUserId(Long userId);
}
