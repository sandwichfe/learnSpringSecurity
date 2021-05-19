package com.lww.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author user
 * @Description
 * @create 2021-05-18 17:26
 */
@RestController
public class LoginController {
    @RequestMapping(value="/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return "login success";
    }


    @RequestMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return "访问资源1";
    }

    @RequestMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        return "访问资源2";
    }

    @RequestMapping(value = "/hello",produces = {"text/plain;charset=UTF-8"})
    public String hello(){
        return "hello";
    }
}
