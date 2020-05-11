package com.xls.alike.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.alike.service
 * @InterfaceName: IUploadService
 * @Description: 上传业务层
 * @Author: SkyChen
 * @Create: 2020-05-06 13:54
 * @Version: v1.0
 **/
public interface IUploadService {

    /**
     * 上传图片
     * @param fileIO
     * @return
     * @throws Exception
     */
    HashMap<String, String> uploadImage(MultipartFile fileIO) throws Exception;
}
