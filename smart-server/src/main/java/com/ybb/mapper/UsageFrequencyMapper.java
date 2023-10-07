package com.ybb.mapper;

import com.ybb.entity.TabUsageFrequencyEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsageFrequencyMapper {

    /**
     * 新增一个用法频次
     * @param tabUsageFrequencyEntity entity
     * @return int
     */
    int addNewUsageFrequency(TabUsageFrequencyEntity tabUsageFrequencyEntity);

}
