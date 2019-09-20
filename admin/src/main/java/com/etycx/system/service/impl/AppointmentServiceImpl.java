package com.etycx.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etycx.system.mapper.AppointmentMapper;
import com.etycx.system.domain.Appointment;
import com.etycx.system.service.IAppointmentService;
import com.etycx.common.core.text.Convert;

/**
 * 试听预约 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService 
{
	@Autowired
	private AppointmentMapper appointmentMapper;

	/**
     * 查询试听预约信息
     * 
     * @param id 试听预约ID
     * @return 试听预约信息
     */
    @Override
	public Appointment selectAppointmentById(Integer id)
	{
	    return appointmentMapper.selectAppointmentById(id);
	}
	
	/**
     * 查询试听预约列表
     * 
     * @param appointment 试听预约信息
     * @return 试听预约集合
     */
	@Override
	public List<Appointment> selectAppointmentList(Appointment appointment)
	{
	    return appointmentMapper.selectAppointmentList(appointment);
	}
	
    /**
     * 新增试听预约
     * 
     * @param appointment 试听预约信息
     * @return 结果
     */
	@Override
	public int insertAppointment(Appointment appointment)
	{
	    return appointmentMapper.insertAppointment(appointment);
	}
	
	/**
     * 修改试听预约
     * 
     * @param appointment 试听预约信息
     * @return 结果
     */
	@Override
	public int updateAppointment(Appointment appointment)
	{
	    return appointmentMapper.updateAppointment(appointment);
	}

	/**
     * 删除试听预约对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAppointmentByIds(String ids)
	{
		return appointmentMapper.deleteAppointmentByIds(Convert.toStrArray(ids));
	}
	
}
