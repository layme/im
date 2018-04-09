package com.newsoft.im.service.impl;

import com.newsoft.im.exception.IllegalOperationException;
import com.newsoft.im.model.domain.Record;
import com.newsoft.im.model.domain.Stock;
import com.newsoft.im.model.vo.GoodsVO;
import com.newsoft.im.repository.RecordRepository;
import com.newsoft.im.repository.StockRepository;
import com.newsoft.im.service.StockService;
import com.newsoft.im.util.LocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @create 2018-03-25 00:44
 * Description: 库存服务实现
 */
@Slf4j
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<GoodsVO> search(Long gid) {
        if (gid != null && gid > 0) {
            return stockRepository.getByGId(gid);
        } else {
            return stockRepository.listAll();
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void inRepository(Long gId, Integer number, String remark, Long uid) {
        Stock stock = stockRepository.getOne(gId);
        stock.setNumber(stock.getNumber() + number);
        stock.setModTime(LocalUtils.getCurrentDate());
        stockRepository.saveAndFlush(stock);  // 更新库存
        Record record = new Record(null, gId, "入库", remark, uid, LocalUtils.getCurrentDate());
        recordRepository.save(record);  // 记录入库操作
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void outRepository(Long gId, Integer number, String remark, Long uid) {
        Stock stock = stockRepository.getOne(gId);
        if (stock.getNumber() < number) {
            throw new IllegalOperationException("库存量不足");
        }
        stock.setNumber(stock.getNumber() - number);
        stockRepository.saveAndFlush(stock);
        Record record = new Record(null, gId, "出库", remark, uid, LocalUtils.getCurrentDate());
        recordRepository.save(record);  // 记录出库操作
    }
}
