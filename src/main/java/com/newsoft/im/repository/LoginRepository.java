package com.newsoft.im.repository;

import com.newsoft.im.model.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author
 * @create 2018-03-22 22:53
 * Description: 登录仓库接口
 */
public interface LoginRepository extends JpaRepository<Login, Long> {
}
