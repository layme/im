package com.newsoft.im.repository;

import com.newsoft.im.model.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author
 * @create 2018-03-22 22:53
 * Description: 操作记录仓库接口
 */
public interface RecordRepository extends JpaRepository<Record, Long> {
    /**
     * 根据日期区间查询操作记录
     * @param startDate
     * @param endDate
     * @return
     */
    List<Record> findByModTimeBetween(String startDate, String endDate);

    /**
     * 根据用户ID查询操作记录
     * @param gid
     * @return
     */
    List<Record> findByGId(Long gid);

    /**
     * 全部都有
     * @param gid
     * @param startDate
     * @param endDate
     * @return
     */
    List<Record> findByGIdAndModTimeBetween(Long gid, String startDate, String endDate);
}
