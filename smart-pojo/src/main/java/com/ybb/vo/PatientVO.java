package com.ybb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 患者请求返回实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientVO {
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

}
