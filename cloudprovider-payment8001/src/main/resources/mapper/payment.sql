-- db2022.payment definition

CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，Twitter的分布式自增ID算法snowflake',
  `serial` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '1' COMMENT '类型【1-正常、2-服务已失效】',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='付款表';