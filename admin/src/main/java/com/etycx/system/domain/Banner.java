package com.etycx.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.etycx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * banner 表 banner
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public class Banner extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Integer id;
	/** 名称 */
	private String name;
	/** 图片路径 */
	private String picPath;
	/** 排序 */
	private Integer sort;
	/** 启用状态 0 正常 1 停用 */
	private Integer status;
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
	public void setPicPath(String picPath) 
	{
		this.picPath = picPath;
	}

	public String getPicPath() 
	{
		return picPath;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
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
            .append("picPath", getPicPath())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
