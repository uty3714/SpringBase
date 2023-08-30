package com.ybb.service;

import com.github.pagehelper.Page;
import com.ybb.dto.patient.PatientDTO;
import com.ybb.dto.patient.PatientQueryDTO;
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


}
