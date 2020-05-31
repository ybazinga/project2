package com.cskaoyan.cskaoyanmall.controller;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 16:28 2020/5/29
 */
@RestController
@RequestMapping("admin/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    /**
     * 图片上传
     * spring.resources.static-locations 写死了，所以图会裂
     * form-data; name="file"
     * @param file 要和request请求体上的name的value一致！！！
     * @return
     */
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

    @RequestMapping("list")
    public BaseRespVo storageList(StoragePagingReqVo storagePagingReqVo) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Map map = null;
        try {
            map = storageService.getStorageListData(storagePagingReqVo);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setData(map);
        respVo.setErrmsg("成功");
        return respVo;
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Storage storage) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        Storage storageResp = null;
        try {
            storageResp = storageService.update(storage);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(storageResp);
        return respVo;
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Storage storage) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        try {
            storageService.updateByLogicDelete(storage);
        } catch (Exception e) {
            e.printStackTrace();
            respVo.setErrno(502);
            respVo.setErrmsg("系统内部错误");
            return respVo;
        }
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }
}
