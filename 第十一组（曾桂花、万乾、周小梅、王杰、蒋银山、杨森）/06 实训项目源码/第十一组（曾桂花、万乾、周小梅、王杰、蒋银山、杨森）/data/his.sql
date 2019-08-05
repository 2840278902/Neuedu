/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : his

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-07-25 17:39:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for case_info
-- ----------------------------
DROP TABLE IF EXISTS `case_info`;
CREATE TABLE `case_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `c_no` varchar(20) NOT NULL COMMENT '病历号',
  `c_info` varchar(500) NOT NULL COMMENT '诊断信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_info
-- ----------------------------
INSERT INTO `case_info` VALUES ('1', '0000000001', '感冒');
INSERT INTO `case_info` VALUES ('2', '0000000005', '绝症');
INSERT INTO `case_info` VALUES ('3', '0000000006', '头疼');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dep_id` int(11) NOT NULL COMMENT '科室编号',
  `dep_name` varchar(50) NOT NULL COMMENT '科室名称',
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '外科');
INSERT INTO `department` VALUES ('2', '内科');
INSERT INTO `department` VALUES ('3', '耳鼻喉科');
INSERT INTO `department` VALUES ('4', '妇科');
INSERT INTO `department` VALUES ('5', '儿科');
INSERT INTO `department` VALUES ('6', '脑科');

-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `zhanghao` varchar(20) NOT NULL COMMENT '登录账号',
  `inputpwd` varchar(32) NOT NULL COMMENT '登录密码',
  `username` varchar(20) NOT NULL COMMENT '真实姓名',
  `dep` int(11) NOT NULL COMMENT '所属科室',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
INSERT INTO `doctor_info` VALUES ('1', 'zhangsan', 'Zgh123', '张三', '1');
INSERT INTO `doctor_info` VALUES ('2', 'lisi', 'Zgh123', '李四', '1');
INSERT INTO `doctor_info` VALUES ('3', 'wangwu', 'Zgh123', '王五', '2');
INSERT INTO `doctor_info` VALUES ('4', 'zhaoliu', 'Zgh123', '赵六', '2');
INSERT INTO `doctor_info` VALUES ('5', 'xiaohei', 'Zgh123', '小惠', '2');
INSERT INTO `doctor_info` VALUES ('6', 'qdd', 'Zgh123', '钱多多', '3');
INSERT INTO `doctor_info` VALUES ('7', 'aaa', 'Zgh123', '孙晓修', '3');
INSERT INTO `doctor_info` VALUES ('8', 'bbb', 'Zgh123', '李一一', '4');
INSERT INTO `doctor_info` VALUES ('9', 'ccc', 'Zgh123', '德莫', '5');
INSERT INTO `doctor_info` VALUES ('10', 'ddd', 'Zgh123', '王往', '6');

-- ----------------------------
-- Table structure for drug_info
-- ----------------------------
DROP TABLE IF EXISTS `drug_info`;
CREATE TABLE `drug_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dg_name` varchar(30) NOT NULL COMMENT '药品名称',
  `dg_spec` varchar(10) NOT NULL COMMENT '药品规格',
  `dg_price` double(7,2) NOT NULL COMMENT '药品价格',
  `dg_inv` int(11) NOT NULL COMMENT '药品库存',
  `dg_uit` varchar(4) NOT NULL COMMENT '药品单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drug_info
-- ----------------------------
INSERT INTO `drug_info` VALUES ('1', '感康', '0.5mg', '30.00', '1010', '盒');
INSERT INTO `drug_info` VALUES ('2', '红霉素', '0.5mg', '30.00', '1111', '盒');
INSERT INTO `drug_info` VALUES ('3', '青霉素', '0.5mg', '30.00', '2222', '盒');
INSERT INTO `drug_info` VALUES ('4', '奥美拉唑', '0.5mg', '30.00', '3333', '盒');
INSERT INTO `drug_info` VALUES ('5', '马应龙', '0.5mg', '30.00', '4444', '盒');

