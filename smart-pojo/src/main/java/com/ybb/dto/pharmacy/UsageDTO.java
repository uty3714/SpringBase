package com.ybb.dto.pharmacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用法请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsageDTO {

    /**
     * 诊所ID
     */
    private String clinicId;
    /**
     * 用法名称
     */
    private String usageName;
    /**
     * 用法分类 0通用1西药 2中药
     */
    private Integer usageCategory;
    /**
     * 用法排序
     */
    private Integer usageSort;
    /**
     * 用法备注
     */
    private String usageRemark;
    /**
     * 用法状态 1可用 0停用
     */
    private Integer usageStatus;
}
