package com.etycx.system.service;

import com.etycx.system.domain.Video;
import java.util.List;

/**
 * 视频  服务层
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public interface IVideoService 
{
	/**
     * 查询视频 信息
     * 
     * @param id 视频 ID
     * @return 视频 信息
     */
	public Video selectVideoById(Integer id);
	
	/**
     * 查询视频 列表
     * 
     * @param video 视频 信息
     * @return 视频 集合
     */
	public List<Video> selectVideoList(Video video);
	
	/**
     * 新增视频 
     * 
     * @param video 视频 信息
     * @return 结果
     */
	public int insertVideo(Video video);
	
	/**
     * 修改视频 
     * 
     * @param video 视频 信息
     * @return 结果
     */
	public int updateVideo(Video video);
		
	/**
     * 删除视频 信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteVideoByIds(String ids);
	
}
