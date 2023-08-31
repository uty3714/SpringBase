package com.ybb.mapper;

import com.ybb.dto.pharmacy.UsageUpdateDTO;
import com.ybb.entity.TabUsageEntity;
import com.ybb.vo.UsageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsageMapper {

    /**
     * 新增一个用法
     *
     * @param tabUsageEntity 用法
     * @return int
     */
    int addNewUsage(TabUsageEntity tabUsageEntity);

    /**
     * 查询分类下的用法数据
     *
     * @param clinicId 诊所ID
     * @param category 分类
     * @return list
     */
    @Select("select " +
            "usage_id, clinic_id, usage_name, usage_category, usage_sort, usage_remark, usage_status " +
            "from tab_usage " +
            "where clinic_id = #{clinicId} and usage_category = #{category} and usage_status = 1")
    List<TabUsageEntity> queryUsageByCategory(@Param("clinicId") String clinicId, @Param("category") Integer category);


    /**
     * 更新用法
     * @param usageUpdateDTO 更新的用户数据
     * @return int
     */
    int updateUsageInfo(UsageUpdateDTO usageUpdateDTO);

}
