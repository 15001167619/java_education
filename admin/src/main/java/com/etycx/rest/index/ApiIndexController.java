package com.etycx.rest.index;

import com.etycx.common.utils.StringUtils;
import com.etycx.remote.service.IExampleService;
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


}
