package com.etycx.rest.example;

import com.etycx.common.base.BaseApiController;
import com.etycx.common.constant.InterfaceAppKeyConstants;
import com.etycx.common.utils.StringUtils;
import com.etycx.common.annotation.Security;
import com.etycx.remote.service.IExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 武海升
 * @description Api接口示例 均为POST请求
 * @date 2019/6/12 9:47
 */
@CrossOrigin(origins = "*",
        maxAge = 3600,
        methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping(value = "api/auth")
public class ExampleApiController extends BaseApiController {

    @Autowired
    private IExampleService exampleService;

    /**
     * @author 武海升
     * @description POST 请求示例
     *  说明:
     *      appKey:        接口人自定义    16位随机串: OiMWgmrILRfLK4IG
     *      interfaceName: 接口名称        接口方法名: exampleAdd
     *      timestamp:     当前时间戳      var timestamp = new Date().getTime();
     *      dataParams:    接口参数        userId=2&name=武海升&age=24
     *      apiSign:       参数签名
     *                        ---参数签名生成方式: apiSign = md5(原始字符串)
     *                        ---原始字符串组成:   appKey=OiMWgmrILRfLK4IG#interfaceName=exampleAdd#timestamp=timestamp#dataParams=userId=2&name=武海升&age=24
     * @date 2019/6/12 9:47
     */
    @Security(appKey = InterfaceAppKeyConstants.EXAMPLE_ADD_APP_KEY,interfaceName = "exampleAdd")
    @RequestMapping(value={"exampleAdd"}, method= RequestMethod.POST)
    public Object exampleAdd(@RequestBody Map<String,Object> params) {
        if(params == null){
            return isNullData();
        }
        String dataParams = (String)params.get("dataParams");
        if(StringUtils.isNotEmpty(dataParams)){
            Map<String, String> dataParamsMap = getDataParamsMap(dataParams);
            return exampleService.exampleAdd(dataParamsMap);
        }
        return isNullData();
    }
}
