package com.ybb.mapper;

import com.github.pagehelper.Page;
import com.ybb.dto.patient.PatientQueryDTO;
import com.ybb.entity.TabPatientEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper {

    void addNewPatient(TabPatientEntity tabPatientEntity);

    /**
     * 条件查询患者信息
     * @param patientQueryDTO 条件查询
     * @return List[TabPatientEntity]
     */
    Page<TabPatientEntity> queryPatientInfo(PatientQueryDTO patientQueryDTO);

}
