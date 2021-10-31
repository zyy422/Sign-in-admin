package com.ruoyi.qichengtiyu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 请假对象 qichengtiyu_absent
 * 
 * @author ruoyi
 * @date 2021-09-20
 */
public class QichengtiyuAbsent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假序号 */
    @Excel(name = "请假序号")
    private Long absentId;

    /** 订单序号 */
    private Long orderId;

    /** 课程序号 */
    @Excel(name = "课程序号")
    private String courseId;

    /** 课程日期 */
    @Excel(name = "课程日期")
    private String courseDate;

    /** 学生序号 */
    @Excel(name = "学生序号")
    private String studentId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 是否请假 */
    @Excel(name = "是否请假")
    private Integer isAbsent;

    /** 请假日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假日期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date absentDatetime;

    /** 核销日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核销日期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkedDatetime;

    /** 学生昵称 */
    @Excel(name = "学生昵称")
    private String studentNickname;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String username;

    public void setAbsentId(Long absentId) 
    {
        this.absentId = absentId;
    }

    public Long getAbsentId() 
    {
        return absentId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setCourseId(String courseId) 
    {
        this.courseId = courseId;
    }

    public String getCourseId() 
    {
        return courseId;
    }
    public void setCourseDate(String courseDate) 
    {
        this.courseDate = courseDate;
    }

    public String getCourseDate() 
    {
        return courseDate;
    }
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setIsAbsent(Integer isAbsent) 
    {
        this.isAbsent = isAbsent;
    }

    public Integer getIsAbsent() 
    {
        return isAbsent;
    }
    public void setAbsentDatetime(Date absentDatetime) 
    {
        this.absentDatetime = absentDatetime;
    }

    public Date getAbsentDatetime() 
    {
        return absentDatetime;
    }
    public void setCheckedDatetime(Date checkedDatetime) 
    {
        this.checkedDatetime = checkedDatetime;
    }

    public Date getCheckedDatetime() 
    {
        return checkedDatetime;
    }
    public void setStudentNickname(String studentNickname) 
    {
        this.studentNickname = studentNickname;
    }

    public String getStudentNickname() 
    {
        return studentNickname;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("absentId", getAbsentId())
            .append("orderId", getOrderId())
            .append("courseId", getCourseId())
            .append("courseDate", getCourseDate())
            .append("studentId", getStudentId())
            .append("courseName", getCourseName())
            .append("isAbsent", getIsAbsent())
            .append("absentDatetime", getAbsentDatetime())
            .append("checkedDatetime", getCheckedDatetime())
            .append("studentNickname", getStudentNickname())
            .append("username", getUsername())
            .toString();
    }
}
