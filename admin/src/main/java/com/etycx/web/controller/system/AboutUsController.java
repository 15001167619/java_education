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
import com.etycx.system.domain.AboutUs;
import com.etycx.system.service.IAboutUsService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 关于我们 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
@Controller
@RequestMapping("/system/aboutUs")
public class AboutUsController extends BaseController
{
    private String prefix = "system/aboutUs";
	
	@Autowired
	private IAboutUsService aboutUsService;
	
	@RequiresPermissions("system:aboutUs:view")
	@GetMapping()
	public String aboutUs()
	{
	    return prefix + "/aboutUs";
	}
	
	/**
	 * 查询关于我们列表
	 */
	@RequiresPermissions("system:aboutUs:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AboutUs aboutUs)
	{
		startPage();
        List<AboutUs> list = aboutUsService.selectAboutUsList(aboutUs);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出关于我们列表
	 */
	@RequiresPermissions("system:aboutUs:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AboutUs aboutUs)
    {
    	List<AboutUs> list = aboutUsService.selectAboutUsList(aboutUs);
        ExcelUtil<AboutUs> util = new ExcelUtil<AboutUs>(AboutUs.class);
        return util.exportExcel(list, "aboutUs");
    }
	
	/**
	 * 新增关于我们
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存关于我们
	 */
	@RequiresPermissions("system:aboutUs:add")
	@Log(title = "关于我们", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AboutUs aboutUs)
	{		
		return toAjax(aboutUsService.insertAboutUs(aboutUs));
	}

	/**
	 * 修改关于我们
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		AboutUs aboutUs = aboutUsService.selectAboutUsById(id);
		mmap.put("aboutUs", aboutUs);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存关于我们
	 */
	@RequiresPermissions("system:aboutUs:edit")
	@Log(title = "关于我们", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AboutUs aboutUs)
	{		
		return toAjax(aboutUsService.updateAboutUs(aboutUs));
	}
	
	/**
	 * 删除关于我们
	 */
	@RequiresPermissions("system:aboutUs:remove")
	@Log(title = "关于我们", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(aboutUsService.deleteAboutUsByIds(ids));
	}
	
}
