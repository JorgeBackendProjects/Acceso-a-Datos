CREATE DATABASE  IF NOT EXISTS `reservas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reservas`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: reservas
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `idTrayecto` int DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `idTrayecto_idx` (`idTrayecto`),
  CONSTRAINT `idTrayecto66` FOREIGN KEY (`idTrayecto`) REFERENCES `trayecto` (`idTrayecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('1111111SS','CARMEN','carmen@hotmail.com',NULL,NULL),('12345677J','Hugo','hugo@gmail.com','1111112',NULL),('12345678M','VICENTE','vicente@gmail.com',NULL,NULL),('42345643K','Hector','hector@hotmail.com','',NULL),('42665643K','Paula','paula@hotmail.com','',NULL),('45123434K','Jorge','jorgemugar12@hotmail.com','000000',NULL),('45124434K','JORGE','JORGEMUGAR12@HOTMAIL.COM',NULL,NULL),('45133434K','Cristian','cristian@hotmail.com',NULL,NULL),('45133664K','Iván','iván@hotmail.com',NULL,NULL),('45162743K','Monica','monica@hotmail.com','',NULL),('45345544K','JOSE','jose@hotmail.com','000000',NULL),('47133664K','Pedrito','pedrito@hotmail.com',NULL,NULL),('47153664K','Manolo','manolo@hotmail.com',NULL,NULL),('47545544K','Ylenia','ylenia@hotmail.com','023400',NULL),('66677788K','JESUS','jesus@gmail.com','9090',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor` (
  `idConductor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idConductor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
INSERT INTO `conductor` VALUES (1,'JORGITO');
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacion`
--

DROP TABLE IF EXISTS `estacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estacion` (
  `nombreEstacion` varchar(45) NOT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombreEstacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacion`
--

LOCK TABLES `estacion` WRITE;
/*!40000 ALTER TABLE `estacion` DISABLE KEYS */;
INSERT INTO `estacion` VALUES ('Estacion Lario','Malaga'),('La Papeleta','Suizeland'),('La Primitiva','Barcelona'),('La Vela','Portland'),('Paco Canela','Algeciras'),('REVEC','Suiza'),('RUCUCU','Ámsterdam'),('RUSSS','Rusia'),('San Fronte','Ceuta'),('San Sebastian','Sevilla');
/*!40000 ALTER TABLE `estacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediotransporte`
--

DROP TABLE IF EXISTS `mediotransporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mediotransporte` (
  `idTransporte` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `idConductor` int DEFAULT NULL,
  PRIMARY KEY (`idTransporte`),
  KEY `idConductor_idx` (`idConductor`),
  CONSTRAINT `idConductor` FOREIGN KEY (`idConductor`) REFERENCES `conductor` (`idConductor`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediotransporte`
--

LOCK TABLES `mediotransporte` WRITE;
/*!40000 ALTER TABLE `mediotransporte` DISABLE KEYS */;
INSERT INTO `mediotransporte` VALUES (13,'Autocar',NULL),(14,'Autocar',NULL),(15,'Autocar',NULL),(16,'Autobus',NULL),(17,'Autobus',NULL),(18,'BlaBlaCar',NULL),(19,'BlaBlaCar',NULL);
/*!40000 ALTER TABLE `mediotransporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idPago` int NOT NULL AUTO_INCREMENT,
  `numeroTarjeta` varchar(25) DEFAULT NULL,
  `pin` int DEFAULT NULL,
  `idTrayecto` int DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idPago`),
  KEY `idTrayecto_idx` (`idTrayecto`),
  KEY `dni_idx` (`dni`),
  CONSTRAINT `dni` FOREIGN KEY (`dni`) REFERENCES `cliente` (`dni`),
  CONSTRAINT `idTrayecto` FOREIGN KEY (`idTrayecto`) REFERENCES `trayecto` (`idTrayecto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (5,'2433525132',4546,NULL,'12345677J'),(6,'7777771',9090,18,'12345677J'),(7,'111111111',1414,18,'12345677J'),(8,'23454363',1111,19,'12345677J');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trayecto`
--

DROP TABLE IF EXISTS `trayecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trayecto` (
  `idTrayecto` int NOT NULL AUTO_INCREMENT,
  `fecha` varchar(13) DEFAULT NULL,
  `horaSalida` varchar(10) DEFAULT NULL,
  `horaLlegada` varchar(10) DEFAULT NULL,
  `duracion` varchar(10) DEFAULT NULL,
  `precio` varchar(5) DEFAULT NULL,
  `idTransporte` int DEFAULT NULL,
  `estacionOrigen` varchar(45) DEFAULT NULL,
  `estacionLlegada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTrayecto`),
  KEY `idTransporte_idx` (`idTransporte`),
  KEY `estacionOrigen_idx` (`estacionOrigen`),
  KEY `estacionLlegada_idx` (`estacionLlegada`),
  CONSTRAINT `estacionLlegada` FOREIGN KEY (`estacionLlegada`) REFERENCES `estacion` (`nombreEstacion`),
  CONSTRAINT `estacionOrigen` FOREIGN KEY (`estacionOrigen`) REFERENCES `estacion` (`nombreEstacion`),
  CONSTRAINT `idTransporte` FOREIGN KEY (`idTransporte`) REFERENCES `mediotransporte` (`idTransporte`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trayecto`
--

LOCK TABLES `trayecto` WRITE;
/*!40000 ALTER TABLE `trayecto` DISABLE KEYS */;
INSERT INTO `trayecto` VALUES (15,'07/01/2017','20:00','21:15','1.15','10',13,'La Vela','REVEC'),(16,'31/12/2017','21:00','23:15','2.15','20',14,'La Papeleta','RUCUCU'),(17,'31/12/2017','21:00','23:15','2.15','20',15,'La Primitiva','RUSSS'),(18,'07/01/2017','21:00','23:00','2','14.9',15,'La Vela','REVEC'),(19,'20/02/2023','21:00','23:00','2','15.00',17,'Paco Canela','San Sebastian'),(20,'20/02/2023','14:00','15:15','1.15','10.50',19,'Paco Canela','Estacion Lario');
/*!40000 ALTER TABLE `trayecto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-21 11:03:21
