/**
 * 2012-12-20
 * 1.修改web_info表字段名
 */
ALTER TABLE `chyuan`.`web_info`   
  CHANGE `web_name_cn` `web_name` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  COMMENT '网站名称',
  CHANGE `web_keyword_cn` `web_keyword` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  COMMENT '关键字',
  CHANGE `web_description_cn` `web_description` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  COMMENT '说明',
  CHANGE `address_cn` `address` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  COMMENT '公司地址';