-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `un`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `pwd`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `addr`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    UNIQUE INDEX `un` (`un`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;