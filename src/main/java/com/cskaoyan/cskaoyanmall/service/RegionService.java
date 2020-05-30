package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.RegionListRespVo;
import com.cskaoyan.cskaoyanmall.mapper.RegionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author viking chen
 * @date 2020/5/29 9:16
 */
@Service
public interface RegionService {

    List<RegionListRespVo> getMultilevelRegion();
}
