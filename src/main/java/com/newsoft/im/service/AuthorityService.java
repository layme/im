package com.newsoft.im.service;

import com.newsoft.im.model.domain.Authority;
import com.newsoft.im.model.domain.Goods;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:28
 * Description: 权限服务接口
 */
public interface AuthorityService {
    /**
     * 获取权限列表
     * @param role
     * @return
     */
    List<Authority> findAllByRole(String role);
}
