-- ----------------------------
-- Table structure for `t_map_location`
-- ----------------------------
DROP TABLE IF EXISTS `t_map_location`;
CREATE TABLE `t_map_location` (
  `id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,

  `userId` varchar(64) NOT NULL,

  `goodsId` varchar(64) DEFAULT NULL,
  `latitudeFrom` varchar(64) DEFAULT NULL,
  `longitudeFrom` varchar(64) DEFAULT NULL,
  `latitudeTo` varchar(64) DEFAULT NULL,
  `longitudeTo` varchar(64) DEFAULT NULL,

  `iconPath` varchar(64) DEFAULT NULL,
  `width` varchar(64) DEFAULT NULL,
  `height` varchar(64) DEFAULT NULL,

  `str1` varchar(64) DEFAULT NULL COMMENT '预留字段1',
  `str2` varchar(64) DEFAULT NULL COMMENT '预留字段2',
  `str3` varchar(128) DEFAULT NULL COMMENT '预留字段3',
  `createtime` timestamp NULL DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
