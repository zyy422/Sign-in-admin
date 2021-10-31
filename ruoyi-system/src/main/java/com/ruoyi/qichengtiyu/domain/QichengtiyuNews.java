package com.ruoyi.qichengtiyu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信息公告对象 qichengtiyu_news
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public class QichengtiyuNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    @Excel(name = "公告id")
    private Long newsId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String newsTitle;

    /** 背景图片 */
    @Excel(name = "背景图片")
    private String newsBackground;

    /** 公告地点 */
    @Excel(name = "公告地点")
    private String newsLocation;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String newsContent;

    /** 公告时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "公告时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commentDatetime;

    public void setNewsId(Long newsId) 
    {
        this.newsId = newsId;
    }

    public Long getNewsId() 
    {
        return newsId;
    }
    public void setNewsTitle(String newsTitle) 
    {
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle() 
    {
        return newsTitle;
    }
    public void setNewsBackground(String newsBackground) 
    {
        this.newsBackground = newsBackground;
    }

    public String getNewsBackground() 
    {
        return newsBackground;
    }
    public void setNewsLocation(String newsLocation) 
    {
        this.newsLocation = newsLocation;
    }

    public String getNewsLocation() 
    {
        return newsLocation;
    }
    public void setNewsContent(String newsContent) 
    {
        this.newsContent = newsContent;
    }

    public String getNewsContent() 
    {
        return newsContent;
    }
    public void setCommentDatetime(Date commentDatetime) 
    {
        this.commentDatetime = commentDatetime;
    }

    public Date getCommentDatetime() 
    {
        return commentDatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsId", getNewsId())
            .append("newsTitle", getNewsTitle())
            .append("newsBackground", getNewsBackground())
            .append("newsLocation", getNewsLocation())
            .append("newsContent", getNewsContent())
            .append("commentDatetime", getCommentDatetime())
            .toString();
    }
}
