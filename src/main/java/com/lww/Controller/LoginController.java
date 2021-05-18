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


    @RequestMapping("/login-success")
    public String loginSuccess(){
        return "登录成功";
    }
}
