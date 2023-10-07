package com.ybb.dto.pharmacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 频次请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsageFrequencyDTO {

    /**
     * 诊所ID
     */
    private String clinicId;
    /**
     * 频次名称
     */
    private String usageFrequencyName;
    /**
     * 频次分类0通用1西药 2中药
     */
    private Integer usageFrequencyCategory;
    /**
     * 频次排序
     */
    private Integer usageFrequencySort;
    /**
     * 频次备注
     */
    private String usageFrequencyRemark;
    /**
     * 频次状态 1可用 0停用
     */
    private Integer usageFrequencyStatus;

}
