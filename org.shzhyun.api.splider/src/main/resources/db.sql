/*
Navicat MySQL Data Transfer

Source Server         : 39.104.181.79
Source Server Version : 50633
Source Host           : 39.104.181.79:3306
Source Database       : shzhyun

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-08-11 00:46:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_news
-- type 0-sina; 1-baidu; 2-toutiao;
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int primary key auto_increment,
  `title` text NOT NULL,
  `context` text DEFAULT NULL,
  `type` int DEFAULT 0,
  `url` varchar(800) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES (1, ' 梦灯笼', 'video/d092e3a8-aab4-4fb3-8397-545707776da9.mp4', 0, '13061282769');
INSERT INTO `t_news` VALUES (2, '梦灯笼', 'video/d092e3a8-aab4-4fb3-8397-545707776da9.mp4', 0,'13061282769');
