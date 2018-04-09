package com.newsoft.im.service;

import com.newsoft.im.model.domain.Record;

import java.util.List;

/**
 * @author
 * @create 2018-03-24 22:30
 * Description: 出入库记录服务接口
 */
public interface RecordService {
    /**
     * 查询全部
     * @return
     */
    List<Record> search(Long gid, String startDate, String endDate);
}
