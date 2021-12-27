-- MySQL dump 10.13  Distrib 8.0.27, for macos11.6 (arm64)
--
-- Host: localhost    Database: dealership
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'Daiana'),(2,'Denis'),(3,'Alex'),(4,'Mara');
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comenzi`
--

DROP TABLE IF EXISTS `comenzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comenzi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `cantitate` int NOT NULL,
  `status` varchar(255) NOT NULL,
  `id_masina` int NOT NULL,
  `id_client` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comenzi`
--

LOCK TABLES `comenzi` WRITE;
/*!40000 ALTER TABLE `comenzi` DISABLE KEYS */;
INSERT INTO `comenzi` VALUES (1,'2021-12-27 17:36:27',1,'CONFIRMAT',1,1),(2,'2021-12-27 00:00:00',1,'IN_ASTEPTARE',2,2),(3,'1970-01-20 00:00:00',1,'IN_ASTEPTARE',2,2),(4,'2021-12-27 00:00:00',1,'IN_ASTEPTARE',2,2),(5,'2021-12-27 19:22:21',1,'IN_ASTEPTARE',2,2),(6,'2021-12-27 19:40:06',2,'ANULAT',1,3),(7,'2021-12-27 19:40:23',2,'ANULAT',1,3);
/*!40000 ALTER TABLE `comenzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masini`
--

DROP TABLE IF EXISTS `masini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `masini` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) NOT NULL,
  `an` int NOT NULL,
  `kilometraj` float NOT NULL,
  `pret` float NOT NULL,
  `culoare` varchar(255) NOT NULL,
  `descriere` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masini`
--

LOCK TABLES `masini` WRITE;
/*!40000 ALTER TABLE `masini` DISABLE KEYS */;
INSERT INTO `masini` VALUES (1,'Mercedes',2018,100000,30000,'alba','A-class 1.4 150cp benzina'),(2,'BMW',2019,80000,40000,'negru','X1 2.0 170cp diesel'),(3,'Audi',2020,5000,35000,'albastru','A3 1.6 160cp');
/*!40000 ALTER TABLE `masini` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-27 19:58:59
