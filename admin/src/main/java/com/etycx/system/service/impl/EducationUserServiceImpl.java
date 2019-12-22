package com.etycx.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.EducationUserMapper;
import com.etycx.system.domain.EducationUser;
import com.etycx.system.service.IEducationUserService;
import com.etycx.common.core.text.Convert;

/**
 * 用户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
@Service
public class EducationUserServiceImpl implements IEducationUserService 
{
	@Autowired
	private EducationUserMapper educationUserMapper;

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
	public EducationUser selectEducationUserById(Integer id)
	{
	    return educationUserMapper.selectEducationUserById(id);
	}
	
	/**
     * 查询用户列表
     * 
     * @param educationUser 用户信息
     * @return 用户集合
     */
	@Override
	public List<EducationUser> selectEducationUserList(EducationUser educationUser)
	{
	    return educationUserMapper.selectEducationUserList(educationUser);
	}
	
    /**
     * 新增用户
     * 
     * @param educationUser 用户信息
     * @return 结果
     */
	@Override
	public int insertEducationUser(EducationUser educationUser)
	{
	    return educationUserMapper.insertEducationUser(educationUser);
	}
	
	/**
     * 修改用户
     * 
     * @param educationUser 用户信息
     * @return 结果
     */
	@Override
	public int updateEducationUser(EducationUser educationUser)
	{
	    return educationUserMapper.updateEducationUser(educationUser);
	}

	/**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEducationUserByIds(String ids)
	{
		return educationUserMapper.deleteEducationUserByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Map<String, Object>> getUserCategoryList(Integer userId) {
		return educationUserMapper.getUserCategoryList(userId);
	}
}
