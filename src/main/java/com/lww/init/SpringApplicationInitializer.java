package com.lww.init;

import com.lww.config.ApplicationConfig;
import com.lww.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author lww
 * @Description
 * @create 2021-05-18 16:40
 * spring 容器 初始化相关
 */
public class SpringApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 加载 配置  相当于加载applicationContext.xml
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    /**
     * 相当于加载springMvc.xml
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
