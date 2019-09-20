package com.etycx.system.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.CategoryMapper;
import com.etycx.system.domain.Category;
import com.etycx.system.service.ICategoryService;
import com.etycx.common.core.text.Convert;

/**
 * 课程分类  服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
	@Autowired
	private CategoryMapper categoryMapper;

	/**
     * 查询课程分类 信息
     * 
     * @param id 课程分类 ID
     * @return 课程分类 信息
     */
    @Override
	public Category selectCategoryById(Integer id)
	{
	    return categoryMapper.selectCategoryById(id);
	}
	
	/**
     * 查询课程分类 列表
     * 
     * @param category 课程分类 信息
     * @return 课程分类 集合
     */
	@Override
	public List<Category> selectCategoryList(Category category)
	{
	    return categoryMapper.selectCategoryList(category);
	}
	
    /**
     * 新增课程分类 
     * 
     * @param category 课程分类 信息
     * @return 结果
     */
	@Override
	public int insertCategory(Category category)
	{
	    return categoryMapper.insertCategory(category);
	}
	
	/**
     * 修改课程分类 
     * 
     * @param category 课程分类 信息
     * @return 结果
     */
	@Override
	public int updateCategory(Category category)
	{
	    return categoryMapper.updateCategory(category);
	}

	/**
     * 删除课程分类 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCategoryByIds(String ids)
	{
		return categoryMapper.deleteCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<LinkedHashMap> getCategoryList() {
		return categoryMapper.getCategoryList();
	}

}
