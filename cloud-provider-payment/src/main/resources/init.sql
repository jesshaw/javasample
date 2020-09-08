CREATE DATABASE IF NOT EXISTS db2019 default charset utf8 COLLATE utf8_general_ci;
use db2019;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `serial` varchar(200) DEFAULT NULL COMMENT '产品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



INSERT INTO `db2019`.`payment` (`id`, `serial`) VALUES ('1', '1');
