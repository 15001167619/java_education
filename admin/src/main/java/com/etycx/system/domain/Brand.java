package com.etycx.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.etycx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 品牌介绍表 brand
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public class Brand extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Integer id;
	/** 名称 */
	private String name;
	/** 简介 */
	private String briefIntroduction;
	/** 内容 */
	private String content;
	/** 图片路径 */
	private String picPath;
	/** 创建时间 */
	private Date createTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setBriefIntroduction(String briefIntroduction) 
	{
		this.briefIntroduction = briefIntroduction;
	}

	public String getBriefIntroduction() 
	{
		return briefIntroduction;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setPicPath(String picPath) 
	{
		this.picPath = picPath;
	}

	public String getPicPath() 
	{
		return picPath;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("briefIntroduction", getBriefIntroduction())
            .append("content", getContent())
            .append("picPath", getPicPath())
            .append("createTime", getCreateTime())
            .toString();
    }
}
