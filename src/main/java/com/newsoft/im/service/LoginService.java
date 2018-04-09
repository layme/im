package com.newsoft.im.service;

import com.newsoft.im.model.domain.Login;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @create 2018-03-21 17:24
 * Description: 登陆服务接口
 */
public interface LoginService {
    /**
     * 登录
     * @param login
     * @param session
     */
    void login(Login login, HttpSession session);

    /**
     * 退出
     * @param session
     */
    void logout(HttpSession session);
}
