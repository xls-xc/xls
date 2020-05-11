package com.xls.alike.service.impl;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.service.impl
 * @ClassName: UploadServiceUtil
 * @Description: 长传业务工具类
 * @Author: SkyChen
 * @Create: 2020-05-06 13:57
 * @Version: v1.0
 **/
public class UploadServiceUtil {

    /**
     * 检查图片扩展名称
     * @param originalFileName
     * @throws Exception
     */
    public static void checkImageOriginal(String originalFileName) throws Exception{
        // 取得文件扩展名
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        if (!ext.equalsIgnoreCase("png") && !ext.equalsIgnoreCase("gif") && !ext.equalsIgnoreCase("jpg") && !ext.equalsIgnoreCase("jpeg")) {
            throw new Exception("请上传png、gif、jpg、jpeg格式的图片");
        }
    }
}
