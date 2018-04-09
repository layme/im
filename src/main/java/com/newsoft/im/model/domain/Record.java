package com.newsoft.im.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author
 * @create 2018-03-21 20:27
 * Description: 出入库记录类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue
    @Column(name = "rid")
    private Long rId;           // 流水号

    @Column(name = "gid")
    private Long gId;           // 商品ID

    @Column(name = "modification")
    private String modification;   // 修改操作

    @Column(name = "remark")
    private String remark;         // 备注

    @Column(name = "uid")
    private Long uId;        // 操作用户ID

    @Column(name = "modtime")
    private String modTime;        // 修改时间
}
