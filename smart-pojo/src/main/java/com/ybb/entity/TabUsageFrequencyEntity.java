package com.ybb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用法频次实体表
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TabUsageFrequencyEntity {

    /*
        `usage_frequency_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '频度ID',
        `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
        `usage_frequency_name` varchar(50) NOT NULL COMMENT '频度名称',
        `usage_frequency_category` int(11) NOT NULL DEFAULT '0' COMMENT '频度分类0通用1西药 2中药',
        `usage_frequency_sort` int(11) DEFAULT '0' COMMENT '频度排序',
        `usage_frequency_remark` varchar(100) DEFAULT NULL COMMENT '频度备注',
	    `usage_frequency_status` int(11) DEFAULT '1' COMMENT '频度状态 1可用 0停用',
        `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
        `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
        `update_time` datetime DEFAULT NULL COMMENT '更新时间',
     */


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
    /**
     * 频次状态 1可用 0停用
     */
    private Integer usageFrequencyStatus;
    /**
     * 创建记录用户
     */
    private String createUser;
    /**
     * 最后更新记录用户
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
