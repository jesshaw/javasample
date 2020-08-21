drop database cee;
CREATE DATABASE IF NOT EXISTS cee default charset utf8 COLLATE utf8_general_ci;

use cee;


CREATE TABLE `school_info` (
  `school_info_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address` varchar(2000) NOT NULL DEFAULT '' COMMENT '',
  `admissions` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `answerurl` varchar(2000) NOT NULL DEFAULT '' COMMENT '',
  `belong` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `central` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `city_id` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `city_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `code_enroll` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `colleges_level` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `county_id` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `county_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `department` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `doublehigh` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `dual_class` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `dual_class_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `f211` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `f985` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `is_recruitment` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `is_top` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `level` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `level_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `nature` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `nature_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `province_id` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `province_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `publish_id` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `rank` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `rank_type` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `school_id` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `school_type` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `single_province` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `type` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `type_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `view_month` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `view_total` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `view_total_number` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `view_week` INTEGER NOT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`school_info_id`),
  KEY `ix_school_id` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='学校信息';


CREATE TABLE `provincial_score` (
  `provincial_score_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `school_id` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `school_name` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `province_id` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `batch` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `zslx` INTEGER NOT NULL DEFAULT 0 COMMENT '招生类型',
  `xclevel` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `max` double  NOT NULL DEFAULT 0 COMMENT '最高分',
  `min_section` INTEGER  NOT NULL DEFAULT 0 COMMENT '最低位次',
  `min` double NOT NULL DEFAULT 0 COMMENT '最低分',
  `average` double  NOT NULL DEFAULT 0 COMMENT '平均分',
  `filing` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `type_control` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `batch_control` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `local_batch_name` varchar(50) NOT NULL DEFAULT '' COMMENT '录取批次',
  `zslx_name` varchar(50)  NOT NULL DEFAULT '' COMMENT '招生类型名',
  `xclevel_name` varchar(50) NOT NULL DEFAULT '' COMMENT '',
  `proscore` double NOT NULL DEFAULT 0 COMMENT '省控线',
  `year` INTEGER NOT NULL DEFAULT 0 COMMENT '年份',
--   `updated_time` datetime(3)  NULL default CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  PRIMARY KEY (`provincial_score_id`),
  KEY `ix_school_id` (`school_id`),
  KEY `ix_province_id` (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='省分数线';




CREATE TABLE `school_specialty` (
  `school_specialty_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `school_id` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`special_id` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`type`   varchar(50)  NOT NULL DEFAULT '' COMMENT '文理科',
`max`    double NOT NULL DEFAULT 0 COMMENT '最高分',
`min`    double NOT NULL DEFAULT 0 COMMENT '最低分',
`average`    double NOT NULL DEFAULT 0 COMMENT '平均分',
`min_section`     INTEGER NOT NULL DEFAULT 0 COMMENT '',
`province`     varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`batch`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`id`     INTEGER NOT NULL DEFAULT 0 COMMENT '',
`spid`     INTEGER NOT NULL DEFAULT 0 COMMENT '',
`zslx`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`info`    varchar(2000)  NOT NULL DEFAULT '' COMMENT '',
`level1_name`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`level2_name`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`level3_name`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`level1`       varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`level2`        varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`spname`    varchar(2000)  NOT NULL DEFAULT '' COMMENT '',
`level3`        varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`local_batch_name`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
`zslx_name`    varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `year` INTEGER NOT NULL DEFAULT 0 COMMENT '年份',
  PRIMARY KEY (`school_specialty_id`),
  KEY `ix_school_id` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='学校专业分数';

CREATE TABLE `school_plan` (
  `school_plan_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `school_id` varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `special_id`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `num`  INTEGER NOT NULL DEFAULT 0 COMMENT '',
  `type`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `province`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `batch`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `id`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `spid`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `zslx`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `info`  varchar(2000)  NOT NULL DEFAULT '' COMMENT '',
  `level1_name`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `level2_name`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `level3_name`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `level1`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `level2`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `spname`  varchar(2000)  NOT NULL DEFAULT '' COMMENT '',
  `level3`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `local_batch_name`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `zslx_name`  varchar(50)  NOT NULL DEFAULT '' COMMENT '',
  `year` INTEGER NOT NULL DEFAULT 0 COMMENT '年份',
  PRIMARY KEY (`school_plan_id`),
  KEY `ix_school_id` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='招生计划';

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

