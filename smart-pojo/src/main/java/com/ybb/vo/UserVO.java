package com.ybb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 请求返回实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private Long userId;
    private String clinicId;
    private String userName;
    private String userToken;
    private String doctorName;
    private Integer userSex;
    private String userIdCard;
    private String userPhone;
    private Integer userRole;
    private String userRemark;
    private Integer userStatus;

}
