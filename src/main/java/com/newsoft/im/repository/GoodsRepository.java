package com.newsoft.im.repository;

import com.newsoft.im.model.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author
 * @create 2018-03-22 22:53
 * Description: 商品仓库接口
 */
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findByGId(Long gid);
}
