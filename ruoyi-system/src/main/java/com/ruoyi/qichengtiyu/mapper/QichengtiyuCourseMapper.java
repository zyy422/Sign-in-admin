package com.ruoyi.qichengtiyu.mapper;

import java.util.List;
import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;

/**
 * 课程Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
public interface QichengtiyuCourseMapper 
{
    /**
     * 查询课程
     * 
     * @param courseId 课程主键
     * @return 课程
     */
    public QichengtiyuCourse selectQichengtiyuCourseByCourseId(Long courseId);

    /**
     * 查询课程列表
     * 
     * @param qichengtiyuCourse 课程
     * @return 课程集合
     */
    public List<QichengtiyuCourse> selectQichengtiyuCourseList(QichengtiyuCourse qichengtiyuCourse);

    /**
     * 新增课程
     * 
     * @param qichengtiyuCourse 课程
     * @return 结果
     */
    public int insertQichengtiyuCourse(QichengtiyuCourse qichengtiyuCourse);

    /**
     * 修改课程
     * 
     * @param qichengtiyuCourse 课程
     * @return 结果
     */
    public int updateQichengtiyuCourse(QichengtiyuCourse qichengtiyuCourse);

    /**
     * 删除课程
     * 
     * @param courseId 课程主键
     * @return 结果
     */
    public int deleteQichengtiyuCourseByCourseId(Long courseId);

    /**
     * 批量删除课程
     * 
     * @param courseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQichengtiyuCourseByCourseIds(String[] courseIds);
}
