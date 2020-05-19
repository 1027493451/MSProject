/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0.17
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3307
 Source Schema         : springcloud_practice

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 18/05/2020 17:53:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` decimal(19, 2) NULL DEFAULT NULL,
  `product_quantity` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`detail_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1234567', '1234567', 'http://xxx.com', '157875196366160022', '皮蛋粥', 0.01, 2);
INSERT INTO `order_detail` VALUES ('1585651512327963089', '1585651512278144586', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587978649722603795', '1587978649076307695', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587978672627407563', '1587978672620122385', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587978708719208329', '1587978708712907709', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587978799773789471', '1587978799766845836', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587978823073330837', '1587978823064479643', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587978960035572710', '1587978960028114633', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979073348230020', '1587979073245273456', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979174215246249', '1587979174203808372', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979300250883547', '1587979300240750531', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979585529542914', '1587979585521165605', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979592078682083', '1587979591902842417', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979619098414095', '1587979619090235698', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1587979722519155063', '1587979722510498824', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588732479924183942', '1588732479301626374', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588732929492216646', '1588732928700429063', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588733023478426868', '1588733023447339094', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588733730622345081', '1588733730604307272', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588734014976948341', '1588734014614362572', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588734699451907392', '1588734699157799223', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588735429911304867', '1588735429293197376', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588735663326430524', '1588735662721684416', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588735867618109526', '1588735867014489880', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588736818046418103', '1588736817435481338', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588737120652937354', '1588737119991696370', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588737208050157068', '1588737208032120797', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588737235140829717', '1588737235130166294', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588738080134840742', '1588738079845554270', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588738100589794634', '1588738100580865282', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588738267608467821', '1588738266905301643', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588738296009355843', '1588738295993202022', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588738324207907430', '1588738324188312950', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1588738724141659452', '1588738723505722772', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1589010956177653027', '1589010954505838846', '11111', '1', '鸡肉卷', 15.00, 1);
INSERT INTO `order_detail` VALUES ('1589787201844561078', '1589787201101685206', '11111', '1', '鸡肉卷', 15.00, 1);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `order_amount` decimal(19, 2) NULL DEFAULT NULL,
  `order_status` int(11) NULL DEFAULT NULL,
  `pay_status` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1234567', '慕课网总部', '师兄', '1101110', '1886131241241', '2020-04-28 10:49:30', 2.50, 1, 0, '2020-04-28 10:49:23');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_type` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '热榜', 1, '2020-03-26 15:14:56', '2020-03-26 15:15:00');
INSERT INTO `product_category` VALUES (2, '好吃呐', 2, '2020-03-26 15:15:02', '2020-03-26 15:15:04');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category_type` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `product_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` decimal(19, 2) NULL DEFAULT NULL,
  `product_status` int(11) NULL DEFAULT NULL,
  `product_stock` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1', 1, '2020-03-30 15:17:53', '南方小吃', '11111', '鸡肉卷', 15.00, 0, 294, '2020-03-30 15:18:23');
INSERT INTO `product_info` VALUES ('2', 1, '2020-03-30 15:17:50', '北方瞎吃', '11111', '汉堡', 19.00, 0, 10, '2020-03-30 15:18:21');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '2020-04-24 11:22:41', 'abc', '123456', 1, '2020-04-24 11:22:54', 'admin');
INSERT INTO `user_info` VALUES ('2', '2020-04-24 12:01:08', 'xyz', '123456', 2, '2020-04-24 12:01:21', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
