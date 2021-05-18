package com.lww.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import sun.security.util.ManifestDigester;

/**
 * @author user
 * @Description
 * @create 2021-05-18 17:07
 * Spring Security 相关
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义用户信息服务（查询用户信息）
     */
    @Bean
    public UserDetailsService getUserDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //这个User是 Security 自带的UserDetail里面的User
        //创建正常登录的用户信息 （应该从数据库查出来创建用户 这里暂时省略查数据库直接写值了）
        manager.createUser(User.withUsername("lww").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("test").password("123").authorities("p2").build());
        return manager;
    }


    /**
     * 密码编码器  （密码比对）
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        //暂时使用 直接比对策略
        return NoOpPasswordEncoder.getInstance();
    }



    /**
     * 配置安全拦截机制 （那些资源路径时需要做安全拦截的）   ！important
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //以 r/** 的请求都必须经过认证通过
                .antMatchers("/r/**").authenticated()
                //此外 其他的请求可以随便访问
                .anyRequest().permitAll()
                .and()
                //允许表单登录
                .formLogin()
                //登录成功后跳转的  url
                .successForwardUrl("/login-success");


    }
}
