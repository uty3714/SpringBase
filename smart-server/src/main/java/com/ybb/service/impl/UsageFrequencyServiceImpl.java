package com.ybb.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ybb.context.BaseContext;
import com.ybb.context.SmartContextData;
import com.ybb.dto.pharmacy.UsageFrequencyDTO;
import com.ybb.entity.TabUsageFrequencyEntity;
import com.ybb.mapper.UsageFrequencyMapper;
import com.ybb.service.IUsageFrequencyService;
import com.ybb.vo.UsageFrequencyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
@Service
@Slf4j
public class UsageFrequencyServiceImpl implements IUsageFrequencyService {

    private UsageFrequencyMapper usageFrequencyMapper;

    @Autowired
    public void setUsageFrequencyMapper(UsageFrequencyMapper usageFrequencyMapper) {
        this.usageFrequencyMapper = usageFrequencyMapper;
    }

    /**
     * 新增一个用法频次数据
     *
     * @param usageFrequencyDTO 用法频次数据
     * @return bool
     */
    @Override
    public boolean addNewUsageFrequency(UsageFrequencyDTO usageFrequencyDTO) {
        SmartContextData contextData = BaseContext.getCurrentData();
        if (StringUtils.isEmpty(usageFrequencyDTO.getClinicId())) {
            usageFrequencyDTO.setClinicId(contextData.getClinicId());
        }
        TabUsageFrequencyEntity entity = new TabUsageFrequencyEntity();
        BeanUtils.copyProperties(usageFrequencyDTO, entity);
        entity.setCreateUser(contextData.getUserId());
        Date now = Calendar.getInstance().getTime();
        entity.setCreateTime(now);
        int rowResult = usageFrequencyMapper.addNewUsageFrequency(entity);
        return rowResult > 0;
    }

    /**
     * 查询用法频次
     * @param category 分类
     * @return list
     */
    @Override
    public List<UsageFrequencyVO> queryUsageFrequencyInfo(Integer category) {
        SmartContextData contextData = BaseContext.getCurrentData();
        String clinicId = contextData.getClinicId();


        return null;
    }
}
