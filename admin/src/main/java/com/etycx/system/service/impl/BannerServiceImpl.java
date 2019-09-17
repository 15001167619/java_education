package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.BannerMapper;
import com.etycx.system.domain.Banner;
import com.etycx.system.service.IBannerService;
import com.etycx.common.core.text.Convert;

/**
 * banner  服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Service
public class BannerServiceImpl implements IBannerService 
{
	@Autowired
	private BannerMapper bannerMapper;

	/**
     * 查询banner 信息
     * 
     * @param id banner ID
     * @return banner 信息
     */
    @Override
	public Banner selectBannerById(Integer id)
	{
	    return bannerMapper.selectBannerById(id);
	}
	
	/**
     * 查询banner 列表
     * 
     * @param banner banner 信息
     * @return banner 集合
     */
	@Override
	public List<Banner> selectBannerList(Banner banner)
	{
	    return bannerMapper.selectBannerList(banner);
	}
	
    /**
     * 新增banner 
     * 
     * @param banner banner 信息
     * @return 结果
     */
	@Override
	public int insertBanner(Banner banner)
	{
	    return bannerMapper.insertBanner(banner);
	}
	
	/**
     * 修改banner 
     * 
     * @param banner banner 信息
     * @return 结果
     */
	@Override
	public int updateBanner(Banner banner)
	{
	    return bannerMapper.updateBanner(banner);
	}

	/**
     * 删除banner 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBannerByIds(String ids)
	{
		return bannerMapper.deleteBannerByIds(Convert.toStrArray(ids));
	}
	
}
