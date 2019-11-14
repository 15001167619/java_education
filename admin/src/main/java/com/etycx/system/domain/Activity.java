package com.etycx.system.domain;

import com.etycx.common.utils.DateUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.etycx.common.core.domain.BaseEntity;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 活动表 activity
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
public class Activity extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Integer id;
	private Integer category;

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

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

	public static LinkedHashMap<String, Object> toMap(Activity activity){
		String baseUrl = "https://vip-esteam.com";
		LinkedHashMap<String, Object> map = new LinkedHashMap<>(5);
		map.put("activityId",activity.getId());
		map.put("name",activity.getName());
		map.put("briefIntroduction",activity.getBriefIntroduction());
		map.put("picPath",baseUrl+activity.getPicPath());
		map.put("time",DateUtils.dateTime(activity.getCreateTime()));
		return map;
	}
}
