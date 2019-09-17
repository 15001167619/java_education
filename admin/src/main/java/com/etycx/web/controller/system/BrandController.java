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
import com.etycx.system.domain.Brand;
import com.etycx.system.service.IBrandService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 品牌介绍 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Controller
@RequestMapping("/system/brand")
public class BrandController extends BaseController
{
    private String prefix = "system/brand";
	
	@Autowired
	private IBrandService brandService;
	
	@RequiresPermissions("system:brand:view")
	@GetMapping()
	public String brand()
	{
	    return prefix + "/brand";
	}
	
	/**
	 * 查询品牌介绍列表
	 */
	@RequiresPermissions("system:brand:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Brand brand)
	{
		startPage();
        List<Brand> list = brandService.selectBrandList(brand);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出品牌介绍列表
	 */
	@RequiresPermissions("system:brand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Brand brand)
    {
    	List<Brand> list = brandService.selectBrandList(brand);
        ExcelUtil<Brand> util = new ExcelUtil<Brand>(Brand.class);
        return util.exportExcel(list, "brand");
    }
	
	/**
	 * 新增品牌介绍
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存品牌介绍
	 */
	@RequiresPermissions("system:brand:add")
	@Log(title = "品牌介绍", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Brand brand)
	{		
		return toAjax(brandService.insertBrand(brand));
	}

	/**
	 * 修改品牌介绍
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Brand brand = brandService.selectBrandById(id);
		mmap.put("brand", brand);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存品牌介绍
	 */
	@RequiresPermissions("system:brand:edit")
	@Log(title = "品牌介绍", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Brand brand)
	{		
		return toAjax(brandService.updateBrand(brand));
	}
	
	/**
	 * 删除品牌介绍
	 */
	@RequiresPermissions("system:brand:remove")
	@Log(title = "品牌介绍", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(brandService.deleteBrandByIds(ids));
	}
	
}
