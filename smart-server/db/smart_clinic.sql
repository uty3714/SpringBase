/*
 Navicat Premium Data Transfer

 Source Server         : 39
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : 39.100.253.129:3306
 Source Schema         : smart_clinic

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 07/10/2023 21:08:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tab_dosage_form
-- ----------------------------
DROP TABLE IF EXISTS `tab_dosage_form`;
CREATE TABLE `tab_dosage_form` (
  `dosage_form_id` int NOT NULL AUTO_INCREMENT COMMENT '剂型ID',
  `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
  `parent_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '父id',
  `dosage_form_name` varchar(50) NOT NULL COMMENT '剂型名称',
  `dosage_form_category` int NOT NULL COMMENT '剂型分类 1西药 2中药',
  `dosage_form_sort` int DEFAULT '0' COMMENT '剂型排序',
  `dosage_form_remark` varchar(100) DEFAULT NULL COMMENT '剂型备注',
  `dosage_form_status` int DEFAULT '1' COMMENT '剂型状态 1可用 0停用',
  `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
  `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dosage_form_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tab_dosage_form
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tab_drug_unit
-- ----------------------------
DROP TABLE IF EXISTS `tab_drug_unit`;
CREATE TABLE `tab_drug_unit` (
  `unit_id` int NOT NULL AUTO_INCREMENT COMMENT '单位ID',
  `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
  `unit_name` varchar(50) NOT NULL COMMENT '单位名称',
  `unit_category` int NOT NULL COMMENT '单位分类 1包装单位2基础单位3计量单位',
  `unit_sort` int DEFAULT '0' COMMENT '单位排序',
  `unit_remark` varchar(50) DEFAULT NULL COMMENT '单位备注',
  `unit_status` int DEFAULT '1' COMMENT '单位状态 1可用 0停用',
  `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
  `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tab_drug_unit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tab_patient_main
-- ----------------------------
DROP TABLE IF EXISTS `tab_patient_main`;
CREATE TABLE `tab_patient_main` (
  `patient_id` varchar(50) NOT NULL COMMENT '患者ID',
  `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
  `patient_name` varchar(50) NOT NULL COMMENT '患者姓名',
  `patient_sort_name` varchar(50) NOT NULL COMMENT '患者姓名简称',
  `patient_sex` int DEFAULT '1' COMMENT '患者性别 1男 0 女',
  `patient_age` varchar(50) DEFAULT '0' COMMENT '患者年龄',
  `patient_birthday` varchar(50) DEFAULT NULL COMMENT '患者出生日期',
  `patient_phone` varchar(50) DEFAULT NULL COMMENT '患者手机号',
  `patient_id_card` varchar(20) DEFAULT NULL COMMENT '患者身份证号',
  `patient_address` varchar(50) DEFAULT NULL COMMENT '患者家庭地址',
  `patient_ill_history` varchar(200) DEFAULT NULL COMMENT '患者病史',
  `patient_allergic_history` varchar(200) DEFAULT NULL COMMENT '患者过敏史',
  `patient_diagnose` varchar(200) DEFAULT NULL COMMENT '患者最新诊断',
  `patient_total_arrears` int DEFAULT '0' COMMENT '欠款',
  `patient_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `patient_status` int DEFAULT '1' COMMENT '患者状态 1可用0 停用',
  `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
  `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`patient_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tab_patient_main
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tab_usage
-- ----------------------------
DROP TABLE IF EXISTS `tab_usage`;
CREATE TABLE `tab_usage` (
  `usage_id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
  `usage_name` varchar(50) NOT NULL COMMENT '用法名称',
  `usage_category` int NOT NULL DEFAULT '0' COMMENT '用法分类 0通用1西药 2中药',
  `usage_sort` int DEFAULT '0' COMMENT '用法排序',
  `usage_remark` varchar(100) DEFAULT NULL COMMENT '用法备注',
  `usage_status` int DEFAULT '1' COMMENT '用法状态 1可用 0停用',
  `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
  `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`usage_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tab_usage
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tab_usage_frequency
-- ----------------------------
DROP TABLE IF EXISTS `tab_usage_frequency`;
CREATE TABLE `tab_usage_frequency` (
  `usage_frequency_id` int NOT NULL AUTO_INCREMENT COMMENT '频度ID',
  `clinic_id` varchar(50) NOT NULL COMMENT '诊所ID',
  `usage_frequency_name` varchar(50) NOT NULL COMMENT '频度名称',
  `usage_frequency_category` int NOT NULL DEFAULT '0' COMMENT '频度分类0通用1西药 2中药',
  `usage_frequency_sort` int DEFAULT '0' COMMENT '频度排序',
  `usage_frequency_remark` varchar(100) DEFAULT NULL COMMENT '频度备注',
  `usage_frequency_status` int DEFAULT '1' COMMENT '频度状态 1可用 0停用',
  `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
  `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`usage_frequency_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tab_usage_frequency
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user` (
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `clinic_id` varchar(40) NOT NULL COMMENT '所属诊所ID',
  `user_name` varchar(20) NOT NULL COMMENT '用户账号',
  `user_pwd` varchar(40) NOT NULL COMMENT '用户密码',
  `doctor_name` varchar(50) NOT NULL COMMENT '医生名称',
  `user_sex` int DEFAULT '1' COMMENT '用户性别 1男 0女',
  `user_id_card` varchar(20) DEFAULT NULL COMMENT '用户身份号',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '用户手机',
  `user_role` int NOT NULL DEFAULT '1' COMMENT '用户角色 0 管理员 1 普通员工',
  `user_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `user_status` varchar(11) NOT NULL DEFAULT '1' COMMENT '用户账号状态 1正常 0 禁用',
  `create_user` bigint DEFAULT NULL COMMENT '创建记录的用户',
  `update_user` bigint DEFAULT NULL COMMENT '修改记录的用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建用户时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新用户时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
BEGIN;
INSERT INTO `tab_user` (`user_id`, `clinic_id`, `user_name`, `user_pwd`, `doctor_name`, `user_sex`, `user_id_card`, `user_phone`, `user_role`, `user_remark`, `user_status`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('0', '9c8daec48234b4d30b2e79aa6927e629', 'admin', 'admin', 'admin', 1, NULL, NULL, 1, NULL, '1', 0, 0, '2023-10-07 20:59:24', '2023-10-07 20:59:30');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
