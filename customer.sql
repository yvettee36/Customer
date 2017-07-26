/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : customer

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-07-26 22:46:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `gender` varchar(4) NOT NULL,
  `birthday` date DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `preference` varchar(255) DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('7f73f53c-5a76-4edc-b724-a3734c22c9c8', '王嵯峨', '女', '1996-07-03', '17834564312', 'zxc@qq.com', '蹦极,探险', '普通客户', '智障儿童');
