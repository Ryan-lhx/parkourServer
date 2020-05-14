/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : parkour

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 09/02/2020 14:45:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gamerule
-- ----------------------------
DROP TABLE IF EXISTS `gamerule`;
CREATE TABLE `gamerule`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `Rule_Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Rule_Description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ruleDelete` int(255) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gamerule
-- ----------------------------
INSERT INTO `gamerule` VALUES (2, 'hao', 'xie', 1);
INSERT INTO `gamerule` VALUES (3, '规则3', '我不知道', 1);
INSERT INTO `gamerule` VALUES (4, '想法4', '我不知道我还是不知道', 2);
INSERT INTO `gamerule` VALUES (5, '想法5', '我不知道我还是不知道', 1);

-- ----------------------------
-- Table structure for gameuser
-- ----------------------------
DROP TABLE IF EXISTS `gameuser`;
CREATE TABLE `gameuser`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_integral` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_VIP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_Distance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_Task` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_Delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `User_Backpack` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Sign_frequency` int(8) NULL DEFAULT NULL,
  `Stroke_id` int(8) NULL DEFAULT NULL,
  `term_type` int(8) NULL DEFAULT NULL,
  `term_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Sign_User_id`(`Sign_frequency`) USING BTREE,
  CONSTRAINT `Sign_User_id` FOREIGN KEY (`Sign_frequency`) REFERENCES `签到表` (`Sign_frequency`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `r_id`(`role_id`) USING BTREE,
  INDEX `m_id`(`menu_id`) USING BTREE,
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 1, 1);
INSERT INTO `menu_role` VALUES (2, 1, 2);
INSERT INTO `menu_role` VALUES (3, 1, 3);
INSERT INTO `menu_role` VALUES (4, 2, 2);
INSERT INTO `menu_role` VALUES (5, 2, 3);
INSERT INTO `menu_role` VALUES (6, 3, 3);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  `delete1` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '增加', 'user:1', 1, 1);
INSERT INTO `t_menu` VALUES (2, '删除', 'user:2', 2, 1);
INSERT INTO `t_menu` VALUES (3, '更新', 'user:3', 3, 1);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` int(255) NULL DEFAULT NULL,
  `delete1` int(255) NULL DEFAULT 1,
  `depiction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '奥特曼', 1, 1, '123`');
INSERT INTO `t_role` VALUES (2, '普通管理员', 2, 1, 'qqe');
INSERT INTO `t_role` VALUES (3, '用户', 2, 2, '44');
INSERT INTO `t_role` VALUES (5, '奥特曼', 3, 1, '宇宙的战士');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `delete1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'roo', 'ea48576f30be1669971699c09ad05c94', '123456', 1, '2');
INSERT INTO `t_user` VALUES (2, 'root123456', 'e10adc3949ba59abbe56e057f20f883e', '123456', 3, '2');
INSERT INTO `t_user` VALUES (4, 'root1', 'eeafb716f93fa090d7716749a6eefa72', '1', 3, '2');
INSERT INTO `t_user` VALUES (10, 'xie', '4754cbc406c7365d745f1740846d6f62', 'xie', 3, '1');
INSERT INTO `t_user` VALUES (11, '123456789', '35314df2291a7ba05851ec60beef5a35', '123456789', 1, '2');
INSERT INTO `t_user` VALUES (12, 'a', 'e3832b4c0a407d51fb37f6548af01e71', '0258', 3, '2');
INSERT INTO `t_user` VALUES (13, 'xiezuojing0000', 'b3545192e2d8ac6a6b0d069e6f54e83f', '100', 3, '1');
INSERT INTO `t_user` VALUES (14, 'b', 'e3832b4c0a407d51fb37f6548af01e71', '0258', 3, '1');
INSERT INTO `t_user` VALUES (15, 'b', 'e3832b4c0a407d51fb37f6548af01e71', '0258', 3, '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ro_id`(`role_id`) USING BTREE,
  INDEX `u_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 3);
INSERT INTO `user_role` VALUES (4, NULL, NULL);

-- ----------------------------
-- Table structure for 商店
-- ----------------------------
DROP TABLE IF EXISTS `商店`;
CREATE TABLE `商店`  (
  `id` int(8) NOT NULL,
  `Store_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Store_Sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Store_Shelves_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Store_Take_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_id` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Store_M_id`(`Model_id`) USING BTREE,
  CONSTRAINT `Store_M_id` FOREIGN KEY (`Model_id`) REFERENCES `游戏模型` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 游戏任务
