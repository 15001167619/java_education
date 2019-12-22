package com.etycx.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etycx.framework.shiro.service.SysPasswordService;
import com.etycx.system.service.ICategoryService;
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
import com.etycx.system.domain.EducationUser;
import com.etycx.system.service.IEducationUserService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

import static com.etycx.common.core.domain.AjaxResult.categoryRepeat;
import static com.etycx.common.core.domain.AjaxResult.repeat;

/**
 * 用户 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-20
 */
@Controller
@RequestMapping("/system/educationUser")
public class EducationUserController extends BaseController
{
    private String prefix = "system/educationUser";
	
	@Autowired
	private IEducationUserService educationUserService;

	@Autowired
	private SysPasswordService passwordService;

	@Autowired
	private ICategoryService categoryService;

	private List<HashMap> getCategoryList() {
		return categoryService.getCategoryList();
	}
	
	@RequiresPermissions("system:educationUser:view")
	@GetMapping()
	public String educationUser()
	{
	    return prefix + "/educationUser";
	}


	@GetMapping("toUserCategoryList")
	public String toUserCategoryList(Integer userId,ModelMap mmap)
	{
		mmap.put("userId", userId);
	    return prefix + "/user_relation_category";
	}
	
	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("system:educationUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(EducationUser educationUser)
	{
		startPage();
        List<EducationUser> list = educationUserService.selectEducationUserList(educationUser);
		return getDataTable(list);
	}

	@PostMapping("/getUserCategoryList")
	@ResponseBody
	public TableDataInfo getUserCategoryList(Integer userId)
	{
		startPage();
		List<EducationUser> list = educationUserService.getUserCategoryList(userId);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户列表
	 */
	@RequiresPermissions("system:educationUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EducationUser educationUser)
    {
    	List<EducationUser> list = educationUserService.selectEducationUserList(educationUser);
        ExcelUtil<EducationUser> util = new ExcelUtil<EducationUser>(EducationUser.class);
        return util.exportExcel(list, "educationUser");
    }
	
	/**
	 * 新增用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增用户
	 */
	@GetMapping("/userRelationCategory/add")
	public String userRelationCategoryAdd(Integer userId,ModelMap mmap)
	{
		mmap.put("userId", userId);
		mmap.put("categoryList", getCategoryList());
	    return prefix + "/user_relation_category_add";
	}
	
	/**
	 * 新增保存用户
	 */
	@RequiresPermissions("system:educationUser:add")
	@Log(title = "用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(EducationUser educationUser)
	{
		educationUser.setPassword(passwordService.encryptPassword(educationUser.getAccount(), educationUser.getPassword(), "salt"));

		try {
			educationUserService.insertEducationUser(educationUser);
			return success();
		} catch (Exception e) {
			e.printStackTrace();
			return repeat();
		}

	}

	@PostMapping("/relationCategoryAdd")
	@ResponseBody
	public AjaxResult relationCategoryAdd(Integer userId,Integer categoryId)
	{

		Map<String,Object> map = new HashMap<>(2);
		map.put("userId",userId);
		map.put("categoryId",categoryId);

		try {
			educationUserService.relationCategoryAdd(map);
			return success();
		} catch (Exception e) {
			e.printStackTrace();
			return categoryRepeat();
		}

	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		EducationUser educationUser = educationUserService.selectEducationUserById(id);
		mmap.put("educationUser", educationUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户
	 */
	@RequiresPermissions("system:educationUser:edit")
	@Log(title = "用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(EducationUser educationUser)
	{		
		return toAjax(educationUserService.updateEducationUser(educationUser));
	}
	
	/**
	 * 删除用户
	 */
	@RequiresPermissions("system:educationUser:remove")
	@Log(title = "用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(educationUserService.deleteEducationUserByIds(ids));
	}

	@PostMapping( "/relationCategoryRemove")
	@ResponseBody
	public AjaxResult relationCategoryRemove(String ids)
	{
		return toAjax(educationUserService.relationCategoryRemove(Integer.valueOf(ids)));
	}
	
}
