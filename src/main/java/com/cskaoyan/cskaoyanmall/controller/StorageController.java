package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.Storage;
import com.cskaoyan.cskaoyanmall.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *@Author: Lee et
 *@Date: Created in 16:28 2020/5/29
 */
@RestController
@RequestMapping("admin/storage")
public class StorageController {
    @Autowired
    StorageService storageService;


    @RequestMapping("create")
    public BaseRespVo create(MultipartFile file) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Storage storage = null;
        try {
            storage = storageService.fileUpload(file);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(storage);
        return respVo;
    }
}
