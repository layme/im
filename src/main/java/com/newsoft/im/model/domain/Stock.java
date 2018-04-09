package com.newsoft.im.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @create 2018-03-22 15:50
 * Description: 库存数量表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "gid")
    private Long gId;       // 商品ID

    @Column(name = "number")
    private Integer number;    // 数量

    @Column(name = "modtime")
    private String modTime;    // 最后修改时间
}
