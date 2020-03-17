-- MySQL dump 10.13  Distrib 5.7.26, for osx10.9 (x86_64)
--
-- Host: localhost    Database: sideproject
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(200) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `country_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'1971 Oswego St','Aurora','CO','80010','US'),(2,'731 E MEADOW LN, 3249','BIG BEAR CITY','California','92314',''),(3,'731 E MEADOW LN','BIG BEAR CITY','California','92314',''),(4,'2520 S Logan St','Denver','CO','80210',''),(5,'','','','',''),(6,'','','','',''),(7,'','','','',''),(8,'','','','',''),(9,'','','','',''),(10,'','','','',''),(11,'','','','',''),(12,'','','','',''),(13,'','','','',''),(14,'','','','',''),(15,'','','','',''),(16,'','','','',''),(17,'2520 S Logan St','Denver','CO','80210',NULL),(18,'2520 S Logan St','Denver','CO','80210',NULL),(19,'2520 S Logan St','Denver','CO','80210',NULL),(20,'2520 S Logan St','Denver','CO','80210',NULL),(21,'2520 S Logan St','Denver','CO','80210',NULL),(22,'2520 S Logan St','Denver','CO','80210',NULL),(23,'2520 S Logan St','Denver','CO','80210',NULL),(24,'2520 S Logan St','Denver','CO','80210',NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(500) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'https://scontent-ort2-1.xx.fbcdn.net/v/t1.0-9/p720x720/85009993_473952669962749_85825287798915072_o.jpg?_nc_cat=105&_nc_sid=0be424&_nc_ohc=bT-FY55zhXgAX-kkCxK&_nc_ht=scontent-ort2-1.xx&_nc_tp=6&oh=810fed2a9387257c0de72ea956f84731&oe=5EEBB24F','Design Cookies','Baby Reveal');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(200) NOT NULL,
  `image_one` varchar(200) DEFAULT NULL,
  `image_two` varchar(200) DEFAULT NULL,
  `image_three` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Cookie',NULL,NULL,NULL),(2,'Cupcake',NULL,NULL,NULL),(3,'Cake',NULL,NULL,NULL),(4,'Macaroon',NULL,NULL,NULL),(5,'Macarons',NULL,NULL,NULL),(6,'Cookie',NULL,NULL,NULL),(7,'cookie',NULL,NULL,NULL),(8,'',NULL,NULL,NULL),(9,'',NULL,NULL,NULL),(10,'',NULL,NULL,NULL),(11,'',NULL,NULL,NULL),(12,'',NULL,NULL,NULL),(13,'',NULL,NULL,NULL),(14,'',NULL,NULL,NULL),(15,'',NULL,NULL,NULL),(16,'',NULL,NULL,NULL),(17,'',NULL,NULL,NULL),(18,'',NULL,NULL,NULL),(19,'Cookie',NULL,NULL,NULL),(20,'cook',NULL,NULL,NULL),(21,'cook',NULL,NULL,NULL),(22,'hjkg',NULL,NULL,NULL),(23,'jhgkhj',NULL,NULL,NULL),(25,'Cookie',NULL,NULL,NULL),(26,'Cookie',NULL,NULL,NULL),(27,'Cookie',NULL,NULL,NULL),(28,'Cookie',NULL,NULL,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_placed`
--