-- ----------------------------
-- Table structure for pay_info
-- ----------------------------
DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dg_id` int(11) NOT NULL COMMENT '药品编号',
  `case_no` varchar(30) NOT NULL COMMENT '病历号',
  `pay_num` int(11) NOT NULL COMMENT '药品数量',
  `pay_money` double(7,2) NOT NULL COMMENT '收费总金额',
  `pay_date` date DEFAULT NULL COMMENT '收费时间',
  `pay_state` int(2) NOT NULL DEFAULT '0' COMMENT '收费状态:{0:未收费,1:已收费}',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay_info
-- ----------------------------
INSERT INTO `pay_info` VALUES ('1', '1', '0000000006', '3', '90.00', '2019-07-25', '1', null);
INSERT INTO `pay_info` VALUES ('2', '2', '0000000006', '4', '120.00', '2019-07-25', '1', null);

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `case_no` varchar(20) NOT NULL COMMENT '病历号',
  `rname` varchar(20) NOT NULL COMMENT '姓名',
  `sex` int(4) NOT NULL COMMENT '性别',
  `age` int(4) NOT NULL COMMENT '年龄',
  `birthday` date NOT NULL COMMENT '出生日期',
  `settle_type` int(4) NOT NULL COMMENT '结算类别',
  `mcard_no` varchar(10) NOT NULL COMMENT '医疗证号',
  `medical_type` int(4) NOT NULL COMMENT '医疗类型',
  `id_card` varchar(20) NOT NULL COMMENT '身份证号',
  `address` varchar(50) NOT NULL COMMENT '家庭地址',
  `vist_date` date NOT NULL COMMENT '看诊日期',
  `reg_level` int(4) NOT NULL COMMENT '挂号级别',
  `dept_no` int(11) NOT NULL COMMENT '挂号科室',
  `dr_id` int(11) NOT NULL COMMENT '看诊医生',
  `reg_pay` int(11) NOT NULL COMMENT '应收金额',
  `reg_src` int(4) NOT NULL COMMENT '挂号来源',
  `diag_state` int(4) NOT NULL COMMENT '是否已诊',
  `reg_state` int(4) NOT NULL COMMENT '挂号状态',
  `inv_no` varchar(20) NOT NULL COMMENT '发票号码',
  `reg_date` date NOT NULL COMMENT '挂号日期',
  `age_type` varchar(4) NOT NULL COMMENT '年龄类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('1', '0000000001', '王一', '0', '1', '2018-07-25', '0', '12345', '0', '500123201807257856', '北京', '2019-07-25', '0', '1', '1', '2', '0', '1', '0', '0000000001', '2019-07-25', '岁');
INSERT INTO `register` VALUES ('2', '0000000002', '王二', '1', '1', '2019-07-24', '1', '23456', '1', '512233201907243212', '重庆', '2019-07-25', '1', '5', '9', '10', '1', '0', '0', '0000000002', '2019-07-25', '2');
INSERT INTO `register` VALUES ('3', '0000000003', '王三', '1', '10', '2009-07-12', '0', '34567', '1', '532412200907122312', '上海', '2019-07-25', '1', '3', '6', '10', '1', '0', '0', '0000000003', '2019-07-25', '0');
INSERT INTO `register` VALUES ('4', '0000000004', '王四', '0', '17', '2002-02-08', '0', '34567', '1', '532412200202082312', '深圳', '2019-07-25', '0', '6', '10', '2', '0', '0', '0', '0000000004', '2019-07-25', '0');
INSERT INTO `register` VALUES ('5', '0000000005', '王五', '0', '24', '1995-06-14', '0', '34567', '1', '532412199506142312', '广东', '2019-07-25', '1', '1', '1', '10', '0', '1', '1', '0000000005', '2019-07-25', '0');
INSERT INTO `register` VALUES ('6', '0000000006', '王六', '0', '27', '1992-05-15', '1', '34567', '1', '532412199205152312', '重庆', '2019-07-25', '1', '1', '1', '10', '1', '1', '0', '0000000006', '2019-07-25', '0');
INSERT INTO `register` VALUES ('7', '0000000007', '王七', '1', '22', '1996-11-15', '0', '34567', '0', '532412199611152312', '重庆', '2019-07-25', '1', '1', '1', '10', '1', '0', '0', '0000000007', '2019-07-25', '0');
INSERT INTO `register` VALUES ('8', '0000000008', '思思', '1', '22', '1997-07-18', '0', '34567', '0', '532412199707182312', '重庆', '2019-07-25', '0', '1', '1', '2', '0', '0', '0', '0000000008', '2019-07-25', '0');
INSERT INTO `register` VALUES ('9', '0000000009', '多多', '1', '20', '1999-06-09', '0', '34567', '0', '532412199906092312', '重庆', '2019-07-25', '0', '1', '1', '2', '0', '0', '0', '0000000009', '2019-07-25', '0');
