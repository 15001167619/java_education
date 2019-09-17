package com.etycx.system.service;

import com.etycx.system.domain.Banner;
import java.util.List;

/**
 * banner  服务层
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public interface IBannerService 
{
	/**
     * 查询banner 信息
     * 
     * @param id banner ID
     * @return banner 信息
     */
	public Banner selectBannerById(Integer id);
	
	/**
     * 查询banner 列表
     * 
     * @param banner banner 信息
     * @return banner 集合
     */
	public List<Banner> selectBannerList(Banner banner);
	
	/**
     * 新增banner 
     * 
     * @param banner banner 信息
     * @return 结果
     */
	public int insertBanner(Banner banner);
	
	/**
     * 修改banner 
     * 
     * @param banner banner 信息
     * @return 结果
     */
	public int updateBanner(Banner banner);
		
	/**
     * 删除banner 信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBannerByIds(String ids);
	
}
