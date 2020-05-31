package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Storage;
import com.cskaoyan.cskaoyanmall.bean.StoragePagingReqVo;
import com.cskaoyan.cskaoyanmall.bean.Storage;
import com.cskaoyan.cskaoyanmall.bean.StorageExample;
import com.cskaoyan.cskaoyanmall.mapper.StorageMapper;
import com.cskaoyan.cskaoyanmall.service.StorageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *@Author: Lee et
 *@Date: Created in 17:14 2020/5/29
 */
@ConfigurationProperties(prefix = "map")
@Service
@Data
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;

    String domain;
    String staticPath;
    String uploadFileDirectory;
    String port;

    @Override
    public Storage fileUpload(MultipartFile myfile) throws IOException {
        // 文件信息上传至数据库
        Storage storagePagingReqVo = new Storage();
        // 随机生成文件名称
        String name = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = myfile.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String suffix = split[1];
        // key=uuid拼接文件后缀名
        String key = name + "." + suffix;
        storagePagingReqVo.setKey(key);
        storagePagingReqVo.setName(originalFilename);
        storagePagingReqVo.setType(myfile.getContentType());
        storagePagingReqVo.setSize(myfile.getSize());
        storagePagingReqVo.setAddTime(new Date());
        storagePagingReqVo.setUpdateTime(new Date());
        storagePagingReqVo.setDeleted(false);
        String url = domain + port + staticPath.substring(0,staticPath.length() - 2) + key;
        storagePagingReqVo.setUrl(url);
        // insert标签中使用useGeneratedKey → 可以获得自增的主键
        storageMapper.insertSelective(storagePagingReqVo);

        // 文件上传
        // 获取当前路径
        String path = System.getProperty("user.dir");
        path = path + uploadFileDirectory;
        File file = new File(path, key);
        myfile.transferTo(file);

        return storagePagingReqVo;
    }

    @Override
    public Map getStorageListData(StoragePagingReqVo storagePagingReqVo) {
        Integer page = storagePagingReqVo.getPage();
        Integer limit = storagePagingReqVo.getLimit();
        String sort = storagePagingReqVo.getSort();
        String order = storagePagingReqVo.getOrder();
        String orderClause = sort + " " + order;

        String key = storagePagingReqVo.getKey();
        String name = storagePagingReqVo.getName();
        //开启分页
        PageHelper.startPage(page, limit);
        StorageExample storageExample = new StorageExample();
        StorageExample.Criteria criteria = storageExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        // 条件查询 需要添加条件
        if (key != null) criteria.andKeyLike("%" + key + "%");
        if (name != null) criteria.andNameLike("%" + name + "%");
        storageExample.setOrderByClause(orderClause);
        List<Storage> storageList = storageMapper.selectByExample(storageExample);
        PageInfo<Storage> pageInfo = new PageInfo<>(storageList);
        Long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("items", storageList);
        return map;
    }

    @Override
    public Storage update(Storage storage) {
        storage.setUpdateTime(new Date());
        storageMapper.updateByPrimaryKeySelective(storage);
        return storage;
    }

    @Override
    public void updateByLogicDelete(Storage storage) {
        storage.setDeleted(true);
        storageMapper.updateByPrimaryKeySelective(storage);
    }
}
