package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.BrandMapper;
import com.etycx.system.domain.Brand;
import com.etycx.system.service.IBrandService;
import com.etycx.common.core.text.Convert;

/**
 * 品牌介绍 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Service
public class BrandServiceImpl implements IBrandService 
{
	@Autowired
	private BrandMapper brandMapper;

	/**
     * 查询品牌介绍信息
     * 
     * @param id 品牌介绍ID
     * @return 品牌介绍信息
     */
    @Override
	public Brand selectBrandById(Integer id)
	{
	    return brandMapper.selectBrandById(id);
	}
	
	/**
     * 查询品牌介绍列表
     * 
     * @param brand 品牌介绍信息
     * @return 品牌介绍集合
     */
	@Override
	public List<Brand> selectBrandList(Brand brand)
	{
	    return brandMapper.selectBrandList(brand);
	}
	
    /**
     * 新增品牌介绍
     * 
     * @param brand 品牌介绍信息
     * @return 结果
     */
	@Override
	public int insertBrand(Brand brand)
	{
	    return brandMapper.insertBrand(brand);
	}
	
	/**
     * 修改品牌介绍
     * 
     * @param brand 品牌介绍信息
     * @return 结果
     */
	@Override
	public int updateBrand(Brand brand)
	{
	    return brandMapper.updateBrand(brand);
	}

	/**
     * 删除品牌介绍对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBrandByIds(String ids)
	{
		return brandMapper.deleteBrandByIds(Convert.toStrArray(ids));
	}
	
}
