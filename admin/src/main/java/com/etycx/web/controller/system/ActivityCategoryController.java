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
import com.etycx.system.domain.ActivityCategory;
import com.etycx.system.service.IActivityCategoryService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 活动分类  信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
@Controller
@RequestMapping("/system/activityCategory")
public class ActivityCategoryController extends BaseController
{
    private String prefix = "system/activityCategory";
	
	@Autowired
	private IActivityCategoryService activityCategoryService;
	
	@RequiresPermissions("system:activityCategory:view")
	@GetMapping()
	public String activityCategory()
	{
	    return prefix + "/activityCategory";
	}
	
	/**
	 * 查询活动分类 列表
	 */
	@RequiresPermissions("system:activityCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ActivityCategory activityCategory)
	{
		startPage();
        List<ActivityCategory> list = activityCategoryService.selectActivityCategoryList(activityCategory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出活动分类 列表
	 */
	@RequiresPermissions("system:activityCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActivityCategory activityCategory)
    {
    	List<ActivityCategory> list = activityCategoryService.selectActivityCategoryList(activityCategory);
        ExcelUtil<ActivityCategory> util = new ExcelUtil<ActivityCategory>(ActivityCategory.class);
        return util.exportExcel(list, "activityCategory");
    }
	
	/**
	 * 新增活动分类 
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存活动分类 
	 */
	@RequiresPermissions("system:activityCategory:add")
	@Log(title = "活动分类 ", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ActivityCategory activityCategory)
	{		
		return toAjax(activityCategoryService.insertActivityCategory(activityCategory));
	}

	/**
	 * 修改活动分类 
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		ActivityCategory activityCategory = activityCategoryService.selectActivityCategoryById(id);
		mmap.put("activityCategory", activityCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存活动分类 
	 */
	@RequiresPermissions("system:activityCategory:edit")
	@Log(title = "活动分类 ", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ActivityCategory activityCategory)
	{		
		return toAjax(activityCategoryService.updateActivityCategory(activityCategory));
	}
	
	/**
	 * 删除活动分类 
	 */
	@RequiresPermissions("system:activityCategory:remove")
	@Log(title = "活动分类 ", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(activityCategoryService.deleteActivityCategoryByIds(ids));
	}
	
}
