package com.newsoft.im.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author
 * @create 2018-03-24 22:56
 * Description: 接收页面传来的用户对象
 */
@Data
@AllArgsConstructor
public class UserVO {
    private Long uId;      // 用户ID
    private String name;      // 姓名
    private String sex;       // 性别
    private Integer age;      // 年龄
    private String phone;     // 手机号
    private String role;      // 角色
    private String regTime;     // 注册时间
    private String password;  // 密码
    private Boolean enable;   // 启用标记
}
