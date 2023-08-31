package com.ybb.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ybb.constant.StatusConstant;
import com.ybb.context.BaseContext;
import com.ybb.context.SmartContextData;
import com.ybb.dto.pharmacy.UsageDTO;
import com.ybb.dto.pharmacy.UsageUpdateDTO;
import com.ybb.entity.TabUsageEntity;
import com.ybb.mapper.UsageMapper;
import com.ybb.service.IUsageService;
import com.ybb.vo.UsageVO;
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
public class UsageServiceImpl implements IUsageService {

    private UsageMapper usageMapper;

    @Autowired
    public void setUsageMapper(UsageMapper usageMapper) {
        this.usageMapper = usageMapper;
    }

    /**
     * 新增新的用法
     *
     * @param usageDTO usage
     * @return bool
     */
    @Override
    public boolean addNewUsage(UsageDTO usageDTO) {
        SmartContextData contextData = BaseContext.getCurrentData();
        String clinicId = contextData.getClinicId();
        String userId = contextData.getUserId();

        if (StringUtils.isEmpty(usageDTO.getClinicId())) {
            usageDTO.setClinicId(clinicId);
        }

        TabUsageEntity entity = new TabUsageEntity();
        BeanUtils.copyProperties(usageDTO, entity);
        entity.setCreateUser(userId);
        Date now = Calendar.getInstance().getTime();
        entity.setCreateTime(now);
        int rowResult = usageMapper.addNewUsage(entity);
        return rowResult > 0;
    }

    /**
     * 查询分类下的用法数据
     *
     * @param category 分类
     * @return list
     */
    @Override
    public List<UsageVO> queryUsageByCategory(Integer category) {
        List<UsageVO> usageVOS = new ArrayList<>();
        SmartContextData contextData = BaseContext.getCurrentData();
        String clinicId = contextData.getClinicId();
        List<TabUsageEntity> usageEntities = usageMapper.queryUsageByCategory(clinicId, category);
        if (usageEntities != null && usageEntities.size() > 0) {
            UsageVO usageVO;
            for (TabUsageEntity entity : usageEntities) {
                usageVO = new UsageVO();
                BeanUtils.copyProperties(entity, usageVO);
                usageVOS.add(usageVO);
            }
        }
        return usageVOS;
    }

    /**
     * 更新用法
     *
     * @param usageUpdateDTO 更新数据
     * @return bool
     */
    @Override
    public boolean updateUsageInfo(UsageUpdateDTO usageUpdateDTO) {
        SmartContextData contextData = BaseContext.getCurrentData();
        if (StringUtils.isEmpty(usageUpdateDTO.getClinicId())) {
            usageUpdateDTO.setClinicId(contextData.getClinicId());
        }
        usageUpdateDTO.setUpdateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        usageUpdateDTO.setUpdateTime(now);
        int rowResult = usageMapper.updateUsageInfo(usageUpdateDTO);
        return rowResult > 0;
    }

    /**
     * 删除用法
     *
     * @param usageId id
     * @return bool
     */
    @Override
    public boolean deleteUsageInfo(Integer usageId) {
        SmartContextData contextData = BaseContext.getCurrentData();
        UsageUpdateDTO usageUpdateDTO = new UsageUpdateDTO();
        usageUpdateDTO.setUsageId(usageId);
        usageUpdateDTO.setUsageStatus(StatusConstant.DISABLE);
        usageUpdateDTO.setClinicId(contextData.getClinicId());
        usageUpdateDTO.setUpdateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        usageUpdateDTO.setUpdateTime(now);
        int rowResult = usageMapper.updateUsageInfo(usageUpdateDTO);
        return rowResult > 0;
    }
}
