package com.newsoft.im.repository;

import com.newsoft.im.model.domain.Stock;
import com.newsoft.im.model.vo.GoodsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author
 * @create 2018-03-22 22:53
 * Description: 库存仓库接口
 */
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("select new com.newsoft.im.model.vo.GoodsVO(g.gId, g.name, g.price, gt.tId, gt.name as typeName, u.name as regName, g.regTime, s.number) " +
            "from Goods g " +
            "left join Stock s on s.gId = g.gId " +
            "left join GoodsType gt on gt.tId = g.tId " +
            "left join User u on u.uId = g.uId " +
            "where g.gId = ?1")
    List<GoodsVO> getByGId(Long gid);

    @Query("select new com.newsoft.im.model.vo.GoodsVO(g.gId, g.name, g.price, gt.tId, gt.name as typeName, u.name as regName, g.regTime, s.number) " +
            "from Goods g " +
            "left join Stock s on s.gId = g.gId " +
            "left join GoodsType gt on gt.tId = g.tId " +
            "left join User u on u.uId = g.uId")
    List<GoodsVO> listAll();
}
