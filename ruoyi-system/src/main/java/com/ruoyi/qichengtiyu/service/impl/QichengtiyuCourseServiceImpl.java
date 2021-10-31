package com.ruoyi.qichengtiyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.qichengtiyu.mapper.QichengtiyuCourseMapper;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;
import com.ruoyi.qichengtiyu.service.IQichengtiyuCourseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
@Service
public class QichengtiyuCourseServiceImpl implements IQichengtiyuCourseService 
{
    @Autowired
    private QichengtiyuCourseMapper qichengtiyuCourseMapper;

    /**
     * 查询课程
     * 
     * @param courseId 课程主键
     * @return 课程
     */
    @Override
    public QichengtiyuCourse selectQichengtiyuCourseByCourseId(Long courseId)
    {
        return qichengtiyuCourseMapper.selectQichengtiyuCourseByCourseId(courseId);
    }

    /**
     * 查询课程列表
     * 
     * @param qichengtiyuCourse 课程
     * @return 课程
     */
    @Override
    public List<QichengtiyuCourse> selectQichengtiyuCourseList(QichengtiyuCourse qichengtiyuCourse)
    {
        return qichengtiyuCourseMapper.selectQichengtiyuCourseList(qichengtiyuCourse);
    }

    /**
     * 新增课程
     * 
     * @param qichengtiyuCourse 课程
     * @return 结果
     */
    @Override
    public int insertQichengtiyuCourse(QichengtiyuCourse qichengtiyuCourse)
    {
        return qichengtiyuCourseMapper.insertQichengtiyuCourse(qichengtiyuCourse);
    }

    /**
     * 修改课程
     * 
     * @param qichengtiyuCourse 课程
     * @return 结果
     */
    @Override
    public int updateQichengtiyuCourse(QichengtiyuCourse qichengtiyuCourse)
    {
        return qichengtiyuCourseMapper.updateQichengtiyuCourse(qichengtiyuCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param courseIds 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuCourseByCourseIds(String courseIds)
    {
        return qichengtiyuCourseMapper.deleteQichengtiyuCourseByCourseIds(Convert.toStrArray(courseIds));
    }

    /**
     * 删除课程信息
     * 
     * @param courseId 课程主键
     * @return 结果
     */
    @Override
    public int deleteQichengtiyuCourseByCourseId(Long courseId)
    {
        return qichengtiyuCourseMapper.deleteQichengtiyuCourseByCourseId(courseId);
    }
}
