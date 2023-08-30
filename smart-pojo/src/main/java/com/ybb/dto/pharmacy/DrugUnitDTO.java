package com.ybb.dto.pharmacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 药房-药品单位请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DrugUnitDTO {
    /**
     * 诊所ID
     */
    private String clinicId;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 单位分类 1包装单位2基础单位3计量单位
     */
    private Integer unitCategory;
    /**
     * 单位排序
     */
    private Integer unitSort;
    /**
     * 单位备注
     */
    private String unitRemark;

}
