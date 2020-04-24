/*
package com.xls.zc.http.base.upload;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import net.elshop.b2b2c.config.ShopConfig;
import net.elshop.b2b2c.exception.ShopException;
import net.elshop.common.util.MatrixToImageWriter;
import net.elshop.common.util.QrCard;
import net.elshop.common.util.ShopHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;

*/
/**



 *
 * 本地图片上传
 *
 * @author dqw
 * Created 2017/4/17 12:04
 *//*

@Component
public class LocalUploadHelper implements UploadHelper {

    protected final Logger logger = Logger.getLogger(getClass());

    @Value("${uploadOpen}")
    private boolean uploadOpen;
    @Value("${uploadPath}")
    private String uploadPath;

    public LocalUploadHelper() {
    }

    public LocalUploadHelper(boolean uploadOpen, String uploadPath) {
        this.uploadOpen = uploadOpen;
        this.uploadPath = uploadPath;
    }

    */
/**
     * 图片上传
     * @param file
     * @return
     * @throws ShopException
     *//*

    @Override
    public String uploadFile(MultipartFile file) throws ShopException {


        if (!uploadOpen) {
            logger.warn("禁止上传文件");
            throw new ShopException("禁止上传文件");
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

            String imageNameSeed = String.valueOf(System.currentTimeMillis()) + originalFileName;
            String fileName = ShopHelper.getMd5(imageNameSeed) + "." + ext.toLowerCase();

            String filePath = "image/" + fileName.substring(0, 2) + "/" + fileName.substring(2, 4) + "/";

            String dir = uploadPath + filePath;
            createDir(dir);

            File newFile = new File(dir + fileName);
            file.transferTo(newFile);

            logger.info("------ local uploadImage start ------");
            logger.info(filePath + fileName);
            logger.info("------ local uploadImage end ------");
            return filePath + fileName;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ShopException("上传失败");
        }
    }

    @Override
    public String uploadFile(MultipartFile file, String path) throws ShopException {
        if (!uploadOpen) {
            logger.warn("禁止上传文件");
            throw new ShopException("禁止上传文件");
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

            String imageNameSeed = String.valueOf(System.currentTimeMillis()) + originalFileName;
            String fileName = ShopHelper.getMd5(imageNameSeed) + "." + ext.toLowerCase();

            String filePath = path;

            String dir = uploadPath + filePath;
            createDir(dir);

            File newFile = new File(dir + fileName);
            file.transferTo(newFile);

            logger.info("------ local uploadImage start ------");
            logger.info(filePath + fileName);
            logger.info("------ local uploadImage end ------");
            return filePath + fileName;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ShopException("上传失败");
        }

    }

    */
/**
     * 创建商品二维码
     * @param storeId
     * @param commonId
     *//*

    @Override
    public void createGoodsQRCode(int storeId, int commonId) {
        String text = ShopConfig.getWapRoot() + "tmpl/product_detail.html?commonId=" + commonId;
        createQRCode(text, String.valueOf(storeId), String.valueOf(commonId));
    }

    */
/**
     * 创建二维码
     * @param text
     * @param path
     * @param name
     *//*

    @Override
    public void createQRCode(String text, String path, String name) {
        int width = 100;
        int height = 100;
        String format = "gif";

        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 0);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            String dir = uploadPath + "qr/" + path + "/";
            createDir(dir);
            File outPutFile = new File(dir + name + ".gif");
            MatrixToImageWriter.writeToFile(bitMatrix, format, outPutFile);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }

    }

    */
/**
     * 生成分享二维码名片
     *
     * @param imageUrl
     * @param text
     * @param url
     * @return
     *//*

    @Override
    public String createShareQRCard(String imageUrl, String text, String price, String url) throws ShopException {

        try {
            logger.info("\r\ncreateShareQRCard" + price);
            String path = "qr/shareqrcard/";
            String dir = uploadPath + path;
            //根据分享的url 获取名称 ， 同一个url 保证同一个url 只有一个图片
            String md5ImageName = ShopHelper.getMd5(url) + ".png";

            createDir(dir);

            QrCard qrCardHelper = new QrCard(dir + md5ImageName, 640, 960);
            qrCardHelper.drwaImage(imageUrl, 0, 0, 640, 560);
            qrCardHelper.drwaImage(ShopConfig.getPublicRoot() + "img/share_pic_bg.png", 0, 500, 640, 460);
            qrCardHelper.drawQrImage(url, 227, 628, 200, 200);
            qrCardHelper.drawText(text, -1, 580, new Font("微软雅黑", Font.PLAIN, 30), Color.BLACK);
            if (!StringUtils.isBlank(price) && price != null) {
                qrCardHelper.drawText("￥" + price, -1, 620, new Font("微软雅黑", Font.PLAIN, 26), new Color(255, 85, 0));
            }
            qrCardHelper.createQrcard();
            return path + md5ImageName;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            throw new ShopException("生成二维码名片失败");
        }
    }

    */
