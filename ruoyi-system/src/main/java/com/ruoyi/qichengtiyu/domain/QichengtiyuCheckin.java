package com.ruoyi.qichengtiyu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 签到对象 qichengtiyu_checkin
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
public class QichengtiyuCheckin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 签到序号 */
    private Long signId;

    /** 订单序号 */
    @Excel(name = "订单序号")
    private Long orderId;

    /** 课程序号 */
    @Excel(name = "课程序号")
    private String courseId;

    /** 课程日期 */
    @Excel(name = "课程日期")
    private String courseDate;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 学生序号 */
    @Excel(name = "学生序号")
    private String studentId;

    /** 是否签到 */
    @Excel(name = "是否签到")
    private Integer isSigned;

    /** 签到日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签到日期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDatetime;

    /** 是否核销 */
    @Excel(name = "是否核销")
    private Integer ischecked;

    /** 学生昵称 */
    @Excel(name = "学生昵称")
    private String studentNickname;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String username;

    /** 核销日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核销日期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkedDatetime;

    /** 签到人 */
    @Excel(name = "签到人")
    private String checkinUser;

    public void setSignId(Long signId) 
    {
        this.signId = signId;
    }

    public Long getSignId() 
    {
        return signId;
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
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }
    public void setIsSigned(Integer isSigned) 
    {
        this.isSigned = isSigned;
    }

    public Integer getIsSigned() 
    {
        return isSigned;
    }
    public void setSignDatetime(Date signDatetime) 
    {
        this.signDatetime = signDatetime;
    }

    public Date getSignDatetime() 
    {
        return signDatetime;
    }
    public void setIschecked(Integer ischecked) 
    {
        this.ischecked = ischecked;
    }

    public Integer getIschecked() 
    {
        return ischecked;
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
    public void setCheckedDatetime(Date checkedDatetime) 
    {
        this.checkedDatetime = checkedDatetime;
    }

    public Date getCheckedDatetime() 
    {
        return checkedDatetime;
    }
    public void setCheckinUser(String checkinUser) 
    {
        this.checkinUser = checkinUser;
    }

    public String getCheckinUser() 
    {
        return checkinUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("signId", getSignId())
            .append("orderId", getOrderId())
            .append("courseId", getCourseId())
            .append("courseDate", getCourseDate())
            .append("courseName", getCourseName())
            .append("studentId", getStudentId())
            .append("isSigned", getIsSigned())
            .append("signDatetime", getSignDatetime())
            .append("ischecked", getIschecked())
            .append("studentNickname", getStudentNickname())
            .append("username", getUsername())
            .append("checkedDatetime", getCheckedDatetime())
            .append("checkinUser", getCheckinUser())
            .toString();
    }
}
