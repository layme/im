package com.newsoft.im.controller;

import com.newsoft.im.exception.handler.RestResult;
import com.newsoft.im.exception.handler.RestResultGenerator;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.model.vo.UserVO;
import com.newsoft.im.service.UserService;
import com.newsoft.im.util.LocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author
 * @create 2018-03-21 15:28
 * Description:
 */
@Slf4j
@RestController
@SessionAttributes("user")
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/search")
    public RestResult search(@ModelAttribute("user") User user, Long uid) {
        return RestResultGenerator.genSuccessResult(userService.search(uid));
    }

    @RequestMapping(value = "/update")
    public RestResult update(@ModelAttribute("user") User user, Long uId, String name, String sex, Integer age, String phone, String role, String regTime) {
        userService.update(new User(uId, name, sex, age, phone, role, regTime));
        return RestResultGenerator.genSuccessResult(null);
    }

    @RequestMapping(value = "/add")
    public RestResult add(@ModelAttribute("user") User user, String name, String sex, Integer age, String phone, String role, String password) {
        return RestResultGenerator.genSuccessResult(
                userService.add(new UserVO(null, name, sex, age, phone, role, LocalUtils.getCurrentDate(), password, true)));
    }

    @RequestMapping(value = "/delete")
    public RestResult delete(@ModelAttribute("user") User user, String uid) {
        ArrayList<User> list = new ArrayList<User>();
        list.add(userService.getOne(Long.valueOf(uid)));
        userService.delete(list);
        return RestResultGenerator.genSuccessResult(null);
    }
}
