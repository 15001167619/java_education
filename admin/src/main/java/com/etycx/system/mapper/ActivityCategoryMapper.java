package com.etycx.system.mapper;

import com.etycx.system.domain.ActivityCategory;
import java.util.List;	

/**
 * 活动分类  数据层
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
public interface ActivityCategoryMapper 
{
	/**
     * 查询活动分类 信息
     * 
     * @param id 活动分类 ID
     * @return 活动分类 信息
     */
	public ActivityCategory selectActivityCategoryById(Integer id);
	
	/**
     * 查询活动分类 列表
     * 
     * @param activityCategory 活动分类 信息
     * @return 活动分类 集合
     */
	public List<ActivityCategory> selectActivityCategoryList(ActivityCategory activityCategory);
	
	/**
     * 新增活动分类 
     * 
     * @param activityCategory 活动分类 信息
     * @return 结果
     */
	public int insertActivityCategory(ActivityCategory activityCategory);
	
	/**
     * 修改活动分类 
     * 
     * @param activityCategory 活动分类 信息
     * @return 结果
     */
	public int updateActivityCategory(ActivityCategory activityCategory);
	
	/**
     * 删除活动分类 
     * 
     * @param id 活动分类 ID
     * @return 结果
     */
	public int deleteActivityCategoryById(Integer id);
	
	/**
     * 批量删除活动分类 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteActivityCategoryByIds(String[] ids);
	
}