package com.xls.alike.controller;

import com.xls.alike.common.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.controller
 * @ClassName: UploadController
 * @Description: 上传控制器
 * @Author: SkyChen
 * @Create: 2020-05-06 13:44
 * @Version: v1.0
 **/
@RequestMapping("/upload")
@Controller
public class UploadController {


    /**
     * 上传图片
     * @param imageFile
     * @return
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public ResultEntity uploadImage(MultipartFile imageFile) {
        return null;
    }
}
