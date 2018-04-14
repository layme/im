package com.newsoft.im.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @create 2018-03-24 23:54
 * Description: 页面库存出参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVO {
    private Long gId;          // 商品ID
    private String name;       // 商品名称
    private Double price;      // 单价
    private Long tId;          // 类别ID
    private String typeName;   // 类别名称
    private String regName;    // 注册人
    private String regTime;    // 注册时间
    private Integer number;    // 数量
}
