package com.ybb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybb.constant.StatusConstant;
import com.ybb.context.BaseContext;
import com.ybb.dto.patient.PatientDTO;
import com.ybb.dto.patient.PatientQueryDTO;
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
        String currentUser = BaseContext.getCurrentUserId();
        entity.setCreateUser(currentUser);
        entity.setUpdateUser(currentUser);
        Date now = Calendar.getInstance().getTime();
        entity.setCreateTime(now);
        entity.setCreateTime(now);
        //保存数据库
        patientMapper.addNewPatient(entity);
        log.debug("新增的患者id: {}", patientId);
        return true;
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
}
