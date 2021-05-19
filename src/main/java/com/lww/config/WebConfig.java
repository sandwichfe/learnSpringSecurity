package com.lww.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author lww
 * @Description
 * @create 2021-05-18 16:30
 * spring mvc 相关配置
 */
@Configuration
@EnableWebMvc
/**这个 ComponentScan注解不能删  我也不知道是什么情况*/
@ComponentScan(basePackages = "com.lww",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    /**
     * 视图解析器 bean
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //视图前缀
        viewResolver.setPrefix("/WEB-INF/");
        //视图后缀
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //   redirect:/login  跳到spring Security 默认提供的一个登录页面
        registry.addViewController("/").setViewName("redirect:/login");
    }
}
