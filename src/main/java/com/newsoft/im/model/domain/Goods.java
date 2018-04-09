package com.newsoft.im.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author
 * @create 2018-03-21 20:26
 * Description: 商品类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue
    @Column(name = "gid")
    private Long gId;    // 商品ID

    @Column(name = "name")
    private String name;    // 商品名称

    @Column(name = "tid")
    private Long tId;     // 种类ID

    @Column(name = "price")
    private Double price;  // 单价

    @Column(name = "uid")
    private Long uId;    // 注册用户ID

    @Column(name = "regtime")
    private String regTime; // 注册时间
}
