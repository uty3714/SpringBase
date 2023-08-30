package com.ybb.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 患者查询请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientQueryDTO {

    /**
     * 一次查多少页
     */
    private Integer pageSize;
    /**
     * 查第几页
     */
    private Integer pageIndex;
    /**
     * 诊所id
     */
    private String clinicId;
    //模糊查询
    /**
     * 患者姓名
     */
    private String patientName;
    /**
     * 患者姓名简写
     */
    private String patientSortName;
    /**
     * 患者手机号
     */
    private String patientPhone;
    /**
     * 患者身份证号
     */
    private String patientIdCard;

}
