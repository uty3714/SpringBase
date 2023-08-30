package com.ybb.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybb.constant.StatusConstant;
import com.ybb.context.BaseContext;
import com.ybb.context.SmartContextData;
import com.ybb.dto.patient.PatientDTO;
import com.ybb.dto.patient.PatientQueryDTO;
import com.ybb.dto.patient.PatientUpdateDTO;
import com.ybb.entity.TabPatientEntity;
import com.ybb.mapper.PatientMapper;
import com.ybb.result.PageResult;
import com.ybb.service.IPatientService;
import com.ybb.utils.PinyinUtil;
import com.ybb.utils.UUIDUtil;
import com.ybb.vo.PatientVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
@Service
@Slf4j
public class PatientServiceImpl implements IPatientService {

    private PatientMapper patientMapper;

    @Autowired
    public void setPatientMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    /**
     * 新增患者
     *
     * @param patientDTO 患者信息
     * @return 新增结果
     */
    @Override
    public boolean addNewPatient(PatientDTO patientDTO) {
        //构建患者对象
        TabPatientEntity entity = new TabPatientEntity();
        BeanUtils.copyProperties(patientDTO, entity);
        //补充数据
        //id
        String patientId = UUIDUtil.get().getUUID();
        entity.setPatientId(patientId);
        //shotName
        String sortName = PinyinUtil.converterToFirstSpell(patientDTO.getPatientName());
        entity.setPatientSortName(sortName);
        //欠款默认0
        entity.setPatientTotalArrears(0);
        //状态
        entity.setPatientStatus(StatusConstant.ENABLE);
        SmartContextData currentData = BaseContext.getCurrentData();
        entity.setCreateUser(currentData.getUserId());
        Date now = Calendar.getInstance().getTime();
        entity.setCreateTime(now);
        //保存数据库
        int rowResult = patientMapper.addNewPatient(entity);
        return rowResult > 0;
    }


    /**
     * 根据条件查询患者信息
     *
     * @param patientQueryDTO 查询的信息
     * @return Page分页信息
     */
    @Override
    public PageResult<PatientVO> queryPatientInfo(PatientQueryDTO patientQueryDTO) {
        PageResult<PatientVO> patientVOPageResult = new PageResult<>();
        List<PatientVO> patientVOList = new ArrayList<>();
        //开始分页
        PageHelper.startPage(patientQueryDTO.getPageIndex(), patientQueryDTO.getPageSize());
        //查询分页
        Page<TabPatientEntity> tabPatientEntities = patientMapper.queryPatientInfo(patientQueryDTO);

        if (tabPatientEntities != null &&
                tabPatientEntities.getResult() != null &&
                tabPatientEntities.getResult().size() > 0) {
            PatientVO patientVO;
            patientVOPageResult.setTotal(tabPatientEntities.getTotal());
            for (TabPatientEntity entity : tabPatientEntities.getResult()) {
                patientVO = new PatientVO();
                BeanUtils.copyProperties(entity, patientVO);
                patientVOList.add(patientVO);
            }
            patientVOPageResult.setRecords(patientVOList);
        }
        return patientVOPageResult;
    }

    /**
     * 修改患者信息
     *
     * @param patientUpdateDTO 要修改的信息
     * @return 修改结果
     */
    @Override
    public boolean updatePatientInfo(PatientUpdateDTO patientUpdateDTO) {
        //重新设置一下简称
        if (StringUtils.isEmpty(patientUpdateDTO.getPatientSortName())) {
            String sortName = PinyinUtil.converterToFirstSpell(patientUpdateDTO.getPatientName());
            patientUpdateDTO.setPatientSortName(sortName);
        }
        //更新用户id
        SmartContextData contextData = BaseContext.getCurrentData();
        patientUpdateDTO.setUpdateUser(contextData.getUserId());
        //更新时间
        Date updateDate = Calendar.getInstance().getTime();
        patientUpdateDTO.setUpdateTime(updateDate);
        int rowResult = patientMapper.updatePatientInfo(patientUpdateDTO);
        return rowResult > 0;
    }

    /**
     * 删除患者信息
     *
     * @param patientId 患者id
     * @return 删除结果
     */
    @Override
    public boolean deletePatient(String patientId) {
        SmartContextData contextData = BaseContext.getCurrentData();
        String clinicId = contextData.getClinicId();
        PatientUpdateDTO patientUpdateDTO = new PatientUpdateDTO();
        patientUpdateDTO.setPatientId(patientId);
        patientUpdateDTO.setClinicId(clinicId);
        patientUpdateDTO.setPatientStatus(StatusConstant.DISABLE);
        patientUpdateDTO.setUpdateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        patientUpdateDTO.setUpdateTime(now);
        int rowResult = patientMapper.updatePatientInfo(patientUpdateDTO);
        return rowResult > 0;
    }
}
