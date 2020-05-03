package com.xls.fx.util;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util
 * @ClassName: AutoProjectUtil
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-05-03 17:59
 * @Version: v1.0
 **/
public class AutoProjectUtil {
    private static String uselessPackage = "C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\java\\com\\xls\\fx\\auto\\delete";
    private static String fromChangeFilePackage = "C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\java\\com\\xls\\fx\\auto\\xml";
    private static String toChangeFilePath = "C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\resources\\mapper";

    /**
     * 需要生生的路径
     */
    private static String createPath="C:\\Users\\clement\\Desktop\\xls\\fx\\src\\main\\java";

    private static String driverClass = "com.mysql.cj.jdbc.Driver";
    private static String mysqlUrl = "jdbc:mysql://192.168.216.202:3306/xc";
    private static String userName = "root";
    private static String password = "123456";
    /**
     * 自定义父类
     */
    private static String baseController = "com.xls.fx.config.BaseController";
    /**
     * 基础包名
     */
    private static String basePackage = "com.xls.fx.auto";

    /**
     * 需要生成的表名
     */
    private static String[] tableName={"xc_interaction_log"};

    public static void main(String[] args) {
        CodeAutoGeneratorUtil.auto(createPath,driverClass,mysqlUrl,userName,password,baseController,basePackage,tableName);
        FileUtil.codeHelper(fromChangeFilePackage,toChangeFilePath,uselessPackage);
    }

    public static void createTableEntity(String[] tableNames) {
        CodeAutoGeneratorUtil.auto(createPath,driverClass,mysqlUrl,userName,password,baseController,basePackage,tableNames);
        FileUtil.codeHelper(fromChangeFilePackage,toChangeFilePath,uselessPackage);
    }
}
