package com.etycx.rest.index;

import com.etycx.common.base.BaseApiController;
import com.etycx.common.base.BaseVo;
import com.etycx.common.utils.StringUtils;
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
public class ApiIndexController extends BaseApiController {

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

    /**
     * @description  用户登录
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(@RequestParam("account") String account,
                        @RequestParam("password") String password) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return isNullData();
        }
        return minAppService.login(account,password);
    }

    /**
     * @description  用户预约
     */
    @RequestMapping(value = "appointment", method = RequestMethod.POST)
    public Object appointment(@RequestParam("name") String name,
                              @RequestParam("mobile") String mobile,
                              @RequestParam("age") Integer age) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(mobile) || age ==null) {
            return isNullData();
        }
        return minAppService.appointment(name,mobile,age);
    }

    /**
     * @description  关于我们
     */
    @RequestMapping(value = "aboutUs", method = RequestMethod.GET)
    public Object aboutUs() {
        return minAppService.aboutUs();
    }

    /**
     * @description  活动分类
     */
    @RequestMapping(value = "activityCategory", method = RequestMethod.GET)
    public Object activityCategory() {
        return minAppService.activityCategory();
    }

    @RequestMapping(value={"activityCategoryList"}, method= RequestMethod.GET)
    public Object activityCategoryList(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "8")Integer pageSize) {
        return minAppService.activityCategoryList(categoryId,pageNum,pageSize);
    }

    @RequestMapping(value={"activityCategory"}, method= RequestMethod.GET)
    public BaseVo activityCategory(@RequestParam(value = "activityId") Integer activityId) {
        return minAppService.activityCategory(activityId);
    }


}
