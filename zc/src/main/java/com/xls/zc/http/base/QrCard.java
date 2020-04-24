/*
package com.xls.zc.http.base;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.apache.log4j.Logger;
import sun.awt.SunHints;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

*/
/**
 * @copyright
 * @license    
 * @link       
 *
 * 二维码图片类
 *
 * @author cj
 * Created 2017-4-14 下午 6:22
 *//*

public class QrCard {


    protected final Logger logger = Logger.getLogger(getClass());
    */
/**
     * 文件名称 , 全地址的
     *//*

    private String fileName;
    */
/**
     * 生成图片的宽度
     *//*

    private int resultWidth;


    private BufferedImage resutlImage;
    //
    private Graphics2D graphics;

    */
/**
     * 640 * 960
     *
     * @param resultWidth
     * @param resultHeight
     *//*

    public QrCard(String fileName, int resultWidth, int resultHeight) {
        this.fileName = fileName;
        this.resutlImage = new BufferedImage(resultWidth, resultHeight, BufferedImage.TYPE_INT_RGB);
        this.graphics = (Graphics2D) resutlImage.createGraphics();
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, resultWidth, resultHeight);
        this.resultWidth = resultWidth;
    }

    public QrCard(int resultWidth, int resultHeight) {
        this.resutlImage = new BufferedImage(resultWidth, resultHeight, BufferedImage.TYPE_INT_RGB);
        this.graphics = (Graphics2D) resutlImage.createGraphics();
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, resultWidth, resultHeight);
        this.resultWidth = resultWidth;
    }

    */
/**
     * 画图
     *
     * @param imageUrl 图片的url地址
     * @param left
     * @param top
     * @param width
     * @param height
     * @throws IOException
     *//*

    public void drwaImage(String imageUrl, int left, int top, int width, int height) throws IOException {
//        Image src = ImageIO.read(new URL(imageUrl));
//        graphics.drawImage(src, left, top, width, height, null);
        Image img = Toolkit.getDefaultToolkit().createImage(new URL(imageUrl));
        BufferedImage bi = toBufferedImage(img);
        Image image = bi.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawImage(image, left, top, width, height, null);
    }

    */
/**
     * 绘制二维码图片
     *//*

    public void drawQrImage(String qrUrl, int left, int top, int width, int height) throws WriterException {
        Image qrImage = createQrcode(qrUrl, width, height);
        graphics.drawImage(qrImage, left, top, width, height, null);
    }

    */
/**
     * 写字
     *
     * @param text
     * @param left
     * @param top
     * @param font
     * @param color Color.BLACK
     *//*

    public void drawText(String text, int left, int top, Font font, Color color) {
        graphics.setColor(color);
        graphics.setFont(font);
        //开启字体平滑
        graphics.setRenderingHint(SunHints.KEY_ANTIALIASING, SunHints.VALUE_ANTIALIAS_ON);
        if (left < 0) {
            //超出文字省略
            text = cutDesc(text, resultWidth);
            //文字居中
            int strWidth = graphics.getFontMetrics().stringWidth(text);
            left = (int) Math.floor((resultWidth - strWidth) / 2);
        }
        graphics.drawString(text, left, top);
    }

    */
/**
     * 生成
     *
     * @return
     *//*

    public String createQrcard() throws IOException, WriterException {
        graphics.dispose();
        File QrcodeFile = new File(fileName);
        ImageIO.write(resutlImage, "png", QrcodeFile);
        return fileName;
    }

    */
/**
     * 生成
     *
     * @return
     * @throws IOException
     * @throws WriterException
     *//*

    public BufferedImage createQrcardForOss() throws IOException, WriterException {
        graphics.dispose();
        return resutlImage;
    }

    */
/**
     * 创建二维码
     *
     * @return
     *//*

    private Image createQrcode(String qrUrl, int width, int height) throws WriterException {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(qrUrl, BarcodeFormat.QR_CODE, width, height, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    */
/**
     * 截取字符串
     *
     * @return
     *//*

    private String cutDesc(String desc, int width) {
        int strWidth = graphics.getFontMetrics().stringWidth(desc);
        int maxWidth = (int) (width * 0.8);
        if (strWidth > maxWidth) {
            int strLength = 0;
            String result = "";
            for (int i = 0; i < desc.length(); i++) {
                String subStr = desc.substring(i, i + 1);
                int _w = graphics.getFontMetrics().stringWidth(subStr);
                strLength += _w;
                if (strLength > maxWidth) {
                    result += "...";
                    return result;
                }
                result += subStr;
            }
        }
        return desc;
    }


    */
/**
     * @param image
     * @return
     *//*

    private BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels; for this method��s
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        boolean hasAlpha = hasAlpha(image);

        // Create a buffered image with a format that��s compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        if (hasAlpha == false) {
            try {
                // Determine the type of transparency of the new buffered image
                int transparency = Transparency.OPAQUE;
                if (hasAlpha) {
                    transparency = Transparency.BITMASK;
                }

                // Create the buffered image
                GraphicsDevice gs = ge.getDefaultScreenDevice();
                GraphicsConfiguration gc = gs.getDefaultConfiguration();
                bimage = gc.createCompatibleImage(
                        image.getWidth(null), image.getHeight(null), transparency);
            } catch (HeadlessException e) {
                // The system does not have a screen
            }
        }
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
        // Copy image to buffered image
        Graphics2D g = (Graphics2D) bimage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }

    public boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }

        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }
        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }


}
*/
