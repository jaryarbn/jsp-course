use `mini_shop`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
CREATE TABLE `t_cart`
(
    `goodsname` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
    `number`    int                               NOT NULL,
    `price`     double                            NULL DEFAULT NULL,
    `un`        varchar(50) CHARACTER SET utf8mb4 NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cart
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
CREATE TABLE `t_goods`
(
    `goodsid`   int                               NOT NULL AUTO_INCREMENT,
    `goodsname` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
    `price`     decimal                           NULL DEFAULT NULL,
    PRIMARY KEY (`goodsid`) USING BTREE,
    UNIQUE INDEX `goodsname` (`goodsname`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8mb4
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods`
VALUES (1, '雅诗兰黛精华液', 935);
INSERT INTO `t_goods`
VALUES (2, '欧莱雅护肤套装', 409);
INSERT INTO `t_goods`
VALUES (3, 'SK-II神仙水', 2510);
INSERT INTO `t_goods`
VALUES (4, '兰蔻塑颜霜(50ml)', 895);
INSERT INTO `t_goods`
VALUES (5, '资生堂礼盒套装', 1440);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
CREATE TABLE `t_order`
(
    `id`        varchar(80) CHARACTER SET utf8mb4 NOT NULL,
    `un`        varchar(50) CHARACTER SET utf8mb4 NOT NULL,
    `goodsname` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
    `number`    int                               NOT NULL,
    `price`     double                            NOT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order`
VALUES ('20220314131205423', 'user1', '欧莱雅护肤套装', 1, 409);
INSERT INTO `t_order`
VALUES ('20220314131205423', 'user1', 'SK-II神仙水', 1, 2510);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user`
(
    `un`    varchar(50) CHARACTER SET utf8mb4 NOT NULL,
    `pwd`   varchar(50) CHARACTER SET utf8mb4 NOT NULL,
    `phone` varchar(30) CHARACTER SET utf8mb4 NULL DEFAULT NULL,
    `addr`  varchar(50) CHARACTER SET utf8mb4 NULL DEFAULT NULL,
    UNIQUE INDEX `un` (`un`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user`
VALUES ('user1', '123456', '13588888888', 'jaryarbn');

SET
    FOREIGN_KEY_CHECKS = 1;
