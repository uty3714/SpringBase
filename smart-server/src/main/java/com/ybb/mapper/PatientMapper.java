package com.ybb.mapper;

import com.github.pagehelper.Page;
import com.ybb.dto.patient.PatientQueryDTO;
import com.ybb.dto.patient.PatientUpdateDTO;
import com.ybb.entity.TabPatientEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper {

    int addNewPatient(TabPatientEntity tabPatientEntity);

    /**
     * 条件查询患者信息
     * @param patientQueryDTO 条件查询
     * @return List[TabPatientEntity]
     */
    Page<TabPatientEntity> queryPatientInfo(PatientQueryDTO patientQueryDTO);

    /**
     * 更新修改患者信息
     * @param patientUpdateDTO 更新患者内容
     */
    int updatePatientInfo(PatientUpdateDTO patientUpdateDTO);

}
