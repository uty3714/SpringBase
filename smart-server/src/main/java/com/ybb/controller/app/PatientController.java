package com.ybb.controller.app;

import com.ybb.constant.MessageConstant;
import com.ybb.dto.patient.PatientDTO;
import com.ybb.dto.patient.PatientQueryDTO;
import com.ybb.exception.patient.PatientNotFoundException;
import com.ybb.result.PageResult;
import com.ybb.result.Result;
import com.ybb.service.IPatientService;
import com.ybb.vo.PatientVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 患者相关接口
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/patient")
public class PatientController {


    private IPatientService patientService;

    @Autowired
    public void setPatientService(IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * 新增患者
     *
     * @return {}
     */
    @PostMapping("/add")
    public String addNewPatient(@RequestBody PatientDTO patientDTO) {
        log.info("新增患者: {}", patientDTO);
        boolean addResult = patientService.addNewPatient(patientDTO);
        if (addResult) {
            return Result.success(MessageConstant.DATA_SAVE_SUCCESS);
        }
        return Result.error(MessageConstant.ADD_SQL_DATA_ERROR);
    }

    @PostMapping("/query")
    public String queryPatientPage(@RequestBody PatientQueryDTO patientQueryDTO) {
        log.info("模糊查询患者信息: {}", patientQueryDTO);
        PageResult<PatientVO> patientVOPageResult = patientService.queryPatientInfo(patientQueryDTO);
        if (patientVOPageResult == null ||
                patientVOPageResult.getRecords() == null ||
                patientVOPageResult.getRecords().size() == 0) {
            throw new PatientNotFoundException(MessageConstant.QUERY_PATIENT_NOT_FOUND);
        }
        return Result.success(patientVOPageResult);
    }

}
