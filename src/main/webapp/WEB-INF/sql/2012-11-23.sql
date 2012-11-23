/*
2012-11-23

1、用户表【user】新增【是否删除】字段
2、用户表【user】新增【创建日期】字段
*/
ALTER TABLE `chyuan`.`user`   
  ADD COLUMN `is_delete` INT(1) DEFAULT 0  NOT NULL  COMMENT '是否删除。1：是；0：否' AFTER `password`;
ALTER TABLE `chyuan`.`user`   
  ADD COLUMN `create_time` DATETIME NULL  COMMENT '创建日期' AFTER `is_delete`;