/**
     * 创建目录
     * @param destDirName
     * @return
     *//*

    private boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return true;
        }
        //创建目录
        if (dir.mkdirs()) {
            return true;
        } else {
            logger.warn("图片目录创建失败");
            return false;
        }
    }

    */
/**
     * 生成微信临时二维码
     * @param url
     * @param codeId
     * @return
     * @throws ShopException
     *//*

    @Override
    public String createWeixinQRCodeForQrScene(String url, int codeId) throws ShopException {
        try {
            String path = "qr/weixin/qrscene/";
            String dir = uploadPath + path;
            String imageName = codeId + ".png";

            createDir(dir);

            QrCard qrCardHelper = new QrCard(dir + imageName, 522, 566);
            qrCardHelper.drwaImage(ShopConfig.getPublicRoot() + "img/weixin_subscribe_bg.png", 0, 0, 522, 566);
            qrCardHelper.drawQrImage(url, 270, 360, 150, 150);
            qrCardHelper.createQrcard();
            return path + imageName;
        } catch (Exception e) {
            logger.info("生成微信临时二维码:LocalUploadHelper->createWeixinQRCodeForQrScene->异常为" + e.getMessage());
            throw new ShopException("生成微信临时二维码失败");
        }
    }

    */
/**
     * 图片文件下载并上传至服务器
     * @param url
     * @return
     * @throws ShopException
     *//*

    @Override
    public String downloadFile(String url, String ext) throws ShopException {
        if (!uploadOpen) {
            logger.warn("禁止上传文件");
            throw new ShopException("禁止上传文件");
        }

        logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->url值为" + url);
        if (StringUtils.isBlank(url)) {
            logger.info("图片路径错误");
            throw new ShopException("图片路径错误");
        }

        // 构造URL
        URL urlObject;
        try {
            urlObject = new URL(url);
        } catch (Exception e) {
            logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->构造URL错误，异常信息为" + e.getMessage());
            throw new ShopException("图片路径错误");
        }
        // 打开连接
        URLConnection con;
        try {
            con = urlObject.openConnection();
        } catch (Exception e) {
            logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->打开连接错误，异常信息为" + e.getMessage());
            throw new ShopException("图片路径错误");
        }
        //设置请求超时为5s
        con.setConnectTimeout(5 * 1000);
        //输入流
        InputStream inputStream;
        try {
            inputStream = con.getInputStream();
        } catch (Exception e) {
            logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->图片读取失败，异常信息为" + e.getMessage());
            throw new ShopException("图片下载失败");
        }
        //截取图片名称
        String originalFileName = url.substring(url.lastIndexOf("/") + 1);
        logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->originalFileName值为" + originalFileName);
        //截取扩展名
        if (StringUtils.isBlank(ext)) {
            ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        }
        logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->ext值为" + ext);
        //生成文件名称
        String imageNameSeed = String.valueOf(System.currentTimeMillis()) + originalFileName;
        String fileName = ShopHelper.getMd5(imageNameSeed) + "." + ext.toLowerCase();
        logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->fileName值为" + fileName);
        //图片保存路径
        String filePath = "image/" + fileName.substring(0, 2) + "/" + fileName.substring(2, 4) + "/";
        String dir = uploadPath + filePath;
        logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->dir值为" + dir);

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        createDir(dir);
        try {
            OutputStream os = new FileOutputStream(dir + "\\" + fileName);
            logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->os创建成功");
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->文件读取成功");
            // 完毕，关闭所有链接
            os.close();
            inputStream.close();
        } catch (Exception e) {
            logger.info("图片文件下载并上传至服务器:LocalUploadHelper->downloadFile->异常为" + e.getMessage());
            throw new ShopException("图片文件下载失败");
        }
        return filePath + fileName;
    }
}


*/
