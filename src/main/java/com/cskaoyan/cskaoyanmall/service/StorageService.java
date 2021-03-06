package com.cskaoyan.cskaoyanmall.service;

import com.cskaoyan.cskaoyanmall.bean.Storage;
import com.cskaoyan.cskaoyanmall.bean.StoragePagingReqVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 *@Author: Lee et
 *@Date: Created in 17:09 2020/5/29
 */
public interface StorageService {

    Storage fileUpload(MultipartFile myfile) throws IOException;

    Map getStorageListData(StoragePagingReqVo storagePagingReqVo);

    Storage update(Storage storage);

    void updateByLogicDelete(Storage storage);
}
