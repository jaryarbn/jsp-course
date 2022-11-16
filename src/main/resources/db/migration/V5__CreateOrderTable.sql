-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`        varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `un`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `number`    int(11)                                                NOT NULL,
    `price`     double                                                 NOT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;