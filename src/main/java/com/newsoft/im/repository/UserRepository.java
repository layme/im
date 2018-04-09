package com.newsoft.im.repository;

import com.newsoft.im.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author
 * @create 2018-03-21 22:19
 * Description: 用户仓库接口
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUId(Long uid);
}
