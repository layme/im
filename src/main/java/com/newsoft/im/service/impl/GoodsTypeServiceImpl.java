package com.newsoft.im.service.impl;

import com.newsoft.im.model.domain.GoodsType;
import com.newsoft.im.model.domain.User;
import com.newsoft.im.repository.GoodsTypeRepository;
import com.newsoft.im.service.GoodsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-03-25 00:19
 * Description: 商品种类服务实现
 */
@Slf4j
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @Override
    public GoodsType add(GoodsType goodsType) {
        return goodsTypeRepository.save(goodsType);
    }

    @Override
    public void delete(List<GoodsType> goodsTypes) {
        goodsTypeRepository.deleteAll(goodsTypes);
    }

    @Override
    public GoodsType update(GoodsType goodsType) {
        return goodsTypeRepository.saveAndFlush(goodsType);
    }

    @Override
    public List<GoodsType> findAll() {
        return goodsTypeRepository.findAll();
    }

    @Override
    public GoodsType getOne(Long id) {
        return goodsTypeRepository.getOne(id);
    }
}
