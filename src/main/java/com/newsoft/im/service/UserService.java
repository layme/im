package com.newsoft.im.service;

import com.newsoft.im.model.domain.User;
import com.newsoft.im.model.vo.UserVO;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:27
 * Description: 用户服务接口
 */
public interface UserService {
    /**
     * 添加单个
     * @param userVO
     * @return
     */
    User add(UserVO userVO);

    /**
     * 批量删除
     * @param users
     */
    void delete(List<User> users);

    /**
     * 更新用户
     * @param user
     * @return
     */
    User update(User user);

    /**
     * 查询全部
     * @return
     */
    List<User> search(Long uid);

    /**
     * 查询单个
     * @param uid
     * @return
     */
    User getOne(Long uid);
}
