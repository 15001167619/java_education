package com.etycx.system.service.impl;

import com.etycx.common.base.BaseVo;
import com.etycx.system.domain.Banner;
import com.etycx.system.mapper.*;
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
    @Resource
    private VideoMapper videoMapper;
    @Resource
    private BrandMapper brandMapper;
    @Resource
    private TeachersMapper teachersMapper;

    private final String baseUrl = "https://muxiaoqian.com";

    @Override
    public BaseVo index() {
        BaseVo baseVo = new BaseVo();

        //首页轮播
        List<Banner> banners = bannerMapper.selectBannerList(new Banner());
        List<Map<String,Object>> bannerList = new ArrayList<>(banners.size());
        for (Banner banner : banners) {
            Map<String,Object> bannerData = new HashMap<>(1);
            bannerData.put("pic",baseUrl+banner.getPicPath());
            bannerList.add(bannerData);
        }
        Map<String,Object> resultData = new HashMap<>(5);
        resultData.put("banner",bannerList);

        //课程分类
        List<HashMap> categoryList = categoryMapper.getCategoryList();
        for (HashMap categoryMap : categoryList) {
            categoryMap.put("picPath",baseUrl+categoryMap.get("picPath"));
        }
        resultData.put("category",categoryList);

        //推荐课程
        List<HashMap> recommendVideoList = videoMapper.getCategoryList();
        for (HashMap recommendVideoMap : recommendVideoList) {
            recommendVideoMap.put("picPath",baseUrl+recommendVideoMap.get("picPath"));
        }
        resultData.put("recommendVideo",recommendVideoList);

        //品牌介绍
        Map brandInfo = brandMapper.getBrandInfo();
        brandInfo.put("picPath",baseUrl+brandInfo.get("picPath"));
        resultData.put("brandInfo",brandInfo);

        //师资力量
        List<HashMap> teacherList = teachersMapper.getTeachersList();
        for (HashMap teacherMap : teacherList) {
            teacherMap.put("picPath",baseUrl+teacherMap.get("picPath"));
        }
        resultData.put("teachers",teacherList);

        return baseVo.ok(resultData,"获取首页信息成功");
    }
}
