package com.joey.springboot.config;

import com.joey.springboot.component.LoginHandlerInterceptor;
import com.joey.springboot.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 〈自定义MVC配置〉
 *
 * @author Joey
 * @create 2018-12-17
 * @since 1.0.0
 */
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {


    //自定义拦截配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

//    public WebMvcConfigurer webMvcConfigurer(){
//        WebMvcConfigurer adapter = new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//
//                registry.addViewController("/xxx").setViewName("login");
//                System.out.println("111111111111111111111111111111");
//            }
//        };
//        return adapter;
//    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
    *注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//      registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//          .excludePathPatterns("/","/index.html","/user/login");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/main.html");
    }
}
