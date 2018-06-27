/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : taskone

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-30 23:15:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for taskone
-- ----------------------------
DROP TABLE IF EXISTS `taskone`;
CREATE TABLE `taskone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `profession` varchar(20) DEFAULT NULL,
  `join_date` bigint(20) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `online_id` varchar(10) DEFAULT NULL,
  `daily_url` varchar(255) DEFAULT NULL,
  `declaration` text,
  `counselor` varchar(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;
