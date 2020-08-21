drop database transaction_sample ;
CREATE DATABASE IF NOT EXISTS transaction_sample default charset utf8 COLLATE utf8_general_ci;

use transaction_sample;

CREATE TABLE `t_account` (
  `t_account_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50)  NOT NULL DEFAULT '' COMMENT '用户名',
  `balance`  DECIMAL(10,2)  NOT NULL DEFAULT '' COMMENT '余额',
  PRIMARY KEY (`t_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='帐号';

CREATE TABLE `t_transfer_record` (
  `t_transfer_record_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `out_name` varchar(50)  NOT NULL DEFAULT ''  COMMENT '转出名',
  `int_name`  varchar(50)  NOT NULL DEFAULT ''  COMMENT '转入名',
  `amount`  DECIMAL(10,2)  NOT NULL DEFAULT '' COMMENT '操作金额',
  `transfer_status` INTEGER  NOT NULL DEFAULT 0 COMMENT '状态'
  PRIMARY KEY (`t_transfer_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='转帐记录';

