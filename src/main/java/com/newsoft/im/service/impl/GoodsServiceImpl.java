package com.newsoft.im.service.impl;

import com.newsoft.im.model.domain.Goods;
import com.newsoft.im.model.domain.Record;
import com.newsoft.im.model.domain.Stock;
import com.newsoft.im.repository.GoodsRepository;
import com.newsoft.im.repository.RecordRepository;
import com.newsoft.im.repository.StockRepository;
import com.newsoft.im.service.GoodsService;
import com.newsoft.im.util.LocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @create 2018-03-25 00:27
 * Description: 商品服务实现
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Goods add(Goods goods) {
        goods = goodsRepository.save(goods);
        stockRepository.save(new Stock(goods.getGId(), 0, LocalUtils.getCurrentDate()));
        return goods;
    }

    @Override
    public void delete(Long gId, Long uId) {
        Goods goods = goodsRepository.getOne(gId);
        Stock stock = stockRepository.getOne(goods.getGId());
        stockRepository.delete(stock);
        goodsRepository.delete(goods);
        Record record = new Record(null, gId, "删除商品", "库存快照：" + stock.getNumber(), uId, LocalUtils.getCurrentDate());
        recordRepository.save(record);
    }

    @Override
    public Goods update(Goods goods) {
        return goodsRepository.saveAndFlush(goods);
    }

    @Override
    public List<Goods> search(Long gid) {
        if (gid != null && gid > 0) {
            return goodsRepository.findByGId(gid);
        } else {
            return goodsRepository.findAll();
        }
    }

    @Override
    public Goods getOne(Long id) {
        return goodsRepository.getOne(id);
    }
}
