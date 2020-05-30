package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.Storage;
import com.cskaoyan.cskaoyanmall.mapper.StorageMapper;
import com.cskaoyan.cskaoyanmall.service.StorageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

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
        Storage storage = new Storage();
        // 随机生成文件名称
        String name = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = myfile.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String suffix = split[1];
        // key=uuid拼接文件后缀名
        String key = name + "." + suffix;
        storage.setKey(key);
        storage.setName(originalFilename);
        storage.setType(myfile.getContentType());
        storage.setSize(myfile.getSize());
        storage.setAddTime(new Date());
        storage.setUpdateTime(new Date());
        storage.setDeleted(false);
        String url = domain + port + staticPath.substring(0,staticPath.length() - 2) + key;
        storage.setUrl(url);
        storageMapper.insertSelective(storage);
        Integer id = storageMapper.getInsertId();
        storage.setId(id);

        // 文件上传
        // 获取当前路径
        String path = System.getProperty("user.dir");
        path = path + uploadFileDirectory;
        File file = new File(path, key);
        myfile.transferTo(file);

        return storage;
    }
}
