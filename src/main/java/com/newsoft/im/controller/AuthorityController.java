package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author
 * @create 2018-04-14 21:54
 * Description: 权限控制器
 */
@RestController
@SessionAttributes("user")
@RequestMapping(value = "/api/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    /**
     * 获取权限列表
     * @param user
     * @return
     */
    @RequestMapping(value = "/findAllByRole")
    public RestResult findAllByRole(@ModelAttribute("user") User user) {
        return RestResultGenerator.genSuccessResult(authorityService.findAllByRole(user.getRole()));
    }
}
