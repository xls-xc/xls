package com.xls.alike.service.impl;

import com.xls.alike.service.IUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.service.impl
 * @ClassName: UploadServiceImpl
 * @Description: 上传业务的实现类
 * @Author: SkyChen
 * @Create: 2020-05-06 13:55
 * @Version: v1.0
 **/
@Service
public class UploadServiceImpl implements IUploadService {
    @Override
    public HashMap<String, String> uploadImage(MultipartFile fileIO) throws Exception {
        UploadServiceUtil.checkImageOriginal(fileIO.getOriginalFilename());
        return null;
    }


}
