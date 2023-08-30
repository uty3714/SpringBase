package com.ybb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户登录请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;


}
