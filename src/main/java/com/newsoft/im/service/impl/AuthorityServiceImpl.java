package com.newsoft.im.service.impl;

import com.newsoft.im.model.domain.Authority;
import com.newsoft.im.repository.AuthorityRepository;
import com.newsoft.im.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:28
 * Description: 权限服务实现服务接口
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    /**
     * 获取权限列表
     * @param role
     * @return
     */
    @Override
    public List<Authority> findAllByRole(String role) {
        return authorityRepository.findAllByRole(role);
    }
}
