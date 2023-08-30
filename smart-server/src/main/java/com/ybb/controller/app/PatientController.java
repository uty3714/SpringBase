package com.ybb.controller.app;

import com.alibaba.druid.util.StringUtils;
import com.ybb.constant.MessageConstant;
import com.ybb.context.BaseContext;
import com.ybb.dto.patient.PatientDTO;
import com.ybb.dto.patient.PatientQueryDTO;
import com.ybb.dto.patient.PatientUpdateDTO;
import com.ybb.exception.ParameterRequiredNullException;
import com.ybb.exception.patient.PatientNotFoundException;
import com.ybb.result.PageResult;
import com.ybb.result.Result;
import com.ybb.service.IPatientService;
import com.ybb.vo.PatientVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return Result.error(MessageConstant.DATA_SAVE_FAILED);
    }


    /**
     * 分页查询患者
     *
     * @param patientQueryDTO 查询条件
     * @return {}
     */
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

    /**
     * 更新修改患者信息
     *
     * @param patientUpdateDTO 更新的内容
     * @return {}
     */
    @PostMapping("/update")
    public String updatePatient(@RequestBody PatientUpdateDTO patientUpdateDTO) {
        log.info("修改患者信息: {}", patientUpdateDTO);
        if(StringUtils.isEmpty(patientUpdateDTO.getClinicId())){
            patientUpdateDTO.setClinicId(BaseContext.getCurrentData().getClinicId());
        }
        if (StringUtils.isEmpty(patientUpdateDTO.getPatientId())) {
            throw new ParameterRequiredNullException(MessageConstant.PARAMETER_NULL_EXCEPTION);
        }
        boolean result = patientService.updatePatientInfo(patientUpdateDTO);
        if (result) {
            return Result.success(MessageConstant.DATA_UPDATE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_UPDATE_FAILED);
    }


    /**
     * 删除指定患者
     * @param patientId 患者id
     * @return {}
     */
    @PostMapping("/delete/{patientId}")
    public String deletePatient(@PathVariable String patientId){
        log.info("删除患者信息: {}", patientId);
        boolean result = patientService.deletePatient(patientId);
        if(result){
            return Result.success(MessageConstant.DATA_UPDATE_SUCCESS);
        }
        return Result.error(MessageConstant.DATA_UPDATE_FAILED);
    }

}
