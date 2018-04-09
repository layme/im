package com.newsoft.im.service;

import com.newsoft.im.model.domain.GoodsType;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:28
 * Description: 商品类型服务接口
 */
public interface GoodsTypeService {
    /**
     * 添加单个
     * @param goodsType
     * @return
     */
    GoodsType add(GoodsType goodsType);

    /**
     * 批量删除
     * @param goodsTypes
     */
    void delete(List<GoodsType> goodsTypes);

    /**
     * 更新商品信息
     * @param goodsType
     * @return
     */
    GoodsType update(GoodsType goodsType);

    /**
     * 查询全部
     * @return
     */
    List<GoodsType> findAll();

    /**
     * 根据ID查询单个
     * @param id
     * @return
     */
    GoodsType getOne(Long id);
}