DROP TABLE IF EXISTS `orders_placed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_placed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_placed` varchar(50) DEFAULT NULL,
  `date_requested` varchar(45) DEFAULT NULL,
  `date_fulfilled` varchar(50) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `ingredients_specified` varchar(500) DEFAULT NULL,
  `ship_address_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `accepted` varchar(20) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `item_quantity` int(11) DEFAULT NULL,
  `design_specified` varchar(500) DEFAULT NULL,
  `occasion` varchar(500) DEFAULT NULL,
  `allergies_specified` varchar(500) DEFAULT NULL,
  `special_requests` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reader_id_idx` (`customer_id`),
  KEY `item_id_idx` (`item_id`),
  KEY `book_id` (`ship_address_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`ship_address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1025 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_placed`
--

LOCK TABLES `orders_placed` WRITE;
/*!40000 ALTER TABLE `orders_placed` DISABLE KEYS */;
INSERT INTO `orders_placed` VALUES (1001,'2011-11-19',NULL,'2019-11-25',2,'Sugar batter and Cream Cheese Icing',1,10.99,'ACCEPTED',1,12,'Minions Characters','Birthday','None','One of each minion type, if possible'),(1002,'2020-02-28','2020-03-03',NULL,4,'Fruity Pebbles',2,0,'PENDING',5,0,NULL,NULL,'N/A',NULL),(1003,'2020-02-28','2020-03-09',NULL,5,'Frozen Characters',3,0,'PENDING',6,24,NULL,NULL,'N/A',NULL),(1004,'2020-02-28','2020-02-29',NULL,6,'sugar',4,0,'PENDING',7,12,NULL,NULL,'',NULL),(1005,'2020-02-28','',NULL,7,'',5,0,'PENDING',8,0,NULL,NULL,'',NULL),(1006,'2020-02-28','',NULL,8,'',6,0,'PENDING',9,0,NULL,NULL,'',NULL),(1007,'2020-02-28','',NULL,9,'',7,0,'PENDING',10,0,NULL,NULL,'',NULL),(1008,'2020-02-28','',NULL,10,'',8,0,'PENDING',11,0,NULL,NULL,'',NULL),(1009,'2020-02-28','',NULL,11,'',9,0,'PENDING',12,0,NULL,NULL,'',NULL),(1010,'2020-02-28','',NULL,12,'',10,0,'PENDING',13,0,NULL,NULL,'',NULL),(1011,'2020-02-28','',NULL,13,'',11,0,'PENDING',14,0,NULL,NULL,'',NULL),(1012,'2020-02-29','',NULL,14,'',12,0,'PENDING',15,0,NULL,NULL,'',NULL),(1013,'2020-02-29','',NULL,15,'',13,0,'PENDING',16,0,NULL,NULL,'',NULL),(1014,'2020-02-29','',NULL,16,'',14,0,'PENDING',17,0,NULL,NULL,'',NULL),(1015,'2020-02-29','',NULL,17,'',15,0,'PENDING',18,0,NULL,NULL,'',NULL),(1016,'2020-03-10','2020-03-25',NULL,18,'None',16,0,'PENDING',19,12,NULL,NULL,'',NULL),(1017,'2020-03-10','2020-03-31',NULL,19,'jgkjgjhl',17,0,'PENDING',20,12,'khjgugkh`',NULL,NULL,NULL),(1018,'2020-03-10','2020-03-31',NULL,20,'jgkjgjhl',18,0,'PENDING',21,12,'khjgugkh`',NULL,NULL,NULL),(1019,'2020-03-10','2020-03-31',NULL,21,'jhkgjh',19,0,'PENDING',22,12,'lkjhglkh',NULL,NULL,NULL),(1020,'2020-03-10','2020-03-31',NULL,22,'khjglhk;j',20,0,'PENDING',23,12,'kjbglkgkl;.',NULL,'khjglkjlkhj',NULL),(1021,'2020-03-11','2020-03-31',NULL,24,NULL,21,0,'PENDING',25,12,'hjkgkjhj',NULL,'hjghjkj',NULL),(1022,'2020-03-11','2020-03-31',NULL,25,NULL,22,0,'PENDING',26,12,'jhgkhlhk',NULL,'khgkljh;',NULL),(1023,'2020-03-11','2020-03-31',NULL,26,NULL,23,0,'PENDING',27,12,'jhgkhlhk',NULL,'khgkljh;',NULL),(1024,'2020-03-11','2020-03-31',NULL,27,NULL,24,0,'PENDING',28,12,'jhgkhlhk',NULL,'khgkljh;',NULL);
/*!40000 ALTER TABLE `orders_placed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT 'standard',
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_id_idx` (`address_id`),
  CONSTRAINT `fk_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','user','user@user.com',1,'000-111-1234','User','Userman','standard',1),(2,'other','other','other@email.com',1,'000-222-3455','Other','Otherman','standard',1),(3,'admin','$2a$10$5NVjt2axRvPvxRMMPy5kUOvIVkz5VMoPHMdk51sMaX/hFpApcKwly','dgower83@gmail.com',1,'660-909-8500','Dianne','Gower','admin',1),(4,NULL,NULL,'sroach1028@gmail.com',NULL,'6606241479','Shaun','Roach','standard',1),(5,NULL,NULL,'sroach1028@gmail.com',NULL,'6606241479','Shaun','Roach','standard',1),(6,NULL,NULL,'sroach@email.com',NULL,'6606241479','Shaun','Roach','standard',1),(7,NULL,NULL,'',NULL,'','','','standard',1),(8,NULL,NULL,'',NULL,'','','','standard',1),(9,NULL,NULL,'',NULL,'','','','standard',1),(10,NULL,NULL,'',NULL,'','','','standard',1),(11,NULL,NULL,'',NULL,'','','','standard',1),(12,NULL,NULL,'',NULL,'','','','standard',1),(13,NULL,NULL,'',NULL,'','','','standard',1),(14,NULL,NULL,'',NULL,'','','','standard',1),(15,NULL,NULL,'',NULL,'','','','standard',1),(16,NULL,NULL,'',NULL,'','','','standard',1),(17,NULL,NULL,'',NULL,'','','','standard',1),(18,NULL,NULL,'sdlhghk@email',NULL,'4564567654','Shaun','Roach','standard',1),(19,NULL,NULL,'sroach@email.com',NULL,'6606241479','Shaun','Roach','standard',1),(20,NULL,NULL,'sroach@email.com',NULL,'6606241479','Shaun','Roach','standard',1),(21,NULL,NULL,'sroach@emai.com',NULL,'6606241479','Shaun','Roach','standard',1),(22,NULL,NULL,'sroach@emai.com',NULL,'6606241479','Shaun','Roach','standard',1),(24,NULL,NULL,'sroach@emai.com',NULL,'6606241479','Shaun','Roach','standard',1),(25,NULL,NULL,'sroach@emai.com',NULL,'6606241479','Shaun','Roach','standard',1),(26,NULL,NULL,'sroach@emai.com',NULL,'6606241479','Shaun','Roach','standard',1),(27,NULL,NULL,'sroach@emai.com',NULL,'6606241479','Shaun','Roach','standard',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-17 10:58:30
