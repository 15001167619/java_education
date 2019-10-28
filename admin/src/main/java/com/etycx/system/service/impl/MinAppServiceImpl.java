package com.etycx.system.service.impl;

import com.etycx.common.base.BaseVo;
import com.etycx.common.utils.DateUtils;
import com.etycx.framework.shiro.service.SysPasswordService;
import com.etycx.system.domain.*;
import com.etycx.system.mapper.*;
import com.etycx.system.service.IMinAppService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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
    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private EducationUserMapper educationUserMapper;
    @Resource
    private AboutUsMapper aboutUsMapper;
    @Resource
    private ActivityCategoryMapper activityCategoryMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Autowired
    private SysPasswordService passwordService;

    private final String baseUrl = "https://vip-esteam.com";

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

    @Override
    public BaseVo categoryList() {
        BaseVo baseVo = new BaseVo();
        List<HashMap> categoryList = categoryMapper.getCategoryList();
        for (HashMap categoryMap : categoryList) {
            categoryMap.put("picPath",baseUrl+categoryMap.get("picPath"));
        }
        return baseVo.ok(categoryList,"获取课程分类成功");
    }

    @Override
    public BaseVo videoList(Integer categoryId, Integer pageNum, Integer pageSize) {
        BaseVo baseVo = new BaseVo();
        Video video = new Video();
        video.setCategory(categoryId);
        PageHelper.startPage(pageNum,pageSize);
        List<Video> videoList = videoMapper.selectVideoList(video);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);
        List<Map<String, Object>> resultData = videoList
                .stream()
                .map(Video::toMap)
                .collect(Collectors.toList());
        return baseVo.ok(baseVo.findDataMapPage(pageInfo, resultData),"获取课程视频成功");


    }

    @Override
    public BaseVo video(Integer videoId) {
        BaseVo baseVo = new BaseVo();
        Video video = videoMapper.selectVideoById(videoId);
        Map<String,Object> map = new HashMap<>(5);
        if(video!=null){
            map.put("videoId",video.getId());
            map.put("name",video.getName());
            map.put("briefIntroduction",video.getBriefIntroduction());
            map.put("picPath",baseUrl+video.getPicPath());
            map.put("linkPath",baseUrl+video.getLinkPath());
            return baseVo.ok(map,"获取课程视频详情成功");
        }
        return baseVo.ok(null,"获取课程视频详情成功");
    }

    @Override
    public BaseVo login(String account, String password) {
        BaseVo baseVo = new BaseVo();
        EducationUser educationUser = new EducationUser();
        educationUser.setAccount(account);
        educationUser.setPassword(passwordService.encryptPassword(account, password, "salt"));
        List<EducationUser> educationUsers = educationUserMapper.selectEducationUserList(educationUser);
        if(educationUsers != null && educationUsers.size()==1){
            return baseVo.ok(educationUsers.get(0),"用户登录成功");
        }
        return baseVo.error(null,404,"用户不存在");
    }

    @Override
    public BaseVo appointment(String name, String mobile, Integer age) {
        BaseVo baseVo = new BaseVo();
        Appointment appointment = new Appointment();
        appointment.setName(name);
        appointment.setMobile(mobile);
        appointment.setAge(age);
        appointmentMapper.insertAppointment(appointment);
        appointment.setName(name);
        appointment.setMobile(mobile);
        appointment.setAge(age);
        return baseVo.ok(true,"预约成功");
    }

    @Override
    public BaseVo aboutUs() {
        BaseVo baseVo = new BaseVo();
        List<AboutUs> aboutUses = aboutUsMapper.selectAboutUsList(new AboutUs());
        if(aboutUses!=null && aboutUses.size()==1){
            Map<String,Object> map = new HashMap<>(3);
            map.put("name",aboutUses.get(0).getName());
            map.put("briefIntroduction",aboutUses.get(0).getBriefIntroduction());
            map.put("picPath",baseUrl+aboutUses.get(0).getPicPath());
            return baseVo.ok(map,"获取关于我们成功");
        }
        return baseVo.error("获取关于我们失败");
    }

    @Override
    public BaseVo activityCategory() {
        BaseVo baseVo = new BaseVo();
        return baseVo.ok(activityCategoryMapper.getCategoryList(),"获取活动分类");
    }

    @Override
    public BaseVo activityCategoryList(Integer categoryId, Integer pageNum, Integer pageSize) {
        BaseVo baseVo = new BaseVo();
        Activity activity = new Activity();
        activity.setCategory(categoryId);
        PageHelper.startPage(pageNum,pageSize);
        List<Activity> activityList = activityMapper.selectActivityList(activity);
        PageInfo<Activity> pageInfo = new PageInfo<>(activityList);
        List<Map<String, Object>> resultData = activityList
                .stream()
                .map(Activity::toMap)
                .collect(Collectors.toList());
        return baseVo.ok(baseVo.findDataMapPage(pageInfo, resultData),"获取活动列表成功");
    }

    @Override
    public BaseVo activity(Integer activityId) {
        BaseVo baseVo = new BaseVo();
        Activity activity = activityMapper.selectActivityById(activityId);
        Map<String,Object> map = new HashMap<>(3);
        if(activity!=null){
            map.put("name",activity.getName());
            map.put("content",activity.getContent());
            map.put("picPath",baseUrl+activity.getPicPath());
            return baseVo.ok(map,"获取活动详情成功");
        }
        return baseVo.ok(null,"获取活动详情成功");
    }


}
