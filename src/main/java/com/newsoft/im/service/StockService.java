package com.newsoft.im.service;

import com.newsoft.im.model.vo.GoodsVO;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 23:53
 * Description: 库存服务接口
 */
public interface StockService {
    /**
     * 查询全部
     * @return
     */
    List<GoodsVO> search(Long gid);

    /**
     * 商品入库
     * @param gId
     * @param number
     */
    void inRepository(Long gId, Integer number, String remark, Long uid);

    /**
     * 商品出库
     * @param gId
     * @param number
     */
    void outRepository(Long gId, Integer number, String remark, Long uid);
}
