package com.ybb.service;

import com.ybb.dto.pharmacy.UsageFrequencyDTO;
import com.ybb.vo.UsageFrequencyVO;

import java.util.List;

public interface IUsageFrequencyService {
    /**
     * 新增一个用法频次数据
     *
     * @param usageFrequencyDTO 用法频次数据
     * @return bool
     */
    boolean addNewUsageFrequency(UsageFrequencyDTO usageFrequencyDTO);

    /**
     * 查询用法频次
     * @param category 分类
     * @return list
     */
    List<UsageFrequencyVO> queryUsageFrequencyInfo(Integer category);


}
