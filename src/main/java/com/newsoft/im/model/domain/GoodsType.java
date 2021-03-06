package com.newsoft.im.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author
 * @create 2018-03-21 20:26
 * Description: 商品种类信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goodstype")
public class GoodsType {
    @Id
    @GeneratedValue
    @Column(name = "tid")
    private Long tId;     // 种类ID

    @Column(name = "name")
    private String name;     // 种类名称

    @Column(name = "uid")
    private Long uId;     // 注册用户ID

    @Column(name = "regtime")
    private String regTime;  // 注册时间
}
