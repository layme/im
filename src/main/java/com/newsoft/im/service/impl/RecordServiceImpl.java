package com.newsoft.im.service.impl;

import com.newsoft.im.exception.IllegalOperationException;
import com.newsoft.im.model.domain.Record;
import com.newsoft.im.repository.RecordRepository;
import com.newsoft.im.service.RecordService;
import com.newsoft.im.util.LocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-03-25 00:30
 * Description: 出入库记录服务实现
 */
@Slf4j
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> search(Long gid, String startDate, String endDate) {
        log.debug("gid = {}, startDate = {}, endDate = {}", gid, startDate, endDate);

        if (gid != null && gid != 0) {
            if (LocalUtils.isEmpty(startDate) && LocalUtils.isEmpty(endDate)) {
                // only uid
                log.debug("only uid");
                return recordRepository.findByGId(gid);
            } else {
                // uid  start end
                log.debug("uid  start end");
                return recordRepository.findByGIdAndModTimeBetween(gid, startDate, endDate);
            }

        } else {
            if (LocalUtils.isEmpty(startDate) && LocalUtils.isEmpty(endDate)) {
                // no
                log.debug("no");
                return recordRepository.findAll();
            } else {
                // start end
                log.debug("start end");
                return recordRepository.findByModTimeBetween(startDate, endDate);
            }
        }
    }
}
