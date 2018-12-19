package com.joey.springboot;

import com.joey.springboot.controller.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SuppressWarnings("ALL")
@SpringBootApplication
public class Application 
{

    //private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main( String[] args )
    {
//        logger.error("这是ERROR信息");
//        logger.warn("这是WARN信息");
//        logger.info("这是INFO信息");
//        logger.debug("这是DEBUG信息");
//        logger.trace("这是TRACE信息");
        SpringApplication.run(Application.class, args);
    }
}
