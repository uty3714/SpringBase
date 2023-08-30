package com.ybb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 患者实体表
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TabPatientEntity {

    /*
     *  `patient_id` VARCHAR(50) NOT NULL COMMENT '患者ID',
     *  `clinic_id` VARCHAR(50) NOT NULL COMMENT '诊所ID',
     *  `patient_name` VARCHAR(50) NOT NULL COMMENT '患者姓名',
     *  `patient_sort_name` VARCHAR(50) NOT NULL COMMENT '患者姓名简称',
     *  `patient_sex` INT(11) DEFAULT 1 COMMENT '患者性别 1男 0 女',
     *  `patient_age` VARCHAR(50) DEFAULT 0 COMMENT '患者年龄',
     *  `patient_birthday` VARCHAR(50) DEFAULT NULL COMMENT '患者出生日期',
     *  `patient_phone` VARCHAR(50) DEFAULT NULL COMMENT '患者手机号',
     *  `patient_id_card` VARCHAR(20) DEFAULT NULL COMMENT '患者身份证号',
     *  `patient_address` VARCHAR(50) DEFAULT NULL COMMENT '患者家庭地址',
     * 	`patient_ill_history` VARCHAR(200) DEFAULT NULL COMMENT '患者病史',
     * 	`patient_allergic_history` VARCHAR(200) DEFAULT NULL COMMENT '患者过敏史',
     * 	`patient_diagnose` VARCHAR(200) DEFAULT NULL COMMENT '患者最新诊断',
     * 	`patient_total_arrears` INT(20) DEFAULT 0 COMMENT '欠款',
     *  `patient_remark` VARCHAR(100) DEFAULT NULL COMMENT '备注',
     *  `patient_status` INT(11) DEFAULT 1 COMMENT '患者状态 1可用0 停用',
     *  `create_user` BIGINT DEFAULT NULL COMMENT '创建记录的用户',
     * 	`update_user` BIGINT DEFAULT NULL COMMENT '修改记录的用户',
     * 	`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
     *  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
     */

    /**
     * 患者ID
     */
    private String patientId;
    /**
     * 诊所ID
     */
    private String clinicId;
    /**
     * 患者姓名
     */
    private String patientName;
    /**
     * 患者姓名简称
     */
    private String patientSortName;
    /**
     * 患者性别 1男 0 女
     */
    private Integer patientSex;
    /**
     * 患者年龄
     */
    private String patientAge;
    /**
     * 患者出生日期
     */
    private String patientBirthday;
    /**
     * 患者手机号
     */
    private String patientPhone;
    /**
     * 患者身份证号
     */
    private String patientIdCard;
    /**
     * 患者家庭地址
     */
    private String patientAddress;
    /**
     * 患者病史
     */
    private String patientIllHistory;
    /**
     * 患者过敏史
     */
    private String patientAllergicHistory;
    /**
     * 患者最新诊断
     */
    private String patientDiagnose;
    /**
     * 欠款单位分
     */
    private Integer patientTotalArrears;
    /**
     * 备注
     */
    private String patientRemark;
    /**
     * 患者状态 1可用0 停用
     */
    private Integer patientStatus;
    /**
     * 创建记录的用户
     */
    private String createUser;
    /**
     * 修改记录的用户
     */
    private String updateUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
