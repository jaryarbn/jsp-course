-- ----------------------------
-- Records of t_cart
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS goods;
CREATE TABLE goods
(
    `goods_id`   int(11)                                                NOT NULL AUTO_INCREMENT,
    `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `price`     double                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`goods_id`) USING BTREE,
    UNIQUE INDEX `goods_name` (`goods_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;