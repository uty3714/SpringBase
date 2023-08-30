package com.ybb.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ybb.constant.StatusConstant;
import com.ybb.context.BaseContext;
import com.ybb.context.SmartContextData;
import com.ybb.dto.pharmacy.DrugUnitDTO;
import com.ybb.dto.pharmacy.DrugUnitUpdateDTO;
import com.ybb.entity.TabDrugUnitEntity;
import com.ybb.mapper.DrugUnitMapper;
import com.ybb.service.IDrugUnitService;
import com.ybb.utils.UUIDUtil;
import com.ybb.vo.DrugUnitVO;
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
@Slf4j
@Service
public class DrugUnitServiceImpl implements IDrugUnitService {

    private DrugUnitMapper drugUnitMapper;

    @Autowired
    public void setDrugUnitMapper(DrugUnitMapper drugUnitMapper) {
        this.drugUnitMapper = drugUnitMapper;
    }

    /**
     * 新增药品单位
     *
     * @param drugUnitDTO 单位信息
     * @return int
     */
    @Override
    public boolean addNewDrugUnit(DrugUnitDTO drugUnitDTO) {
        //构造数据
        TabDrugUnitEntity drugUnitEntity = new TabDrugUnitEntity();
        BeanUtils.copyProperties(drugUnitDTO, drugUnitEntity);
        String unitId = UUIDUtil.get().getUUID();
        drugUnitEntity.setUnitId(unitId);
        drugUnitEntity.setUnitStatus(StatusConstant.ENABLE);
        SmartContextData contextData = BaseContext.getCurrentData();
        drugUnitEntity.setCreateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        drugUnitEntity.setCreateTime(now);
        int rowResult = drugUnitMapper.addNewDrugUnit(drugUnitEntity);
        return rowResult > 0;
    }

    /**
     * 根据单位分类查询所有的药品单位
     * @param category 单位分类
     */
    @Override
    public List<DrugUnitVO> queryUnitByCategory(Integer category) {
        List<DrugUnitVO> drugUnitVOS = new ArrayList<>();
        String clinicId = BaseContext.getCurrentData().getClinicId();
        List<TabDrugUnitEntity> tabDrugUnitEntities = drugUnitMapper.queryUnitByCategory(clinicId, category);
        if(tabDrugUnitEntities != null && tabDrugUnitEntities.size() > 0){
            DrugUnitVO drugUnitVO;
            for (TabDrugUnitEntity entity : tabDrugUnitEntities) {
                drugUnitVO = new DrugUnitVO();
                BeanUtils.copyProperties(entity,drugUnitVO);
                drugUnitVOS.add(drugUnitVO);
            }
        }
        log.info("测试长度: {}", drugUnitVOS.size());
        return drugUnitVOS;
    }

    /**
     * 修改药品实体
     * @param drugUnitUpdateDTO 修改的单位信息
     * @return bool
     */
    @Override
    public boolean updateDrugUnitInfo(DrugUnitUpdateDTO drugUnitUpdateDTO) {
        SmartContextData contextData = BaseContext.getCurrentData();
        if(StringUtils.isEmpty(drugUnitUpdateDTO.getClinicId())){
            drugUnitUpdateDTO.setClinicId(contextData.getClinicId());
        }
        drugUnitUpdateDTO.setUpdateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        drugUnitUpdateDTO.setUpdateTime(now);
        //更新数据
        int rowResult = drugUnitMapper.updateDrugUnitInfo(drugUnitUpdateDTO);
        return rowResult > 0;
    }

    /**
     * 根据单位id删除单位信息
     * @param unitId 单位id
     * @return bool
     */
    @Override
    public boolean deleteDrugUnitInfo(String unitId) {
        SmartContextData contextData = BaseContext.getCurrentData();
        String clinicId = contextData.getClinicId();
        DrugUnitUpdateDTO drugUnitUpdateDTO = new DrugUnitUpdateDTO();
        drugUnitUpdateDTO.setClinicId(clinicId);
        drugUnitUpdateDTO.setUnitId(unitId);
        drugUnitUpdateDTO.setUnitStatus(StatusConstant.DISABLE);
        drugUnitUpdateDTO.setUpdateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        drugUnitUpdateDTO.setUpdateTime(now);
        int rowResult = drugUnitMapper.updateDrugUnitInfo(drugUnitUpdateDTO);
        return rowResult > 0;
    }
}
