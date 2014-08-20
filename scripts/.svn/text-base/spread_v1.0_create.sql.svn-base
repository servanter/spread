SET FOREIGN_KEY_CHECKS=0;


DROP DATABASE `spread`;

-- ----------------------------
-- Database structure for `spread`
-- ----------------------------
CREATE DATABASE `spread` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE spread;



-- ----------------------------
-- Table structure for `spread_info_class`
-- ----------------------------
CREATE TABLE `spread_info_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `content` varchar(200) NOT NULL,
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `spread_area`
-- ----------------------------
DROP TABLE IF EXISTS `spread_area`;
CREATE TABLE `spread_area` (
  `id` bigint(20) unsigned NOT NULL,
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `area_name` varchar(20) NOT NULL,
  `area_ename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `spread_wechat`
-- ----------------------------
DROP TABLE IF EXISTS `spread_wechat`;
CREATE TABLE `spread_wechat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT 0,
  `province` bigint(20) NOT NULL,
  `city` bigint(20) NOT NULL,
  `info_class_id` bigint(20) NOT NULL,
  `alias_num` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `keywords` varchar(50) NOT NULL,
  `row_icon` varchar(100) NOT NULL,
  `qr_code` varchar(100) NOT NULL,
  `url` varchar(100) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `spread_user`
-- ----------------------------
DROP TABLE IF EXISTS `spread_user`;
CREATE TABLE `spread_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `pic_url` varchar(100) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `phone` varchar(50) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






-- ----------------------------
-- Table structure for `spread_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `spread_recommend`;
CREATE TABLE `spread_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alias_code` int(5) NOT NULL DEFAULT '0',
  `recommend_name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `max_position` int(5) NOT NULL DEFAULT '0',
  `current_surplus_position` int(5) NOT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






-- ----------------------------
-- Table structure for `spread_rel_wechat_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `spread_rel_wechat_recommend`;
CREATE TABLE `spread_rel_wechat_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wechat_id` bigint(20) NOT NULL,
  `recommend_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_valid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `spread_action`
-- ----------------------------
DROP TABLE IF EXISTS `spread_action`;
CREATE TABLE `spread_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wechat_id` bigint(20) NOT NULL,
  `s_share` int(11) NOT NULL DEFAULT '0',
  `s_enjoy` int(11) NOT NULL DEFAULT '0',
  `s_read` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `spread_wechat_resource`
-- ----------------------------
DROP TABLE IF EXISTS `spread_wechat_resource`;
CREATE TABLE `spread_wechat_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wechat_id` bigint(20) NOT NULL,
  `url` varchar(200) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_valid` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- ----------------------------
-- Table structure for `spread_comment`
-- ----------------------------
DROP TABLE IF EXISTS `spread_comment`;
CREATE TABLE `spread_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wechat_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `content` varchar(140) NOT NULL,
  `pic_url` varchar(200) NOT NULL,
  `comment_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `is_valid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- ----------------------------
-- Table structure for `spread_account`
-- ----------------------------
DROP TABLE IF EXISTS `spread_account`;
CREATE TABLE `spread_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `total_money` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- ----------------------------
-- Table structure for `spread_consume_detail`
-- ----------------------------
DROP TABLE IF EXISTS `spread_consume_detail`;
CREATE TABLE `spread_consume_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `consume_order_id` varchar(50) NOT NULL DEFAULT '',
  `user_id` bigint(20) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `recommend_id` bigint(20) NOT NULL,
  `price` int(10) NOT NULL,
  `cur_total_money` bigint(20) NOT NULL DEFAULT 0,
  `start_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `spread_recharge_detail`
-- ----------------------------
DROP TABLE IF EXISTS `spread_recharge_detail`;
CREATE TABLE `spread_recharge_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `recharge_type` int(5) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `money` bigint(20) NOT NULL,
  `recharge_order_id` bigint(50) NOT NULL,
  `return_code` int(5) NOT NULL,
  `recharge_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `recharge_comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

