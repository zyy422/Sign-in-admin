package com.ruoyi.qichengtiyu.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 qichengtiyu_order
 * 
 * @author ruoyi
 * @date 2021-10-02
 */
public class QichengtiyuOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 学生id */
    @Excel(name = "学生id")
    private String studentId;

    /** 上课时间(星期几) */
    @Excel(name = "上课时间(星期几)")
    private String courseWeek;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private BigDecimal payAmt;

    /** 微信昵称 */
    @Excel(name = "微信昵称")
    private String studentNickname;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String username;

    /** 购买的课程数量 */
    @Excel(name = "购买的课程数量")
    private Long totalCourse;

    /** 剩余的课程数量 */
    @Excel(name = "剩余的课程数量")
    private Long remainCourse;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
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
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }
    public void setCourseWeek(String courseWeek) 
    {
        this.courseWeek = courseWeek;
    }

    public String getCourseWeek() 
    {
        return courseWeek;
    }
    public void setPayAmt(BigDecimal payAmt) 
    {
        this.payAmt = payAmt;
    }

    public BigDecimal getPayAmt() 
    {
        return payAmt;
    }
    public void setStudentNickname(String studentNickname) 
    {
        this.studentNickname = studentNickname;
    }

    public String getStudentNickname() 
    {
        return studentNickname;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setTotalCourse(Long totalCourse) 
    {
        this.totalCourse = totalCourse;
    }

    public Long getTotalCourse() 
    {
        return totalCourse;
    }
    public void setRemainCourse(Long remainCourse) 
    {
        this.remainCourse = remainCourse;
    }

    public Long getRemainCourse() 
    {
        return remainCourse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("studentId", getStudentId())
            .append("courseWeek", getCourseWeek())
            .append("payAmt", getPayAmt())
            .append("studentNickname", getStudentNickname())
            .append("payTime", getPayTime())
            .append("username", getUsername())
            .append("totalCourse", getTotalCourse())
            .append("remainCourse", getRemainCourse())
            .toString();
    }
}
