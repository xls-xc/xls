package com.xls.fx.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util
 * @ClassName: CodeAutoGeneratorUtil
 * @Description: 代码自动生成工具
 * @Author: SkyChen
 * @Create: 2020-04-28 10:56
 * @Version: v1.0
 **/
@Data
public class CodeAutoGeneratorUtil {
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



    public static void auto(String createPath,String driverClass,String mysqlUrl,String userName,String password,
                            String baseController,String basePackage,String[] tableName){
        CodeAutoGeneratorUtil.createPath = createPath;
        CodeAutoGeneratorUtil.driverClass = driverClass;
        CodeAutoGeneratorUtil.mysqlUrl = mysqlUrl;
        CodeAutoGeneratorUtil.userName = userName;
        CodeAutoGeneratorUtil.password = password;
        CodeAutoGeneratorUtil.baseController = baseController;
        CodeAutoGeneratorUtil.basePackage = basePackage;
        CodeAutoGeneratorUtil.tableName = tableName;


        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        overallConfig(mpg);

        // 数据源配置
        dataSourceConfig(mpg);

        // 策略配置
        strategyConfig(mpg);

        //包配置
        packageConfig(mpg);

        // 执行生成
        mpg.execute();

        AutoGenerator mpg1 = new AutoGenerator();
        createMapperXml(mpg1);
        mpg1.execute();

    }




    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        overallConfig(mpg);

        // 数据源配置
        dataSourceConfig(mpg);

        // 策略配置
        strategyConfig(mpg);

        //包配置
        packageConfig(mpg);

        // 执行生成
        mpg.execute();

        AutoGenerator mpg1 = new AutoGenerator();
        createMapperXml(mpg1);
        mpg1.execute();
    }

    /**
     * 全局配置
     * @param mpg
     */
    private static void overallConfig(AutoGenerator mpg){
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(createPath);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        // 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("chenshuaikai");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);
    }

    /**
     * 数据源配置
     * @param mpg
     */
    private static void dataSourceConfig(AutoGenerator mpg) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverClass);
        dsc.setUrl(mysqlUrl);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);
    }


    /**
     * 策略配置
     * @param mpg
     */
    private static void strategyConfig(AutoGenerator mpg) {
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        //strategy.setTablePrefix(new String[]{"sys_"});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //strategy.setNaming(NamingStrategy.nochange);
        // 需要生成的表
        //strategy.setInclude(new String[]{tableName});
        strategy.setInclude(tableName);
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);
        // 自定义 controller 父类
        strategy.setSuperControllerClass(baseController);
        mpg.setStrategy(strategy);
    }



    /**
     * 包配置
     * @param mpg
     */
    private static void packageConfig(AutoGenerator mpg) {
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackage);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
    }






    /**
     * 只生成mapeerXml的方法
     * @param mpg
     */
    private static void createMapperXml(AutoGenerator mpg) {
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(createPath);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        // 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("chenhusikai");// 作者
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverClass);
        dsc.setUrl(mysqlUrl);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(tableName);
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);
        mpg.setStrategy(strategy);


        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackage);
        pc.setController("delete");
        pc.setService("delete");
        pc.setServiceImpl("delete");
        pc.setMapper("delete");
        pc.setEntity("delete");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();

    }
}
