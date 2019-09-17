package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.TeachersMapper;
import com.etycx.system.domain.Teachers;
import com.etycx.system.service.ITeachersService;
import com.etycx.common.core.text.Convert;

/**
 * 老师  服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Service
public class TeachersServiceImpl implements ITeachersService 
{
	@Autowired
	private TeachersMapper teachersMapper;

	/**
     * 查询老师 信息
     * 
     * @param id 老师 ID
     * @return 老师 信息
     */
    @Override
	public Teachers selectTeachersById(Integer id)
	{
	    return teachersMapper.selectTeachersById(id);
	}
	
	/**
     * 查询老师 列表
     * 
     * @param teachers 老师 信息
     * @return 老师 集合
     */
	@Override
	public List<Teachers> selectTeachersList(Teachers teachers)
	{
	    return teachersMapper.selectTeachersList(teachers);
	}
	
    /**
     * 新增老师 
     * 
     * @param teachers 老师 信息
     * @return 结果
     */
	@Override
	public int insertTeachers(Teachers teachers)
	{
	    return teachersMapper.insertTeachers(teachers);
	}
	
	/**
     * 修改老师 
     * 
     * @param teachers 老师 信息
     * @return 结果
     */
	@Override
	public int updateTeachers(Teachers teachers)
	{
	    return teachersMapper.updateTeachers(teachers);
	}

	/**
     * 删除老师 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeachersByIds(String ids)
	{
		return teachersMapper.deleteTeachersByIds(Convert.toStrArray(ids));
	}
	
}
