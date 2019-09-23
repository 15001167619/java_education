package com.etycx.system.service;

import com.etycx.system.domain.Activity;
import java.util.List;

/**
 * 活动 服务层
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
public interface IActivityService 
{
	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
	public Activity selectActivityById(Integer id);
	
	/**
     * 查询活动列表
     * 
     * @param activity 活动信息
     * @return 活动集合
     */
	public List<Activity> selectActivityList(Activity activity);
	
	/**
     * 新增活动
     * 
     * @param activity 活动信息
     * @return 结果
     */
	public int insertActivity(Activity activity);
	
	/**
     * 修改活动
     * 
     * @param activity 活动信息
     * @return 结果
     */
	public int updateActivity(Activity activity);
		
	/**
     * 删除活动信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteActivityByIds(String ids);
	
}
