package com.ybb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用法表实体
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TabUsageEntity {

    /*
    `usage_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
    `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
    `usage_name` varchar(50) NOT NULL COMMENT '用法名称',
    `usage_category` int(11) NOT NULL DEFAULT '0' COMMENT '用法分类 0通用1西药 2中药',
    `usage_sort` int(11) DEFAULT '0' COMMENT '用法排序',
    `usage_remark` varchar(100) DEFAULT NULL COMMENT '用法备注',
	`usage_status` int(11) DEFAULT '1' COMMENT '用法状态 1可用 0停用',
    `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
    `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
     */

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
    /**
     * 用法状态 1可用 0停用
     */
    private Integer usageStatus;
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
