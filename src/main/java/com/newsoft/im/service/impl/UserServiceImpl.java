package com.newsoft.im.service.impl;

import com.newsoft.im.model.domain.Login;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.model.vo.UserVO;
import com.newsoft.im.repository.LoginRepository;
import com.newsoft.im.repository.UserRepository;
import com.newsoft.im.service.UserService;
import com.newsoft.im.util.LocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:42
 * Description: 用户服务实现
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginRepository loginRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public User add(UserVO userVO) {
        User user = userRepository.save(new User(null,
                userVO.getName(),
                userVO.getSex(),
                userVO.getAge(),
                userVO.getPhone(),
                userVO.getRole(),
                LocalUtils.getCurrentDate()));
        loginRepository.save(new Login(user.getUId(),userVO.getPassword(),true));
        userVO.setUId(user.getUId());  // 同步账号ID
        return user;
    }

    @Override
    public void delete(List<User> users) {
        userRepository.deleteAll(users);
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> search(Long uid) {
        if (uid != null && uid > 0) {
            return userRepository.findByUId(uid);
        } else {
            return userRepository.findAll();
        }
    }

    @Override
    public User getOne(Long uid) {
        return userRepository.getOne(uid);
    }
}
