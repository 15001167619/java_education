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
import com.etycx.system.domain.Banner;
import com.etycx.system.service.IBannerService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * banner  信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Controller
@RequestMapping("/system/banner")
public class BannerController extends BaseController
{
    private String prefix = "system/banner";
	
	@Autowired
	private IBannerService bannerService;
	
	@RequiresPermissions("system:banner:view")
	@GetMapping()
	public String banner()
	{
	    return prefix + "/banner";
	}
	
	/**
	 * 查询banner 列表
	 */
	@RequiresPermissions("system:banner:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Banner banner)
	{
		startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出banner 列表
	 */
	@RequiresPermissions("system:banner:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Banner banner)
    {
    	List<Banner> list = bannerService.selectBannerList(banner);
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        return util.exportExcel(list, "banner");
    }
	
	/**
	 * 新增banner 
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存banner 
	 */
	@RequiresPermissions("system:banner:add")
	@Log(title = "banner ", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Banner banner)
	{		
		return toAjax(bannerService.insertBanner(banner));
	}

	/**
	 * 修改banner 
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Banner banner = bannerService.selectBannerById(id);
		mmap.put("banner", banner);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存banner 
	 */
	@RequiresPermissions("system:banner:edit")
	@Log(title = "banner ", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Banner banner)
	{		
		return toAjax(bannerService.updateBanner(banner));
	}
	
	/**
	 * 删除banner 
	 */
	@RequiresPermissions("system:banner:remove")
	@Log(title = "banner ", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(bannerService.deleteBannerByIds(ids));
	}
	
}
