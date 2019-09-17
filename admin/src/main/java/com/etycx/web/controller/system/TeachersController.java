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
import com.etycx.system.domain.Teachers;
import com.etycx.system.service.ITeachersService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 老师  信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Controller
@RequestMapping("/system/teachers")
public class TeachersController extends BaseController
{
    private String prefix = "system/teachers";
	
	@Autowired
	private ITeachersService teachersService;
	
	@RequiresPermissions("system:teachers:view")
	@GetMapping()
	public String teachers()
	{
	    return prefix + "/teachers";
	}
	
	/**
	 * 查询老师 列表
	 */
	@RequiresPermissions("system:teachers:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Teachers teachers)
	{
		startPage();
        List<Teachers> list = teachersService.selectTeachersList(teachers);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出老师 列表
	 */
	@RequiresPermissions("system:teachers:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Teachers teachers)
    {
    	List<Teachers> list = teachersService.selectTeachersList(teachers);
        ExcelUtil<Teachers> util = new ExcelUtil<Teachers>(Teachers.class);
        return util.exportExcel(list, "teachers");
    }
	
	/**
	 * 新增老师 
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存老师 
	 */
	@RequiresPermissions("system:teachers:add")
	@Log(title = "老师 ", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Teachers teachers)
	{		
		return toAjax(teachersService.insertTeachers(teachers));
	}

	/**
	 * 修改老师 
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Teachers teachers = teachersService.selectTeachersById(id);
		mmap.put("teachers", teachers);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存老师 
	 */
	@RequiresPermissions("system:teachers:edit")
	@Log(title = "老师 ", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Teachers teachers)
	{		
		return toAjax(teachersService.updateTeachers(teachers));
	}
	
	/**
	 * 删除老师 
	 */
	@RequiresPermissions("system:teachers:remove")
	@Log(title = "老师 ", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teachersService.deleteTeachersByIds(ids));
	}
	
}
