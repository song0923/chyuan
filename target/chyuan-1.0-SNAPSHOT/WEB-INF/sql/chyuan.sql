/*
SQLyog Community v10.11 
MySQL - 5.5.25a : Database - chyuan
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`chyuan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `chyuan`;

/*Table structure for table `about_us` */

DROP TABLE IF EXISTS `about_us`;

CREATE TABLE `about_us` (
  `content` text COMMENT '内容',
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(1) DEFAULT NULL COMMENT '类型。1：中文；2：英文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `about_us` */

insert  into `about_us`(`content`,`id`,`type`) values ('<span style=\"white-space:pre\"></span><p></p><p><span style=\"white-space:pre\"></span></p><p><span style=\"white-space:pre\">	</span>武汉创源世纪科技有限公司是一家主要从事智能化小区、智能化大厦、多媒体音视频系统、计算机信息技术系统集成工程设计与施工、电子信息及智能化产品等的研发及推广应用的高科技公司。</p><p><span style=\"white-space:pre\">	</span>作为一个致力于智能建筑领域的专业系统集成商，“创源世纪”结合自身优势，采用先进的技术与设施为用户提供全过程的一站式服务，包括工程咨询、系统设计、研究开发、安装测试、综合集成、培训督导、售后服务、技术支持等。</p><p><span style=\"white-space:pre\">	</span>凭借高素质的工程技术人员和精良的施工装备及专业化施工管理，为各企事业单位、高档物业提供专业、齐全的系统工程综合解决方案。可承接住宅小区智能化及楼宇弱电系统集成、智能大厦综合布线、计算机网络、公共广播、多媒体音视频及会议系统、一卡通系统、立体交叉停车场、建筑设备监控系统、建筑消防等规范设计及施工业务。</p><p>目前，我公司已取得了行业主管部门核发的专项设计及施工资质；拥有一批涉及计算机、电子技术、机电自动化、检测技术等专业的技术人才；同时，我公司与国内外众多著名厂商建立了密切的合作关系，以期更安全、更舒适、更高效、更节能的方式为客户服务。</p><p><span style=\"white-space:pre\">	</span>未来，“创源世纪”公司将逐步做大做强工程和产品的市场，并继续遵循“诚信务实、合作共赢”的经营理念，与各类兄弟企业建立稳定深入的伙伴关系，以期成为一流的智能化系统的产品供应商、工程商和集成商。</p><p style=\"text-align: center;\"><img src=\"http://127.0.0.1/upload/img/bmw.jpg\" align=\"middle\" alt=\"\" /><embed type=\"application/x-mplayer2\" classid=\"clsid:6bf52a52-394a-11d3-b153-00c04f79faa6\" src=\"http://127.0.0.1/upload/media/078a05fd-7fc2-4903-a6db-644cceeb7892..mp3\" enablecontextmenu=\"false\" autostart=\"false\" width=\"480\" height=\"400\" /><br /></p>',1,1);

/*Table structure for table `jobs` */

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '发布日期',
  `type` int(1) DEFAULT NULL COMMENT '类型。1：中文；2：英文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jobs` */

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主见',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '发布日期',
  `type` int(1) DEFAULT NULL COMMENT '类型。1：中文；2：英文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`id`,`title`,`content`,`create_time`,`type`) values (1,'认为同日而供热个个人','沃尔特玩儿玩儿玩儿玩儿33','2012-08-04 17:41:32',1),(2,'开机速度飞快','第三方斯蒂芬斯蒂芬的','2012-08-04 17:41:55',1),(3,'玩儿玩儿维吾尔','玩儿玩儿玩儿玩儿完','2012-08-04 17:42:03',1),(4,'豆腐干大概地方豆腐干豆腐干豆腐干豆腐干','豆腐干豆腐干豆腐干豆腐干豆腐干','2012-08-04 17:42:13',1),(5,'哈哈哈','哈哈哈哈哈哈哈哈','2012-08-04 17:42:24',1),(6,'反反复复反反复复反反复复吩咐','反反复复反反复复反反复复反反复复反反复复反反复复','2012-08-04 17:42:35',1),(7,'反反复复反反复复反反复复吩咐','反反复复反反复复反反复复吩咐','2012-08-04 17:42:39',1),(8,'斯蒂芬森防守对方','上电股份vdsfdgdfgdfg','2012-08-04 17:42:49',1),(9,'环境开会开会艰苦环境看','合肥规划法规和法国恢复供货','2012-08-04 17:43:04',1),(10,'呸呸呸呸呸呸呸呸呸呸呸呸呸呸呸呸呸','靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠','2012-08-04 17:43:20',1),(11,'吞吞吐吐吐吐吐吐吐吐吐吐','吐吐吐吐吐吐吐吐吐吐吐吐吐吐吐吐吐','2012-08-04 17:43:29',1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` int(1) DEFAULT NULL COMMENT '类型。1：中文；2：英文',
  `thumbnail` varchar(255) DEFAULT NULL COMMENT '缩略图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`real_name`,`password`) values (1,'admin','系统管理员','e10adc3949ba59abbe56e057f20f883e');

/*Table structure for table `web_info` */

DROP TABLE IF EXISTS `web_info`;

CREATE TABLE `web_info` (
  `web_name_cn` varchar(255) DEFAULT NULL COMMENT '网站名称',
  `website` varchar(255) DEFAULT NULL COMMENT '网址',
  `web_keyword_cn` varchar(255) DEFAULT NULL COMMENT '关键字',
  `web_description_cn` varchar(255) DEFAULT NULL COMMENT '说明',
  `address_cn` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `postcode` varchar(10) DEFAULT NULL COMMENT '邮编',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `fax` varchar(50) DEFAULT NULL COMMENT '传真',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `mail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `icp_code` varchar(255) DEFAULT NULL COMMENT 'icp备案号',
  `company` varchar(255) DEFAULT NULL COMMENT '公司名',
  `hotline` varchar(50) DEFAULT NULL COMMENT '热线电话',
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(1) NOT NULL COMMENT '类型。1：中文；2：英文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `web_info` */

insert  into `web_info`(`web_name_cn`,`website`,`web_keyword_cn`,`web_description_cn`,`address_cn`,`postcode`,`phone`,`fax`,`mobile`,`mail`,`linkman`,`icp_code`,`company`,`hotline`,`id`,`type`) values ('武汉创源世纪科技有限公司','http://127.0.0.1','','','武汉市葛洲坝广场11栋3单元1602室','430000','','027-85555638','','sjdhfb@qq.com','','','武汉创源世纪科技有限公司','4000279838',1,1),('WuHan Chyuan Company','http://127.0.0.1',NULL,NULL,'WuHan Gezhouba guangchang 11-3-1602','430000',NULL,'027-85555638',NULL,'sjdhfb@qq.com',NULL,NULL,'WuHan Chyuan Company','4000279838',2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
