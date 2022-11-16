-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS cart;
CREATE TABLE cart
(
    `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `number`    int(11)                                                NOT NULL,
    `price`     double                                                 NULL DEFAULT NULL,
    `un`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;