package com.ybb.service;

import com.github.pagehelper.Page;
import com.ybb.dto.patient.PatientDTO;
import com.ybb.dto.patient.PatientQueryDTO;
import com.ybb.dto.patient.PatientUpdateDTO;
import com.ybb.result.PageResult;
import com.ybb.vo.PatientVO;

public interface IPatientService {

    /**
     * 新增患者
     * @param patientDTO 患者信息
     * @return 新增结果
     */
    boolean addNewPatient(PatientDTO patientDTO);

    /**
     * 根据条件查询患者信息
     *
     * @param patientQueryDTO 查询的信息
     * @return Page分页信息
     */
    PageResult<PatientVO> queryPatientInfo(PatientQueryDTO patientQueryDTO);

    /**
     * 修改患者信息
     * @param patientUpdateDTO 要修改的信息
     * @return 修改结果
     */
    boolean updatePatientInfo(PatientUpdateDTO patientUpdateDTO);

    /**
     * 删除患者信息
     * @param patientId 患者id
     * @return 删除结果
     */
    boolean deletePatient(String patientId);

}
