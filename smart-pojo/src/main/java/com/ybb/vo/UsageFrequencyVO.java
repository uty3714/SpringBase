package com.ybb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用法频次请求返回实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsageFrequencyVO {
    /**
     * 频次ID
     */
    private Integer usageFrequencyId;
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
}
