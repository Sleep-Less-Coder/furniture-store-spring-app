-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: furniture_store
-- ------------------------------------------------------
-- Server version	5.6.35

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category` varchar(255) NOT NULL,
  `product_description` text NOT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_price` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'chair','My Kenzo Side Chair adds contemporary flair with a slingback style and open chair design. The layer of Bob-O-Pedic Memory Foam provides the ultimate comfort while you dine in style.','kenzo_side_chair.jpg','Kenzo Side Chair',139),(2,'chair','You won\'t believe the value of my Woodmark Side Chair. With its beautiful cherry finish, traditional styling, and stunning design on the back, this dining chair is top quality that can\'t be beat!','woodmark_side_chair.jpg','Woodmark Side Chair',69),(3,'chair','My Bombay Side Chair has great style and great comfort! My Bob-O-Pedic Memory Foam makes the seating super comfy and the upholstered seat is covered in plush fabric. The dark rustic bronze finish enhances the look and the chair back design completes the l','bombay_side_chair.png','Bombay Side Chair',79),(4,'table','Don\'t miss out on my Woodmark Dining Table! This traditional style has all of the detailing you typically see on high-end furniture. Complete with an elegant cherry finish, cherry veneers, and Asian hardwood solids, this table boasts top quality and value','woodmark_table.jpg','Woodmark Table',279),(5,'table','Transform your living room with my Rivet End Table! This charming table brings a vintage style all its own, with an artfully weathered solid planked top and heavy gauge angle iron frame. A rustic beauty for a great value!','rivet_end_table.jpg','Rivet End Table',139);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-22 13:57:35
