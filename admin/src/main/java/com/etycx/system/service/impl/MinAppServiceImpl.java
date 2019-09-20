package com.etycx.system.service.impl;

import com.etycx.common.base.BaseVo;
import com.etycx.system.domain.Banner;
import com.etycx.system.mapper.BannerMapper;
import com.etycx.system.mapper.CategoryMapper;
import com.etycx.system.service.IMinAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MinAppServiceImpl implements IMinAppService {

    @Resource
    private BannerMapper bannerMapper;
    @Resource
    private CategoryMapper categoryMapper;

    private final String baseUrl = "https://muxiaoqian.com/";

    @Override
    public BaseVo index() {
        BaseVo baseVo = new BaseVo();
        List<Banner> banners = bannerMapper.selectBannerList(new Banner());
        List<Map<String,Object>> bannerList = new ArrayList<>(banners.size());
        for (Banner banner : banners) {
            Map<String,Object> bannerData = new HashMap<>(1);
            bannerData.put("pic",baseUrl+banner.getPicPath());
            bannerList.add(bannerData);
        }
        Map<String,Object> resultData = new HashMap<>(5);
        resultData.put("banner",bannerList);

        List<HashMap> categoryList = categoryMapper.getCategoryList();
        List<Map<String,Object>> categoryMapList = new ArrayList<>(categoryList.size());
        for (HashMap linkedHashMap : categoryList) {
            linkedHashMap.put("picPath",baseUrl+linkedHashMap.get("picPath"));
        }
        resultData.put("category",categoryList);
        return baseVo.ok(resultData,"获取banner列表成功");
    }
}
