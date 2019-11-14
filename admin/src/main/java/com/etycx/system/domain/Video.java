package com.etycx.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.etycx.common.core.domain.BaseEntity;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 视频 表 video
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public class Video extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Integer id;
	/** 名称 */
	private String name;
	/** 视频简介 */
	private String briefIntroduction;
	/** 视频内容 */
	private String content;
	/** 图片路径 */
	private String picPath;
	/** 视频地址 */
	private String linkPath;

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/** 类别 */
	private Integer category;
	/** 启用状态 0 正常 1 停用 */
	private Integer status;
	/** 是否推荐 0 正常 1 推荐 */
	private Integer isRecommend;
	/** 是否收费 0 正常 1 付费 */
	private Integer isFree;
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
	public void setLinkPath(String linkPath) 
	{
		this.linkPath = linkPath;
	}

	public String getLinkPath() 
	{
		return linkPath;
	}
	public void setCategory(Integer category) 
	{
		this.category = category;
	}

	public Integer getCategory() 
	{
		return category;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setIsRecommend(Integer isRecommend) 
	{
		this.isRecommend = isRecommend;
	}

	public Integer getIsRecommend() 
	{
		return isRecommend;
	}
	public void setIsFree(Integer isFree) 
	{
		this.isFree = isFree;
	}

	public Integer getIsFree() 
	{
		return isFree;
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
            .append("linkPath", getLinkPath())
            .append("category", getCategory())
            .append("status", getStatus())
            .append("isRecommend", getIsRecommend())
            .append("isFree", getIsFree())
            .append("createTime", getCreateTime())
            .toString();
    }


	public static LinkedHashMap<String, Object> toMap(Video video){
		String baseUrl = "https://vip-esteam.com";
		LinkedHashMap<String, Object> map = new LinkedHashMap<>(4);
		map.put("videoId",video.getId());
		map.put("name",video.getName());
		map.put("briefIntroduction",video.getBriefIntroduction());
		map.put("picPath",baseUrl+video.getPicPath());
		return map;
	}
}
