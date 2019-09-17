package com.etycx.system.service;

import com.etycx.system.domain.Brand;
import java.util.List;

/**
 * 品牌介绍 服务层
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public interface IBrandService 
{
	/**
     * 查询品牌介绍信息
     * 
     * @param id 品牌介绍ID
     * @return 品牌介绍信息
     */
	public Brand selectBrandById(Integer id);
	
	/**
     * 查询品牌介绍列表
     * 
     * @param brand 品牌介绍信息
     * @return 品牌介绍集合
     */
	public List<Brand> selectBrandList(Brand brand);
	
	/**
     * 新增品牌介绍
     * 
     * @param brand 品牌介绍信息
     * @return 结果
     */
	public int insertBrand(Brand brand);
	
	/**
     * 修改品牌介绍
     * 
     * @param brand 品牌介绍信息
     * @return 结果
     */
	public int updateBrand(Brand brand);
		
	/**
     * 删除品牌介绍信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBrandByIds(String ids);
	
}
