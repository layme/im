package com.newsoft.im.service.impl;

import com.newsoft.im.exception.AccountDisableException;
import com.newsoft.im.exception.DataMissingException;
import com.newsoft.im.exception.PasswordWrongException;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.repository.LoginRepository;
import com.newsoft.im.model.domain.Login;
import com.newsoft.im.repository.UserRepository;
import com.newsoft.im.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

/**
 * @author
 * @create 2018-03-22 22:50
 * Description: 登录服务实现
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void login(Login login, HttpSession session) {
        Login loginTemp = null;
        try {
            loginTemp = loginRepository.getOne(login.getUId());
        } catch (Exception e) {
            throw new DataMissingException("用户不存在");
        }

        if (loginTemp.getEnable()) {
            if (login.getPassword().equals(loginTemp.getPassword())) {
                User user = userRepository.getOne(login.getUId());
                if (user == null) {
                    throw new DataMissingException("未查询到用户信息");
                }
                log.debug("u = " + user.toString());
                session.setAttribute("user", user);  // 记录用户信息
                log.info("用户{} 登录成功", login.getUId());
            } else {
                throw new PasswordWrongException("密码错误，请检查后再试");
            }
        } else {
            throw new AccountDisableException("账号被禁用，请联系管理员");
        }
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
        log.info("用户退出系统");
    }
}
