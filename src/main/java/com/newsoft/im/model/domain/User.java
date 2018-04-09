package com.newsoft.im.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author
 * @create 2018-03-21 20:24
 * Description: 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Long uId;     // 用户ID

    @Column(name = "name")
    private String name;     // 姓名

    @Column(name = "sex")
    private String sex;      // 性别

    @Column(name = "age")
    private Integer age;     // 年龄

    @Column(name = "phone")
    private String phone;    // 手机号

    @Column(name = "role")
    private String role;     // 角色

    @Column(name = "regtime")
    private String regTime;  // 注册时间
}
