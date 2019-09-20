package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.AboutUsMapper;
import com.etycx.system.domain.AboutUs;
import com.etycx.system.service.IAboutUsService;
import com.etycx.common.core.text.Convert;

/**
 * 关于我们 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
@Service
public class AboutUsServiceImpl implements IAboutUsService 
{
	@Autowired
	private AboutUsMapper aboutUsMapper;

	/**
     * 查询关于我们信息
     * 
     * @param id 关于我们ID
     * @return 关于我们信息
     */
    @Override
	public AboutUs selectAboutUsById(Integer id)
	{
	    return aboutUsMapper.selectAboutUsById(id);
	}
	
	/**
     * 查询关于我们列表
     * 
     * @param aboutUs 关于我们信息
     * @return 关于我们集合
     */
	@Override
	public List<AboutUs> selectAboutUsList(AboutUs aboutUs)
	{
	    return aboutUsMapper.selectAboutUsList(aboutUs);
	}
	
    /**
     * 新增关于我们
     * 
     * @param aboutUs 关于我们信息
     * @return 结果
     */
	@Override
	public int insertAboutUs(AboutUs aboutUs)
	{
	    return aboutUsMapper.insertAboutUs(aboutUs);
	}
	
	/**
     * 修改关于我们
     * 
     * @param aboutUs 关于我们信息
     * @return 结果
     */
	@Override
	public int updateAboutUs(AboutUs aboutUs)
	{
	    return aboutUsMapper.updateAboutUs(aboutUs);
	}

	/**
     * 删除关于我们对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAboutUsByIds(String ids)
	{
		return aboutUsMapper.deleteAboutUsByIds(Convert.toStrArray(ids));
	}
	
}
