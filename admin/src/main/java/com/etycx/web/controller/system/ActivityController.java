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
import com.etycx.system.domain.Activity;
import com.etycx.system.service.IActivityService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 活动 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
@Controller
@RequestMapping("/system/activity")
public class ActivityController extends BaseController
{
    private String prefix = "system/activity";
	
	@Autowired
	private IActivityService activityService;
	
	@RequiresPermissions("system:activity:view")
	@GetMapping()
	public String activity()
	{
	    return prefix + "/activity";
	}
	
	/**
	 * 查询活动列表
	 */
	@RequiresPermissions("system:activity:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Activity activity)
	{
		startPage();
        List<Activity> list = activityService.selectActivityList(activity);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出活动列表
	 */
	@RequiresPermissions("system:activity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Activity activity)
    {
    	List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        return util.exportExcel(list, "activity");
    }
	
	/**
	 * 新增活动
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存活动
	 */
	@RequiresPermissions("system:activity:add")
	@Log(title = "活动", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Activity activity)
	{		
		return toAjax(activityService.insertActivity(activity));
	}

	/**
	 * 修改活动
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Activity activity = activityService.selectActivityById(id);
		mmap.put("activity", activity);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存活动
	 */
	@RequiresPermissions("system:activity:edit")
	@Log(title = "活动", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Activity activity)
	{		
		return toAjax(activityService.updateActivity(activity));
	}
	
	/**
	 * 删除活动
	 */
	@RequiresPermissions("system:activity:remove")
	@Log(title = "活动", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(activityService.deleteActivityByIds(ids));
	}
	
}
