package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.RegionListRespVo;
import com.cskaoyan.cskaoyanmall.mapper.RegionMapper;
import com.cskaoyan.cskaoyanmall.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author viking chen
 * @date 2020/5/29 9:19
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<RegionListRespVo> getMultilevelRegion() {
        List<RegionListRespVo> list = regionMapper.selectMultilevelRegion();
        return list;
    }
}
