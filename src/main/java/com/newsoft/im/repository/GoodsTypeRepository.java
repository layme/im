package com.newsoft.im.repository;

import com.newsoft.im.model.domain.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author
 * @create 2018-03-22 22:53
 * Description: 商品类型仓库接口
 */
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long> {
}
