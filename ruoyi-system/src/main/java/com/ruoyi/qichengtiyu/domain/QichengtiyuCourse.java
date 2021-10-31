package com.ruoyi.qichengtiyu.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 qichengtiyu_course
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
public class QichengtiyuCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 老师名称 */
    @Excel(name = "老师名称")
    private String courseTeacher;

    /** 课程类别 */
    private Long courseType;

    /** 课程价格 */
    @Excel(name = "课程价格")
    private BigDecimal coursePrice;

    /** 最大上课人数 */
    @Excel(name = "最大上课人数")
    private Long maxPeople;

    /** 已选课人数 */
    @Excel(name = "已选课人数")
    private Long selectedPeople;

    /** 课程地点 */
    @Excel(name = "课程地点")
    private String courseLocation;

    /** 课程详情 */
    @Excel(name = "课程详情")
    private String courseDesc;

    /** 课程效果 */
    @Excel(name = "课程效果")
    private String courseEffect;

    /** 适应年龄 */
    @Excel(name = "适应年龄")
    private String courseAge;

    /** 课程安排 */
    @Excel(name = "课程安排")
    private String courseArrange;

    /** 温馨提示 */
    @Excel(name = "温馨提示")
    private String courseTips;

    /** 图片路径 */
    private String courseImg;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseTeacher(String courseTeacher) 
    {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseTeacher() 
    {
        return courseTeacher;
    }
    public void setCourseType(Long courseType) 
    {
        this.courseType = courseType;
    }

    public Long getCourseType() 
    {
        return courseType;
    }
    public void setCoursePrice(BigDecimal coursePrice) 
    {
        this.coursePrice = coursePrice;
    }

    public BigDecimal getCoursePrice() 
    {
        return coursePrice;
    }
    public void setMaxPeople(Long maxPeople) 
    {
        this.maxPeople = maxPeople;
    }

    public Long getMaxPeople() 
    {
        return maxPeople;
    }
    public void setSelectedPeople(Long selectedPeople) 
    {
        this.selectedPeople = selectedPeople;
    }

    public Long getSelectedPeople() 
    {
        return selectedPeople;
    }
    public void setCourseLocation(String courseLocation) 
    {
        this.courseLocation = courseLocation;
    }

    public String getCourseLocation() 
    {
        return courseLocation;
    }
    public void setCourseDesc(String courseDesc) 
    {
        this.courseDesc = courseDesc;
    }

    public String getCourseDesc() 
    {
        return courseDesc;
    }
    public void setCourseEffect(String courseEffect) 
    {
        this.courseEffect = courseEffect;
    }

    public String getCourseEffect() 
    {
        return courseEffect;
    }
    public void setCourseAge(String courseAge) 
    {
        this.courseAge = courseAge;
    }

    public String getCourseAge() 
    {
        return courseAge;
    }
    public void setCourseArrange(String courseArrange) 
    {
        this.courseArrange = courseArrange;
    }

    public String getCourseArrange() 
    {
        return courseArrange;
    }
    public void setCourseTips(String courseTips) 
    {
        this.courseTips = courseTips;
    }

    public String getCourseTips() 
    {
        return courseTips;
    }
    public void setCourseImg(String courseImg) 
    {
        this.courseImg = courseImg;
    }

    public String getCourseImg() 
    {
        return courseImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("courseTeacher", getCourseTeacher())
            .append("courseType", getCourseType())
            .append("coursePrice", getCoursePrice())
            .append("maxPeople", getMaxPeople())
            .append("selectedPeople", getSelectedPeople())
            .append("courseLocation", getCourseLocation())
            .append("courseDesc", getCourseDesc())
            .append("courseEffect", getCourseEffect())
            .append("courseAge", getCourseAge())
            .append("courseArrange", getCourseArrange())
            .append("courseTips", getCourseTips())
            .append("courseImg", getCourseImg())
            .toString();
    }
}
