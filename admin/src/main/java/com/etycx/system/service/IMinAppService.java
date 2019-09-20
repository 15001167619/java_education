package com.etycx.system.service;

import com.etycx.common.base.BaseVo;

public interface IMinAppService {

    BaseVo index();

    BaseVo categoryList();

    BaseVo videoList(Integer categoryId, Integer pageNum, Integer pageSize);

    BaseVo video(Integer videoId);
}
