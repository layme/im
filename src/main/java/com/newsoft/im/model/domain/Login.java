package com.newsoft.im.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author
 * @create 2018-03-21 20:26
 * Description: 登陆信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "uid")
    private Long uId;      // 用户ID

    @Column(name = "password")
    private String password;  // 密码

    @Column(name = "enable")
    private Boolean enable;   // 启用标记
}
