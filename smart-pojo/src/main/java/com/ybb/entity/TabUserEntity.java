package com.ybb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TabUserEntity implements Serializable {

    /**
     *   `user_id` BIGINT NOT NULL COMMENT '用户ID',
     *   `clinic_id` VARCHAR(40) NOT NULL COMMENT '所属诊所ID',
     *   `user_name` VARCHAR(20) NOT NULL COMMENT '用户账号',
     *   `user_pwd` VARCHAR(40) NOT NULL COMMENT '用户密码',
     * 	 `doctor_name` VARCHAR(50) NOT NULL COMMENT '医生名称',
     *   `user_sex` INT(11) DEFAULT '1' COMMENT '用户性别 1男 0女',
     *   `user_id_card` VARCHAR(20) DEFAULT NULL COMMENT '用户身份号',
     *   `user_phone` VARCHAR(20) DEFAULT NULL COMMENT '用户手机',
     *   `user_role` INT(11) NOT NULL DEFAULT '1' COMMENT '用户角色 0 管理员 1 普通员工',
     *   `user_remark` VARCHAR(50) DEFAULT NULL COMMENT '备注',
     * 	 `user_status` VARCHAR(11) NOT NULL DEFAULT '1' COMMENT '用户账号状态 1正常 0 禁用',
     * 	 `create_user` BIGINT DEFAULT NULL COMMENT '创建记录的用户',
     * 	 `update_user` BIGINT DEFAULT NULL COMMENT '修改记录的用户',
     * 	 `create_time` DATETIME DEFAULT NULL COMMENT '创建用户时间',
     *   `update_time` DATETIME DEFAULT NULL COMMENT '更新用户时间',
     */

    private Long userId;
    private String clinicId;
    private String userName;
    private String userPwd;
    private String doctorName;
    private Integer userSex;
    private String userIdCard;
    private String userPhone;
    private Integer userRole;
    private String userRemark;
    private Integer userStatus;
    private Long createUser;
    private Long updateUser;
    private Date createTime;
    private Date updateTime;

}
