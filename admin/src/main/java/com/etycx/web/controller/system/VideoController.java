package com.etycx.web.controller.system;

import java.util.LinkedHashMap;
import java.util.List;

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
import com.etycx.system.domain.Video;
import com.etycx.system.service.IVideoService;
import com.etycx.common.core.controller.BaseController;
import com.etycx.common.core.page.TableDataInfo;
import com.etycx.common.core.domain.AjaxResult;
import com.etycx.common.utils.poi.ExcelUtil;

/**
 * 视频  信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-17
 */
@Controller
@RequestMapping("/system/video")
public class VideoController extends BaseController
{
    private String prefix = "system/video";
	
	@Autowired
	private IVideoService videoService;

	@Autowired
	private ICategoryService categoryService;
	
	@RequiresPermissions("system:video:view")
	@GetMapping()
	public String video()
	{
	    return prefix + "/video";
	}
	
	/**
	 * 查询视频 列表
	 */
	@RequiresPermissions("system:video:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Video video)
	{
		startPage();
        List<Video> list = videoService.findVideoList(video);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出视频 列表
	 */
	@RequiresPermissions("system:video:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Video video)
    {
    	List<Video> list = videoService.selectVideoList(video);
        ExcelUtil<Video> util = new ExcelUtil<Video>(Video.class);
        return util.exportExcel(list, "video");
    }
	
	/**
	 * 新增视频 
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("categoryList", getCategoryList());
		return prefix + "/add";
	}
	
	/**
	 * 新增保存视频 
	 */
	@RequiresPermissions("system:video:add")
	@Log(title = "视频 ", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Video video)
	{		
		return toAjax(videoService.insertVideo(video));
	}

	/**
	 * 修改视频 
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Video video = videoService.selectVideoById(id);
		mmap.put("video", video);
		mmap.put("categoryList", getCategoryList());
	    return prefix + "/edit";
	}

	private List<LinkedHashMap> getCategoryList() {
		return categoryService.getCategoryList();
	}

	/**
	 * 修改保存视频 
	 */
	@RequiresPermissions("system:video:edit")
	@Log(title = "视频 ", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Video video)
	{		
		return toAjax(videoService.updateVideo(video));
	}
	
	/**
	 * 删除视频 
	 */
	@RequiresPermissions("system:video:remove")
	@Log(title = "视频 ", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(videoService.deleteVideoByIds(ids));
	}
	
}
