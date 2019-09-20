package com.etycx.system.service;

import com.etycx.system.domain.Appointment;
import java.util.List;

/**
 * 试听预约 服务层
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
public interface IAppointmentService 
{
	/**
     * 查询试听预约信息
     * 
     * @param id 试听预约ID
     * @return 试听预约信息
     */
	public Appointment selectAppointmentById(Integer id);
	
	/**
     * 查询试听预约列表
     * 
     * @param appointment 试听预约信息
     * @return 试听预约集合
     */
	public List<Appointment> selectAppointmentList(Appointment appointment);
	
	/**
     * 新增试听预约
     * 
     * @param appointment 试听预约信息
     * @return 结果
     */
	public int insertAppointment(Appointment appointment);
	
	/**
     * 修改试听预约
     * 
     * @param appointment 试听预约信息
     * @return 结果
     */
	public int updateAppointment(Appointment appointment);
		
	/**
     * 删除试听预约信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAppointmentByIds(String ids);
	
}
