package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.ActivityMapper;
import com.etycx.system.domain.Activity;
import com.etycx.system.service.IActivityService;
import com.etycx.common.core.text.Convert;

/**
 * 活动 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
@Service
public class ActivityServiceImpl implements IActivityService 
{
	@Autowired
	private ActivityMapper activityMapper;

	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
    @Override
	public Activity selectActivityById(Integer id)
	{
	    return activityMapper.selectActivityById(id);
	}
	
	/**
     * 查询活动列表
     * 
     * @param activity 活动信息
     * @return 活动集合
     */
	@Override
	public List<Activity> selectActivityList(Activity activity)
	{
	    return activityMapper.selectActivityList(activity);
	}
	
    /**
     * 新增活动
     * 
     * @param activity 活动信息
     * @return 结果
     */
	@Override
	public int insertActivity(Activity activity)
	{
	    return activityMapper.insertActivity(activity);
	}
	
	/**
     * 修改活动
     * 
     * @param activity 活动信息
     * @return 结果
     */
	@Override
	public int updateActivity(Activity activity)
	{
	    return activityMapper.updateActivity(activity);
	}

	/**
     * 删除活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteActivityByIds(String ids)
	{
		return activityMapper.deleteActivityByIds(Convert.toStrArray(ids));
	}
	
}
