package com.etycx.system.mapper;

import com.etycx.system.domain.Teachers;
import java.util.List;	

/**
 * 老师  数据层
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
public interface TeachersMapper 
{
	/**
     * 查询老师 信息
     * 
     * @param id 老师 ID
     * @return 老师 信息
     */
	public Teachers selectTeachersById(Integer id);
	
	/**
     * 查询老师 列表
     * 
     * @param teachers 老师 信息
     * @return 老师 集合
     */
	public List<Teachers> selectTeachersList(Teachers teachers);
	
	/**
     * 新增老师 
     * 
     * @param teachers 老师 信息
     * @return 结果
     */
	public int insertTeachers(Teachers teachers);
	
	/**
     * 修改老师 
     * 
     * @param teachers 老师 信息
     * @return 结果
     */
	public int updateTeachers(Teachers teachers);
	
	/**
     * 删除老师 
     * 
     * @param id 老师 ID
     * @return 结果
     */
	public int deleteTeachersById(Integer id);
	
	/**
     * 批量删除老师 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeachersByIds(String[] ids);
	
}