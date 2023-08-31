package com.ybb.service;

import com.ybb.dto.pharmacy.UsageDTO;
import com.ybb.dto.pharmacy.UsageUpdateDTO;
import com.ybb.vo.UsageVO;

import java.util.List;

public interface IUsageService {

    /**
     * 新增新的用法
     *
     * @param usageDTO usage
     * @return bool
     */
    boolean addNewUsage(UsageDTO usageDTO);

    /**
     * 查询分类下的用法数据
     *
     * @param category 分类
     * @return list
     */
    List<UsageVO> queryUsageByCategory(Integer category);

    /**
     * 更新用法
     *
     * @param usageUpdateDTO 更新数据
     * @return bool
     */
    boolean updateUsageInfo(UsageUpdateDTO usageUpdateDTO);

    /**
     * 删除用法
     *
     * @param usageId id
     * @return bool
     */
    boolean deleteUsageInfo(Integer usageId);
}
