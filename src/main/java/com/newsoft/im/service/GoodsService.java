package com.newsoft.im.service;

import com.newsoft.im.model.domain.Goods;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:28
 * Description: 商品服务接口
 */
public interface GoodsService {
    /**
     * 添加单个
     * @param goods
     * @return
     */
    Goods add(Goods goods);

    /**
     * 批量删除
     * @param gid
     */
    void delete(Long gid, Long uId);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    Goods update(Goods goods);

    /**
     * 查询全部
     * @return
     */
    List<Goods> search(Long gid);

    /**
     * 根据ID查询单个
     * @param id
     * @return
     */
    Goods getOne(Long id);
}
