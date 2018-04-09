package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.Login;
import com.newsoft.im.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @create 2018-03-21 15:27
 * Description:
 */
@RestController
@RequestMapping(value = "/api/system")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public RestResult login(@RequestParam(value = "uid") Long uid, @RequestParam(value = "password") String password, HttpSession session) {
//    public RestResult login(Login login, HttpSession session) {
        loginService.login(new Login(uid, password, null), session);
        return RestResultGenerator.genSuccessResult("登录成功");
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public RestResult logout(HttpSession session) {
        loginService.logout(session);
        return RestResultGenerator.genSuccessResult("退出成功");
    }
}
