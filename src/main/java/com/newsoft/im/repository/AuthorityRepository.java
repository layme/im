package com.newsoft.im.repository;


import com.newsoft.im.model.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author
 * @create 2018-04-14 21:42
 * Description: 权限仓库接口
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findAllByRole(String role);
}
