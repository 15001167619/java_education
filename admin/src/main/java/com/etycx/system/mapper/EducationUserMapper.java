package com.etycx.system.mapper;

import com.etycx.system.domain.EducationUser;
import java.util.List;	

/**
 * 用户 数据层
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
public interface EducationUserMapper 
{
	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public EducationUser selectEducationUserById(Integer id);
	
	/**
     * 查询用户列表
     * 
     * @param educationUser 用户信息
     * @return 用户集合
     */
	public List<EducationUser> selectEducationUserList(EducationUser educationUser);
	
	/**
     * 新增用户
     * 
     * @param educationUser 用户信息
     * @return 结果
     */
	public int insertEducationUser(EducationUser educationUser);
	
	/**
     * 修改用户
     * 
     * @param educationUser 用户信息
     * @return 结果
     */
	public int updateEducationUser(EducationUser educationUser);
	
	/**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
	public int deleteEducationUserById(Integer id);
	
	/**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEducationUserByIds(String[] ids);
	
}