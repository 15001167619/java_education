package com.etycx.system.mapper;

import com.etycx.system.domain.AboutUs;
import java.util.List;	

/**
 * 关于我们 数据层
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
public interface AboutUsMapper 
{
	/**
     * 查询关于我们信息
     * 
     * @param id 关于我们ID
     * @return 关于我们信息
     */
	public AboutUs selectAboutUsById(Integer id);
	
	/**
     * 查询关于我们列表
     * 
     * @param aboutUs 关于我们信息
     * @return 关于我们集合
     */
	public List<AboutUs> selectAboutUsList(AboutUs aboutUs);
	
	/**
     * 新增关于我们
     * 
     * @param aboutUs 关于我们信息
     * @return 结果
     */
	public int insertAboutUs(AboutUs aboutUs);
	
	/**
     * 修改关于我们
     * 
     * @param aboutUs 关于我们信息
     * @return 结果
     */
	public int updateAboutUs(AboutUs aboutUs);
	
	/**
     * 删除关于我们
     * 
     * @param id 关于我们ID
     * @return 结果
     */
	public int deleteAboutUsById(Integer id);
	
	/**
     * 批量删除关于我们
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAboutUsByIds(String[] ids);
	
}