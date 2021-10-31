package com.ruoyi.qichengtiyu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 联系人对象 qichengtiyu_tontacts
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public class QichengtiyuTontacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 联系人id */
    @Excel(name = "联系人id")
    private Long tontactsId;

    /** 联系人名称 */
    @Excel(name = "联系人名称")
    private String tontactsName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String tontactsPhone;

    /** 联系人地址 */
    @Excel(name = "联系人地址")
    private String tontactsLocation;

    public void setTontactsId(Long tontactsId) 
    {
        this.tontactsId = tontactsId;
    }

    public Long getTontactsId() 
    {
        return tontactsId;
    }
    public void setTontactsName(String tontactsName) 
    {
        this.tontactsName = tontactsName;
    }

    public String getTontactsName() 
    {
        return tontactsName;
    }
    public void setTontactsPhone(String tontactsPhone) 
    {
        this.tontactsPhone = tontactsPhone;
    }

    public String getTontactsPhone() 
    {
        return tontactsPhone;
    }
    public void setTontactsLocation(String tontactsLocation) 
    {
        this.tontactsLocation = tontactsLocation;
    }

    public String getTontactsLocation() 
    {
        return tontactsLocation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tontactsId", getTontactsId())
            .append("tontactsName", getTontactsName())
            .append("tontactsPhone", getTontactsPhone())
            .append("tontactsLocation", getTontactsLocation())
            .toString();
    }
}