-- ----------------------------
DROP TABLE IF EXISTS `游戏任务`;
CREATE TABLE `游戏任务`  (
  `id` int(8) NOT NULL,
  `Task_Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Task_Description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Task_Type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Task_reward` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Task_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `T_M_id` FOREIGN KEY (`id`) REFERENCES `游戏模型` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 游戏模型
-- ----------------------------
DROP TABLE IF EXISTS `游戏模型`;
CREATE TABLE `游戏模型`  (
  `id` int(8) NOT NULL,
  `Model_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_Sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_Url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_Add_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_Change_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 游戏皮肤表
-- ----------------------------
DROP TABLE IF EXISTS `游戏皮肤表`;
CREATE TABLE `游戏皮肤表`  (
  `Skin_id` int(8) NOT NULL,
  `Skin_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Skin_Description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_id` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`Skin_id`) USING BTREE,
  INDEX `S_M_id`(`Model_id`) USING BTREE,
  CONSTRAINT `S_M_id` FOREIGN KEY (`Model_id`) REFERENCES `游戏模型` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 用户任务表
-- ----------------------------
DROP TABLE IF EXISTS `用户任务表`;
CREATE TABLE `用户任务表`  (
  `User_id` int(8) NULL DEFAULT NULL,
  `Task_id` int(11) NULL DEFAULT NULL,
  INDEX `U_T_id`(`User_id`) USING BTREE,
  INDEX `T_id`(`Task_id`) USING BTREE,
  CONSTRAINT `T_id` FOREIGN KEY (`Task_id`) REFERENCES `游戏任务` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `U_T_id` FOREIGN KEY (`User_id`) REFERENCES `gameuser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 用户皮肤表
-- ----------------------------
DROP TABLE IF EXISTS `用户皮肤表`;
CREATE TABLE `用户皮肤表`  (
  `User_id` int(8) NULL DEFAULT NULL,
  `Skin_id` int(11) NULL DEFAULT NULL,
  INDEX `U_S_id`(`User_id`) USING BTREE,
  INDEX `S_id`(`Skin_id`) USING BTREE,
  CONSTRAINT `S_id` FOREIGN KEY (`Skin_id`) REFERENCES `游戏皮肤表` (`Skin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `U_S_id` FOREIGN KEY (`User_id`) REFERENCES `gameuser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 用户背包表
-- ----------------------------
DROP TABLE IF EXISTS `用户背包表`;
CREATE TABLE `用户背包表`  (
  `User_id` int(8) NULL DEFAULT NULL,
  `Props_id` int(8) NULL DEFAULT NULL,
  INDEX `U_P_id`(`User_id`) USING BTREE,
  INDEX `P_id`(`Props_id`) USING BTREE,
  CONSTRAINT `P_id` FOREIGN KEY (`Props_id`) REFERENCES `道具表` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `U_P_id` FOREIGN KEY (`User_id`) REFERENCES `gameuser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 答案
-- ----------------------------
DROP TABLE IF EXISTS `答案`;
CREATE TABLE `答案`  (
  `Question_id` int(8) NULL DEFAULT NULL,
  `Error_Content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Correct_Content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `Q_id`(`Question_id`) USING BTREE,
  CONSTRAINT `Q_id` FOREIGN KEY (`Question_id`) REFERENCES `题库` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 签到表
-- ----------------------------
DROP TABLE IF EXISTS `签到表`;
CREATE TABLE `签到表`  (
  `Sign_frequency` int(8) NOT NULL,
  `Sign_Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Sign_Content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Sign_Reward` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Sign_frequency`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 行程表
-- ----------------------------
DROP TABLE IF EXISTS `行程表`;
CREATE TABLE `行程表`  (
  `id` int(8) NOT NULL,
  `Stroke_Incoming_Site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Stroke_Boarding_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Stroke_OutSite` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Car_id` int(8) NULL DEFAULT NULL,
  `User_id` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Stroke_U_id`(`User_id`) USING BTREE,
  CONSTRAINT `Stroke_U_id` FOREIGN KEY (`User_id`) REFERENCES `gameuser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 道具表
-- ----------------------------
DROP TABLE IF EXISTS `道具表`;
CREATE TABLE `道具表`  (
  `id` int(8) NOT NULL,
  `Props_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Props_Description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Model_id` int(8) NULL DEFAULT NULL,
  `Props_Sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `P_M_id`(`Model_id`) USING BTREE,
  CONSTRAINT `P_M_id` FOREIGN KEY (`Model_id`) REFERENCES `游戏模型` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 题库
-- ----------------------------
DROP TABLE IF EXISTS `题库`;
CREATE TABLE `题库`  (
  `id` int(8) NOT NULL,
  `Question_Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Question_Content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Question_Sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Question_Difficult` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
