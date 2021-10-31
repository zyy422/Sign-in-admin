package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuUserMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuUser;
import com.ruoyi.qichengtiyu.service.IQichengtiyuUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Service
public class QichengtiyuUserServiceImpl implements IQichengtiyuUserService 
{
    @Autowired
    private QichengtiyuUserMapper qichengtiyuUserMapper;

    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    @Override
    public QichengtiyuUser selectQichengtiyuUserByUserId(Long userId)
    {
        return qichengtiyuUserMapper.selectQichengtiyuUserByUserId(userId);
    }

    /**
     * 查询用户列表
     * 
     * @param qichengtiyuUser 用户
     * @return 用户
     */
    @Override
    public List<QichengtiyuUser> selectQichengtiyuUserList(QichengtiyuUser qichengtiyuUser)
    {
        return qichengtiyuUserMapper.selectQichengtiyuUserList(qichengtiyuUser);
    }

    /**
     * 新增用户
     * 
     * @param qichengtiyuUser 用户
     * @return 结果
     */
    @Override
    public int insertQichengtiyuUser(QichengtiyuUser qichengtiyuUser)
    {
        return qichengtiyuUserMapper.insertQichengtiyuUser(qichengtiyuUser);
    }

    /**
     * 修改用户
     * 
     * @param qichengtiyuUser 用户
     * @return 结果
     */
    @Override
    public int updateQichengtiyuUser(QichengtiyuUser qichengtiyuUser)
    {
        qichengtiyuUser.setUpdateTime(DateUtils.getNowDate());
        return qichengtiyuUserMapper.updateQichengtiyuUser(qichengtiyuUser);
    }

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuUserByUserIds(String userIds)
    {
        return qichengtiyuUserMapper.deleteQichengtiyuUserByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuUserByUserId(Long userId)
    {
        return qichengtiyuUserMapper.deleteQichengtiyuUserByUserId(userId);
    }
}
