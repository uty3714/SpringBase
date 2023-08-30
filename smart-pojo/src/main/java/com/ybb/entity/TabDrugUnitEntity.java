package com.ybb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TabDrugUnitEntity {

    /*
    `unit_id` varchar(50) NOT NULL COMMENT '单位ID',
    `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
    `unit_name` varchar(50) NOT NULL COMMENT '单位名称',
    `unit_category` int(11) NOT NULL COMMENT '单位分类 1包装单位2基础单位3计量单位',
    `unit_sort` int(11) DEFAULT '0' COMMENT '单位排序',
    `unit_remark` varchar(50) DEFAULT NULL COMMENT '单位备注',
    `unit_status` int(11) DEFAULT '1' COMMENT '单位状态 1可用 0停用',
    `create_user` BIGINT DEFAULT NULL COMMENT '创建记录的用户',
	`update_user` BIGINT DEFAULT NULL COMMENT '修改记录的用户',
	`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
     */

    /**
     * 单位ID
     */
    private String unitId;
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
     * 创建记录的用户
     */
    private String createUser;
    /**
     * 修改记录的用户
     */
    private String updateUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}
