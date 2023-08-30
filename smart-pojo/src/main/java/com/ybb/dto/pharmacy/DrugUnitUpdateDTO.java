package com.ybb.dto.pharmacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 药品单位修改请求实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DrugUnitUpdateDTO {
    /**
     * 单位ID
     */
    private Integer unitId;
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
    /**
     * 单位状态 1可用 0停用
     */
    private Integer unitStatus;
    /**
     * 修改记录的用户
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;
}
