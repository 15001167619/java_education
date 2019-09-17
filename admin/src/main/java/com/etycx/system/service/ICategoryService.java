package com.etycx.system.service;

import com.etycx.system.domain.Category;
import java.util.List;

/**
 * 课程分类  服务层
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public interface ICategoryService 
{
	/**
     * 查询课程分类 信息
     * 
     * @param id 课程分类 ID
     * @return 课程分类 信息
     */
	public Category selectCategoryById(Integer id);
	
	/**
     * 查询课程分类 列表
     * 
     * @param category 课程分类 信息
     * @return 课程分类 集合
     */
	public List<Category> selectCategoryList(Category category);
	
	/**
     * 新增课程分类 
     * 
     * @param category 课程分类 信息
     * @return 结果
     */
	public int insertCategory(Category category);
	
	/**
     * 修改课程分类 
     * 
     * @param category 课程分类 信息
     * @return 结果
     */
	public int updateCategory(Category category);
		
	/**
     * 删除课程分类 信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCategoryByIds(String ids);
	
}
