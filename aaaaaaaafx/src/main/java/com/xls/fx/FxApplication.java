package com.xls.fx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FxApplication {

    public static void main(String[] args) {
        try {

            SpringApplication.run(FxApplication.class, args);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}