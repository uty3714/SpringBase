package com.ybb.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 新增患者请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    /**
     * 诊所ID
     */
    private String clinicId;
    /**
     * 患者姓名
     */
    private String patientName;
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
     * 备注
     */
    private String patientRemark;
}
