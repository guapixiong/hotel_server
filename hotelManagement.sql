-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: hotelManagement
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `administrator_id` int unsigned NOT NULL AUTO_INCREMENT,
  `administrator_name` varchar(10) DEFAULT NULL,
  `administrator_phone` varchar(10) DEFAULT NULL,
  `account_name` varchar(20) NOT NULL,
  `account_password` varchar(20) NOT NULL,
  PRIMARY KEY (`administrator_id`),
  UNIQUE KEY `account_name` (`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,'admin','123','admin','123'),(2,NULL,NULL,'admin1','123'),(3,NULL,NULL,'admin2','123'),(4,NULL,NULL,'qpyao','qpyao'),(5,NULL,NULL,'236826941','123456'),(6,NULL,NULL,'2368269411','123456'),(7,NULL,NULL,'adwsada','123'),(8,NULL,NULL,'guapi','123');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'午餐'),(2,'早餐'),(3,'零食');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity` (
  `commodity_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '商品名称',
  `price` float DEFAULT '0' COMMENT '商品价格',
  `amount` int DEFAULT '0' COMMENT '商品数量',
  `commodity_url` varchar(100) DEFAULT NULL COMMENT '商品图片',
  `commodity_introduction` varchar(200) DEFAULT NULL COMMENT '商品简介',
  `category_id` int DEFAULT NULL COMMENT '商品类别id',
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'蛋包饭',15.5,2,'/images/8d11382a-278d-430d-b9bc-94d36325b924.jpg','美味的蛋包饭',1),(2,'可乐',4,83,'/images/16dbceb1-4752-48e4-8427-0446c5140bd8.jpg','好喝的可乐',3),(3,'土豆牛肉',20,18,'/images/5dc70cca-5bcb-42e0-bc22-382db80e5dc7.jpg','好吃',1),(4,'灌汤包',2,100,'/images/e6bd95a9-f242-4d30-a753-f148fd638d33.jpg','好吃',2),(7,'炸鸡',23,3,'/images/c4a1e807-ffaf-4ad0-9360-ee487ab5bb92.jpg','',1),(9,'蛋炒饭',15,5,'/images/8ee97f0d-ca58-4772-ac2d-c1e72f15820d.jpg','美味的蛋炒饭',1),(10,'红烧肉',28,7,'/images/e34237df-56f7-4d0b-8d94-a863eace5425.jpg','好吃的红烧肉',1),(11,'fdgljs',4,0,'/images/0049d226-351e-46a1-b982-cd716687d505.jpg','efsfseg',1);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_record`
--

DROP TABLE IF EXISTS `commodity_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_record` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '商品订单id',
  `order_id` int NOT NULL COMMENT '订单编号',
  `commodity_id` int unsigned DEFAULT NULL COMMENT '商品id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `complete_time` datetime DEFAULT NULL COMMENT '订单完成时间',
  `commodity_status` varchar(5) DEFAULT '1' COMMENT '0为已取消，1为已创建，2为已完成',
  `commodity_count` int DEFAULT '1' COMMENT '商品数量',
  `money` float DEFAULT '0' COMMENT '消费金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_record`
--

LOCK TABLES `commodity_record` WRITE;
/*!40000 ALTER TABLE `commodity_record` DISABLE KEYS */;
INSERT INTO `commodity_record` VALUES (2,8,1,'2023-04-02 18:39:35','2023-04-03 11:48:28','2',2,30),(3,9,2,'2023-04-02 19:54:01','2023-04-03 11:56:23','2',10,40),(4,11,3,'2023-04-02 18:06:55',NULL,'1',2,40),(6,15,3,'2023-04-18 16:06:09',NULL,'1',1,20),(8,15,1,'2023-04-18 16:06:09',NULL,'1',2,31),(9,15,1,'2023-04-19 09:59:31',NULL,'1',1,15.5),(10,15,2,'2023-04-19 09:59:31',NULL,'1',1,4),(11,15,3,'2023-04-19 09:59:31',NULL,'1',1,20),(12,15,7,'2023-04-19 09:59:31',NULL,'1',1,23),(15,19,1,'2023-04-21 16:56:56',NULL,'1',1,15.5),(16,29,1,'2023-04-24 09:39:51','2023-04-24 09:40:19','2',1,15.5),(17,29,9,'2023-04-24 09:39:51','2023-04-24 09:40:19','2',1,15),(18,19,2,'2023-04-25 09:24:57',NULL,'1',4,16),(19,19,10,'2023-04-25 09:24:57',NULL,'1',6,168),(20,34,2,'2023-05-19 20:22:23','2023-05-19 20:26:36','2',1,4),(21,34,3,'2023-05-19 20:22:23','2023-05-19 20:26:36','2',1,20),(22,37,3,'2023-06-02 09:27:37','2023-06-02 09:44:55','2',1,20),(23,37,2,'2023-06-02 09:27:37','2023-06-02 09:44:55','2',1,4),(24,37,1,'2023-06-02 09:27:37','2023-06-02 09:44:55','2',1,15.5),(25,37,1,'2023-06-02 09:32:04','2023-06-02 09:44:55','2',2,31),(26,35,2,'2023-06-02 09:55:33',NULL,'1',6,24),(27,35,2,'2023-06-02 10:00:22',NULL,'1',3,12),(28,39,1,'2023-06-03 11:50:16','2023-06-03 11:50:35','2',3,46.5),(29,39,3,'2023-06-03 11:50:16','2023-06-03 11:50:35','2',1,20),(30,40,7,'2023-06-03 15:15:16','2023-06-03 15:15:44','2',2,46),(31,40,9,'2023-06-03 15:15:16','2023-06-03 15:15:44','2',3,45);
/*!40000 ALTER TABLE `commodity_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(10) DEFAULT NULL,
  `sex` varchar(1) DEFAULT '1' COMMENT '默认1，1为男，0为女',
  `age` int DEFAULT NULL,
  `customer_phone` varchar(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `openid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `customer_chk_1` CHECK (((`sex` = _utf8mb4'1') or (`sex` = _utf8mb4'0')))
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'伊地知虹夏','0',18,'123','2023-03-30 14:36:53',NULL),(2,'波奇酱','0',18,'124','2023-03-31 15:02:32',NULL),(3,'山田凉','0',18,'125','2023-03-31 15:02:32',NULL),(4,'喜多郁代','0',18,'126','2023-03-31 15:02:32',NULL),(9,'熊瓜皮','1',NULL,'15180643110','2023-04-17 14:28:04',NULL),(10,'哈哈哈哈','1',NULL,'12332412315','2023-04-17 14:31:31',NULL),(11,'和泉玲奈','1',NULL,'127','2023-04-19 10:22:12',NULL),(13,'凯尔希','1',NULL,'128','2023-04-24 09:38:55',NULL),(14,'瓜皮','1',NULL,'214332412','2023-05-19 18:52:33',NULL),(15,'大噶','1',NULL,'124231542','2023-05-19 19:01:15',NULL),(16,'','1',NULL,'54236536','2023-05-19 21:04:29',NULL),(18,'','1',NULL,'6666666','2023-06-01 09:44:54','oxpeF5JZ4YzpP8nP-BQJ291P5ZIo'),(19,'发放','1',NULL,'2142335','2023-06-03 11:49:31',NULL),(20,'ggagaga','1',NULL,'1254646457','2023-06-03 15:14:18',NULL),(21,'gusiofuo','1',NULL,'124325535','2023-06-03 15:16:49',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deposit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `payment_type` varchar(1) DEFAULT '0' COMMENT '0为现金支付，1为支付宝支付，2为微信支付',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
  `complete_time` datetime DEFAULT NULL COMMENT '完成时间',
  `deposit` float DEFAULT '0' COMMENT '押金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='押金记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit`
--

LOCK TABLES `deposit` WRITE;
/*!40000 ALTER TABLE `deposit` DISABLE KEYS */;
INSERT INTO `deposit` VALUES (1,8,'0','2023-04-02 14:41:56','2023-04-03 11:49:27',300),(2,9,'0','2023-04-02 14:41:56','2023-04-03 11:56:03',50),(3,11,'0','2023-04-02 14:51:03','2023-04-03 11:08:49',100),(6,23,'0','2023-04-19 14:12:56',NULL,50),(7,24,'0','2023-04-19 15:08:50',NULL,60),(8,25,'0','2023-04-20 14:41:31',NULL,60),(9,26,'0','2023-04-20 14:44:07',NULL,60),(10,29,'0','2023-04-24 09:39:27',NULL,60),(11,30,'0','2023-04-24 09:41:54',NULL,30),(12,34,'0','2023-05-19 19:01:15',NULL,60),(13,32,'0','2023-05-19 20:15:50',NULL,60),(14,37,'0','2023-06-02 09:27:14',NULL,50),(15,35,'0','2023-06-02 09:47:56',NULL,50),(16,39,'0','2023-06-03 11:50:03',NULL,70),(17,40,'0','2023-06-03 15:14:57',NULL,50),(18,41,'0','2023-06-03 15:16:49',NULL,50);
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupant_record`
--

DROP TABLE IF EXISTS `occupant_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `occupant_record` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int unsigned DEFAULT NULL COMMENT '房间订单id',
  `card_id` varchar(18) NOT NULL COMMENT '身份证号',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `type` varchar(1) DEFAULT '0' COMMENT '0为居民身份证，1为临时身份证',
  `register_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
  `leave_time` datetime DEFAULT NULL COMMENT '离开时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupant_record`
--

LOCK TABLES `occupant_record` WRITE;
/*!40000 ALTER TABLE `occupant_record` DISABLE KEYS */;
INSERT INTO `occupant_record` VALUES (7,8,'360427200101010002','伊地知虹夏','0','2023-04-02 14:35:23','2023-04-03 11:46:11'),(8,9,'360427200101010004','波奇酱','0','2023-04-02 14:35:33','2023-04-03 11:56:14'),(9,11,'360427200101010006','山田凉','0','2023-04-02 14:35:05','2023-04-03 11:09:03'),(10,11,'360427200101010008','喜多郁代','0','2023-04-02 14:35:46','2023-04-03 11:09:07'),(11,18,'123424123','sss','0','2023-04-17 11:51:39','2023-04-20 11:07:35'),(12,18,'12312352314','gggg','0','2023-04-17 11:51:39','2023-04-20 11:07:35'),(13,18,'2356456456','12','0','2023-04-17 11:51:39','2023-04-20 11:07:35'),(14,15,'12312432451235','熊','0','2023-04-17 14:18:20',NULL),(15,15,'321552436234','瓜','0','2023-04-17 14:24:49',NULL),(17,23,'134213','士大夫','0','2023-04-19 14:12:56','2023-04-20 13:49:35'),(18,24,'1232143123','阿斯蒂芬','0','2023-04-19 15:08:50','2023-04-21 16:58:04'),(19,25,'123435436','和泉玲奈','0','2023-04-20 14:41:31','2023-04-20 14:43:03'),(21,29,'12344','凯尔希','0','2023-04-24 09:39:27','2023-04-24 09:40:19'),(22,30,'12334223','gua','0','2023-04-24 09:41:54','2023-04-24 09:42:45'),(23,34,'2143214532','大噶','0','2023-05-19 19:01:15','2023-05-19 20:26:36'),(24,34,'341532145','挂','0','2023-05-19 19:01:15','2023-05-19 20:26:36'),(25,32,'3214321531','撒打发','0','2023-05-19 20:15:50','2023-05-19 20:18:39'),(26,37,'3254235626','戈萨的','0','2023-06-02 09:27:14','2023-06-02 09:44:55'),(27,35,'5644357','飒飒','0','2023-06-02 09:47:56',NULL),(28,39,'323552','撒打发','0','2023-06-03 11:50:03','2023-06-03 11:50:35'),(29,40,'1235212535','xaofaho','0','2023-06-03 15:14:57','2023-06-03 15:15:44'),(30,41,'234235','ffsawf','0','2023-06-03 15:16:49',NULL);
/*!40000 ALTER TABLE `occupant_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_record`
--

DROP TABLE IF EXISTS `order_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_record` (
  `order_id` int unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(10) NOT NULL,
  `room_id` varchar(10) NOT NULL COMMENT '房间id',
  `room_type` varchar(1) DEFAULT '0' COMMENT '0为标准房价格，1为钟点房',
  `order_status` varchar(4) DEFAULT '1' COMMENT '-1为已退款，0为已取消，1为已预定，2待结账，3已完成',
  `check_in_time` datetime NOT NULL COMMENT '入住时间，一般为当天14点之后',
  `check_out_time` datetime NOT NULL COMMENT '退房时间一般为12点之前',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `complete_time` datetime DEFAULT NULL COMMENT '订单完成时间',
  `payment_type` varchar(1) DEFAULT '1' COMMENT '0为现金支付，1为支付宝支付，2为现金支付',
  `final_payment_amount` float DEFAULT '0' COMMENT '最终付款金额，将房间费用和商品费用结算在一起',
  PRIMARY KEY (`order_id`),
  KEY `test_index` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_record`
--

LOCK TABLES `order_record` WRITE;
/*!40000 ALTER TABLE `order_record` DISABLE KEYS */;
INSERT INTO `order_record` VALUES (8,'1','2','0','3','2023-04-02 14:00:00','2023-04-03 12:00:00','2023-04-02 13:32:14','2023-04-03 11:30:58','0',210),(9,'2','1','0','3','2023-04-02 14:00:00','2023-04-03 12:00:00','2023-04-02 04:50:17','2023-04-03 11:54:50','1',190),(10,'3','3','0','0','2023-04-02 14:00:00','2023-04-03 12:00:00','2023-04-02 09:00:11','2023-04-02 10:00:43','1',0),(11,'4','5','0','3','2023-04-02 14:00:00','2023-04-03 12:00:00','2023-04-02 10:02:37','2023-04-03 11:08:11','1',50),(15,'1','8','0','2','2023-03-17 14:00:00','2023-03-19 12:00:00','2023-04-14 13:48:24',NULL,'1',0),(18,'1','4','0','3','2023-03-16 14:00:00','2023-03-17 12:00:00','2023-04-17 11:51:39','2023-04-20 11:07:35','1',100),(19,'9','1','0','2','2023-05-02 12:00:00','2023-05-04 14:00:00','2023-04-17 14:28:04',NULL,'1',0),(20,'10','8','0','0','2023-03-15 14:00:00','2023-03-16 12:00:00','2023-04-17 14:31:31','2023-04-17 14:56:21','1',0),(21,'1','1','0','0','2023-03-15 14:00:00','2023-03-16 12:00:00','2023-04-17 16:09:23','2023-04-17 16:09:41','1',0),(22,'11','1','0','0','2023-04-19 14:00:00','2023-04-20 12:00:00','2023-04-19 10:22:12','2023-04-19 16:54:19','1',0),(23,'2','8','1','-1','2023-03-15 10:00:00','2023-03-15 13:00:00','2023-04-19 13:53:05','2023-04-20 13:49:35','1',20),(24,'3','8','0','3','2023-03-15 14:00:00','2023-03-16 12:00:00','2023-04-19 15:08:50','2023-04-21 16:58:04','1',100),(25,'1','3','0','-1','2023-03-15 14:00:00','2023-03-22 12:00:00','2023-04-20 14:40:28','2023-04-20 14:43:03','1',1),(26,'11','3','0','3','2023-03-15 14:00:00','2023-03-19 12:00:00','2023-04-20 14:43:38','2023-04-20 14:51:48','1',482.4),(28,'1','12','0','0','2023-04-23 14:00:00','2023-04-24 12:00:00','2023-04-23 14:57:39','2023-04-23 14:57:53','1',2),(29,'13','3','0','3','2023-04-24 14:00:00','2023-04-27 12:00:00','2023-04-24 09:38:55','2023-04-24 09:40:19','1',330.5),(30,'3','1','1','-1','2023-04-24 09:41:00','2023-04-24 12:41:00','2023-04-24 09:41:54','2023-04-24 09:42:45','1',30),(31,'11','12','0','0','2023-04-24 14:00:00','2023-04-25 12:00:00','2023-04-24 16:10:25','2023-05-19 20:11:48','1',0),(32,'3','2','0','-1','2023-04-28 14:00:00','2023-04-29 12:00:00','2023-04-28 16:18:54','2023-05-19 20:18:39','1',10),(33,'14','12','0','1','2023-05-19 14:00:00','2023-05-20 12:00:00','2023-05-19 18:52:33',NULL,'1',0),(34,'15','1','0','3','2023-05-19 14:00:00','2023-05-20 12:00:00','2023-05-19 19:01:15','2023-05-19 20:26:36','1',174),(35,'16','4','0','2','2023-05-19 14:00:00','2023-05-20 12:00:00','2023-05-19 21:04:29',NULL,'1',100),(36,'18','2','0','0','2023-06-01 14:00:00','2023-06-02 12:00:00','2023-06-01 11:03:35','2023-06-01 11:36:56','1',0),(37,'18','1','0','3','2023-06-02 14:00:00','2023-06-03 12:00:00','2023-06-02 09:19:45','2023-06-02 09:44:55','1',220.5),(38,'18','3','0','0','2023-06-02 14:00:00','2023-06-03 12:00:00','2023-06-02 20:44:13','2023-06-02 20:44:19','1',0),(39,'19','12','0','3','2023-06-03 14:00:00','2023-06-04 12:00:00','2023-06-03 11:49:31','2023-06-03 11:50:35','1',216.5),(40,'20','5','0','3','2023-06-03 14:00:00','2023-06-04 12:00:00','2023-06-03 15:14:18','2023-06-03 15:15:44','1',101),(41,'21','8','0','2','2023-06-03 14:00:00','2023-06-04 12:00:00','2023-06-03 15:16:49',NULL,'1',100),(42,'18','4','0','1','2023-06-03 14:00:00','2023-06-04 12:00:00','2023-06-03 15:19:37',NULL,'1',0);
/*!40000 ALTER TABLE `order_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_id` int unsigned NOT NULL AUTO_INCREMENT,
  `room_number` varchar(10) DEFAULT NULL COMMENT '房间门牌号',
  `room_url` varchar(100) DEFAULT '' COMMENT '房间照片',
  `type_id` int DEFAULT NULL COMMENT '1为单人间，2为双人间，3为三人间',
  `room_price` float DEFAULT '0' COMMENT '房间价格(每天)',
  `hour_price` float DEFAULT '0' COMMENT '钟点房价格',
  `room_introduction` varchar(200) DEFAULT NULL COMMENT '房间简介',
  `room_state` varchar(1) DEFAULT '1' COMMENT '0为不启用，1为启用',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'1103','/images/30bea2cb-bf00-4815-8eaf-5504b50cbc44.jpg',4,150,60,'电竞爱好者的专属','1'),(2,'1104','/images/21f8070b-b0be-4976-9efa-63154ce17f9a.jpg',2,180,80,'666','1'),(3,'1105','/images/f4cb3bf6-206d-4737-b4f6-6778fb1477dd.jpg',1,100,60,'哈哈哈','1'),(4,'1106','/images/50b870e5-ca54-426b-9854-481eb5d6356c.jpg',3,100,60,NULL,'1'),(5,'1107','/images/b18c5408-ce54-4532-9a36-3c88d66665cf.jpg',3,10,5,'乐队冲冲冲','1'),(6,'1108','/images/ca1ae55a-94ff-453c-b3d7-1ce8372ec1e7.jpg',1,50,60,NULL,'1'),(8,'1109','/images/d3cf47e7-34da-462c-ab78-47fdeadac3fb.jpg',1,100,60,'十四时','0'),(11,'1110','/images/113728cc-8f66-4381-882a-85e59f3b814d.jpg',1,100,50,'粉','1'),(12,'1111','/images/2244860f-33c0-48e6-a06f-9b98cf85e9f6.jpg',1,150,70,'哈哈哈哈','1'),(13,'1111111','/images/64886d83-9030-4041-b761-7c8aaf70e3c5.jpg',1,124,60,'新增房间','1'),(14,'32435','/images/095a8755-50c9-413f-8da7-41ee00221210.jpg',1,160,50,'fdfsdfdsa','1');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(10) DEFAULT NULL COMMENT '房间类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='房间类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'单人间'),(2,'双人间'),(3,'三人间'),(4,'豪华包间');
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `test_cord`
--

DROP TABLE IF EXISTS `test_cord`;
/*!50001 DROP VIEW IF EXISTS `test_cord`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `test_cord` AS SELECT 
 1 AS `order_id`,
 1 AS `customer_id`,
 1 AS `room_type`,
 1 AS `order_status`,
 1 AS `check_in_time`,
 1 AS `check_out_time`,
 1 AS `create_time`,
 1 AS `complete_time`,
 1 AS `payment_type`,
 1 AS `final_payment_amount`,
 1 AS `room_id`,
 1 AS `room_url`,
 1 AS `room_number`,
 1 AS `type_id`,
 1 AS `room_price`,
 1 AS `hour_price`,
 1 AS `room_introduction`,
 1 AS `room_state`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `test_cord`
--

/*!50001 DROP VIEW IF EXISTS `test_cord`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `test_cord` AS select `order_record`.`order_id` AS `order_id`,`order_record`.`customer_id` AS `customer_id`,`order_record`.`room_type` AS `room_type`,`order_record`.`order_status` AS `order_status`,`order_record`.`check_in_time` AS `check_in_time`,`order_record`.`check_out_time` AS `check_out_time`,`order_record`.`create_time` AS `create_time`,`order_record`.`complete_time` AS `complete_time`,`order_record`.`payment_type` AS `payment_type`,`order_record`.`final_payment_amount` AS `final_payment_amount`,`r`.`room_id` AS `room_id`,`r`.`room_url` AS `room_url`,`r`.`room_number` AS `room_number`,`r`.`type_id` AS `type_id`,`r`.`room_price` AS `room_price`,`r`.`hour_price` AS `hour_price`,`r`.`room_introduction` AS `room_introduction`,`r`.`room_state` AS `room_state` from (`order_record` left join `room` `r` on((`order_record`.`room_id` = `r`.`room_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-26 14:48:00
