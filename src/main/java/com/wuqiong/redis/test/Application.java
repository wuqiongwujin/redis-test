package com.wuqiong.redis.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @author Cain
 * @date 2019/1/30
 */
@SpringBootApplication
public class Application {

    private static Log logger = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("spring boot start====");
    }
}
