package com.xls.fx;


import com.alibaba.druid.support.json.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FxApplication {

    private static Logger logger = LoggerFactory.getLogger(FxApplication.class);

    public static void main(String[] args) {
        logger.info("====================fx繁星工程开始启动=====================");
        try{
            SpringApplication.run(FxApplication.class, args);
        }catch (Exception e) {
            logger.error("====================fx繁星工程启动异常====================",e);
        }

        logger.info("====================fx繁星工程正常启动====================");
    }

}
