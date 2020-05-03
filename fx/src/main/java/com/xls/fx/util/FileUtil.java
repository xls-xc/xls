package com.xls.fx.util;

import java.io.*;
import java.util.concurrent.ExecutionException;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util
 * @ClassName: FileUtil
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-05-03 16:39
 * @Version: v1.0
 **/
public class FileUtil {

    private static String uselessPackage = "C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\java\\com\\xls\\fx\\auto\\delete";
    private static String fromChangeFilePackage = "C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\java\\com\\xls\\fx\\auto\\xml";
    private static String toChangeFilePath = "C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\resources\\mapper";

    public static void main(String[] args) {
       /* try {
            moveDirAllFile(fromChangeFilePackage,toChangeFilePath);
            deleteDir(uselessPackage);
        }catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public static void codeHelper(String fromChangeFilePackage,String toChangeFilePath,String uselessPackage) {
       try{
           moveDirAllFile(fromChangeFilePackage,toChangeFilePath);
           deleteDir(uselessPackage);
       }catch (Exception e) {
           e.printStackTrace();
       }
    }

    /**
     * 移动目录所有文件到新目录下
     * @param oldDir
     * @param newDir
     */
    public static void moveDirAllFile(String oldDir,String newDir) throws Exception{
        File oldDirFile = new File(oldDir);
        File newDirFile = new File(newDir);

        if(!checkDirExists(oldDirFile)) {
            throw new Exception("目录文件夹不存在："+oldDir);
        }else {
            //确实路径是否是 D:/a  还是D:/a/
            if(!oldDir.endsWith(File.separator)) {
                oldDir = oldDir + File.separator;
            }
        }

        if(!checkDirExists(newDirFile)) {
            throw new Exception("目录文件夹不存在："+newDir);
        }else {
            if(!newDir.endsWith(File.separator)) {
                newDir = newDir + File.separator;
            }
        }

        File[] files = oldDirFile.listFiles();
        deleteFile(oldDirFile);
        if(files.length>0) {
            InputStream fileInputStream = null;
            OutputStream fileOutPutStream = null;
            for (File file : files) {

                 fileInputStream = new FileInputStream(file);
                 fileOutPutStream = new FileOutputStream(newDir+file.getName());

                byte[] buffArray = new byte[1024*64];
                int preReadLength;
                while ((preReadLength = fileInputStream.read(buffArray))!=-1) {
                   fileOutPutStream.write(buffArray,0,preReadLength);
                }
                fileOutPutStream.flush();

                if(fileOutPutStream!=null) {
                    fileOutPutStream.close();
                }
                if(fileInputStream!=null) {
                    fileInputStream.close();
                }
                deleteFile(file);
            }

        }
        //删除原来的空目录
        deleteFile(oldDirFile);
    }
    /**
     * 检查目录是否存在
     * @param file
     * @return
     */
    public static boolean  checkDirExists(File file) {
        if(file.exists()) {
            if(file.isDirectory()) {
                return true;
            }
            System.out.println("the same file exists,but it is not a directory");
            return false;
        }
        return false;
    }

    /**
     * 删除文件
     * @param file
     * @return
     */
    public static boolean deleteFile (File file) {
        if(file.isDirectory()) {
            if(file.listFiles().length>0) {
                //System.out.println("该路径为非空目录，检查后手动删除");
                return false;
            }
        }
        return file.delete();
    }


    /**
     * 删除文件
     * @param fileStr
     */
    public static void deleteDir(String  fileStr) {
        File file = new File(fileStr);
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files==null) {
                file.delete();
            }
            for (File temp : files) {
               deleteDir(temp.toString());
            }
            file.delete();
        }else {
            file.delete();
        }

    }
}
