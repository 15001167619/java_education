package com.etycx.system.service;

import com.etycx.system.domain.EducationUser;
import java.util.List;
import java.util.Map;

/**
 * 用户 服务层
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
public interface IEducationUserService 
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
     * 删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEducationUserByIds(String ids);

    List<EducationUser> getUserCategoryList(Integer userId);

    int relationCategoryAdd(Map<String, Object> map);

	int relationCategoryRemove(Integer id);
}
