/*
 Navicat Premium Data Transfer

 Source Server         : cat
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : article_management_system

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 15/04/2019 21:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for recyclebin
-- ----------------------------
DROP TABLE IF EXISTS `recyclebin`;
CREATE TABLE `recyclebin`  (
  `t_txt_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `t_user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `t_number` int(10) NOT NULL,
  `t_create_time` date NOT NULL,
  `t_update_time` date NULL DEFAULT NULL,
  `t_delete_time` date NOT NULL,
  `t_txt_create_time` date NOT NULL,
  `t_is_delete` tinyint(1) NOT NULL,
  `padding1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `padding2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `padding3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
