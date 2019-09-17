package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.VideoMapper;
import com.etycx.system.domain.Video;
import com.etycx.system.service.IVideoService;
import com.etycx.common.core.text.Convert;

/**
 * 视频  服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Service
public class VideoServiceImpl implements IVideoService 
{
	@Autowired
	private VideoMapper videoMapper;

	/**
     * 查询视频 信息
     * 
     * @param id 视频 ID
     * @return 视频 信息
     */
    @Override
	public Video selectVideoById(Integer id)
	{
	    return videoMapper.selectVideoById(id);
	}
	
	/**
     * 查询视频 列表
     * 
     * @param video 视频 信息
     * @return 视频 集合
     */
	@Override
	public List<Video> selectVideoList(Video video)
	{
	    return videoMapper.selectVideoList(video);
	}
	
    /**
     * 新增视频 
     * 
     * @param video 视频 信息
     * @return 结果
     */
	@Override
	public int insertVideo(Video video)
	{
	    return videoMapper.insertVideo(video);
	}
	
	/**
     * 修改视频 
     * 
     * @param video 视频 信息
     * @return 结果
     */
	@Override
	public int updateVideo(Video video)
	{
	    return videoMapper.updateVideo(video);
	}

	/**
     * 删除视频 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteVideoByIds(String ids)
	{
		return videoMapper.deleteVideoByIds(Convert.toStrArray(ids));
	}
	
}
