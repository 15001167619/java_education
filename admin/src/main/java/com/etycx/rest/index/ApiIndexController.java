package com.etycx.rest.index;

import com.etycx.system.service.IMinAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 武海升
 * @description Api
 * @date 2019/9/20 9:47
 */
@CrossOrigin(origins = "*",
        maxAge = 3600,
        methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping(value = "api/index")
public class ApiIndexController {

    @Autowired
    private IMinAppService minAppService;

    @RequestMapping(value={""}, method= RequestMethod.GET)
    public Object index() {
        return minAppService.index();
    }

    @RequestMapping(value={"categoryList"}, method= RequestMethod.GET)
    public Object categoryList() {
        return minAppService.categoryList();
    }

    @RequestMapping(value={"videoList"}, method= RequestMethod.GET)
    public Object videoList(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "8")Integer pageSize) {
        return minAppService.videoList(categoryId,pageNum,pageSize);
    }

    @RequestMapping(value={"video"}, method= RequestMethod.GET)
    public Object video(@RequestParam(value = "videoId") Integer videoId) {
        return minAppService.video(videoId);
    }


}
