package com.ybb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用法请求返回实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsageVO {
    /**
     * 用法id
     */
    private Integer usageId;
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

}
