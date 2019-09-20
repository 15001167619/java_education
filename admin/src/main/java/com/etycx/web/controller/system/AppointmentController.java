package com.etycx.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.etycx.common.annotation.Log;
import com.etycx.common.enums.BusinessType;
import com.etycx.system.domain.Appointment;
import com.etycx.system.service.IAppointmentService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 试听预约 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
@Controller
@RequestMapping("/system/appointment")
public class AppointmentController extends BaseController
{
    private String prefix = "system/appointment";
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@RequiresPermissions("system:appointment:view")
	@GetMapping()
	public String appointment()
	{
	    return prefix + "/appointment";
	}
	
	/**
	 * 查询试听预约列表
	 */
	@RequiresPermissions("system:appointment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Appointment appointment)
	{
		startPage();
        List<Appointment> list = appointmentService.selectAppointmentList(appointment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出试听预约列表
	 */
	@RequiresPermissions("system:appointment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Appointment appointment)
    {
    	List<Appointment> list = appointmentService.selectAppointmentList(appointment);
        ExcelUtil<Appointment> util = new ExcelUtil<Appointment>(Appointment.class);
        return util.exportExcel(list, "appointment");
    }
	
	/**
	 * 新增试听预约
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试听预约
	 */
	@RequiresPermissions("system:appointment:add")
	@Log(title = "试听预约", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Appointment appointment)
	{		
		return toAjax(appointmentService.insertAppointment(appointment));
	}

	/**
	 * 修改试听预约
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Appointment appointment = appointmentService.selectAppointmentById(id);
		mmap.put("appointment", appointment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存试听预约
	 */
	@RequiresPermissions("system:appointment:edit")
	@Log(title = "试听预约", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Appointment appointment)
	{		
		return toAjax(appointmentService.updateAppointment(appointment));
	}
	
	/**
	 * 删除试听预约
	 */
	@RequiresPermissions("system:appointment:remove")
	@Log(title = "试听预约", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(appointmentService.deleteAppointmentByIds(ids));
	}
	
}
