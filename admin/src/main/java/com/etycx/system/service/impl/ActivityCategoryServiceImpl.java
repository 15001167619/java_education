package com.etycx.system.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.ActivityCategoryMapper;
import com.etycx.system.domain.ActivityCategory;
import com.etycx.system.service.IActivityCategoryService;
import com.etycx.common.core.text.Convert;

/**
 * 活动分类  服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
@Service
public class ActivityCategoryServiceImpl implements IActivityCategoryService 
{
	@Autowired
	private ActivityCategoryMapper activityCategoryMapper;

	/**
     * 查询活动分类 信息
     * 
     * @param id 活动分类 ID
     * @return 活动分类 信息
     */
    @Override
	public ActivityCategory selectActivityCategoryById(Integer id)
	{
	    return activityCategoryMapper.selectActivityCategoryById(id);
	}
	
	/**
     * 查询活动分类 列表
     * 
     * @param activityCategory 活动分类 信息
     * @return 活动分类 集合
     */
	@Override
	public List<ActivityCategory> selectActivityCategoryList(ActivityCategory activityCategory)
	{
	    return activityCategoryMapper.selectActivityCategoryList(activityCategory);
	}
	
    /**
     * 新增活动分类 
     * 
     * @param activityCategory 活动分类 信息
     * @return 结果
     */
	@Override
	public int insertActivityCategory(ActivityCategory activityCategory)
	{
	    return activityCategoryMapper.insertActivityCategory(activityCategory);
	}
	
	/**
     * 修改活动分类 
     * 
     * @param activityCategory 活动分类 信息
     * @return 结果
     */
	@Override
	public int updateActivityCategory(ActivityCategory activityCategory)
	{
	    return activityCategoryMapper.updateActivityCategory(activityCategory);
	}

	/**
     * 删除活动分类 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteActivityCategoryByIds(String ids)
	{
		return activityCategoryMapper.deleteActivityCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<HashMap> getCategoryList() {
		return activityCategoryMapper.getCategoryList();
	}

}
