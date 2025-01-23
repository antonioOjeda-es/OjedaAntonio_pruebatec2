CREATE DATABASE  IF NOT EXISTS `ciudadano_turno` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `ciudadano_turno`;

-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ciudadano_turno
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudadano` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudadano`
--

LOCK TABLES `ciudadano` WRITE;
/*!40000 ALTER TABLE `ciudadano` DISABLE KEYS */;
INSERT INTO `ciudadano` VALUES (1,'Juan','Pérez','Calle Falsa 123'),(2,'María','Gómez','Avenida Siempre Viva 456'),(3,'Carlos','López','Boulevard de los Sueños 789'),(4,'Ana','Martínez','Calle de la Paz 101'),(5,'Luis','Hernández','Calle del Sol 202'),(6,'Laura','Ramírez','Calle de la Luna 303'),(7,'Pedro','Torres','Calle del Río 404'),(8,'Sofía','Vásquez','Calle del Mar 505'),(9,'Javier','Morales','Calle de la Montaña 606'),(10,'Claudia','Jiménez','Calle del Viento 707'),(11,'Diego','Castillo','Calle del Fuego 808'),(12,'Valeria','Rojas','Calle del Agua 909'),(13,'Andrés','Salazar','Calle del Bosque 111'),(14,'Isabel','Cruz','Calle del Cielo 222'),(15,'Fernando','Mendoza','Calle del Horizonte 333'),(16,'Gabriela','Ponce','Calle del Océano 444'),(17,'Ricardo','Soto','Calle del Valle 555'),(18,'Patricia','Cordero','Calle del Jardín 666'),(19,'Samuel','Núñez','Calle del Desierto 777'),(20,'Natalia','Cáceres','Calle del Parque 888'),(21,'Hugo','González','Calle de la Esperanza 999'),(22,'Mónica','Alvarez','Calle de la Libertad 1001'),(23,'Arturo','Bermúdez','Calle de la Amistad 1102'),(24,'Silvia','Pizarro','Calle de la Alegría 1203'),(25,'Rafael','Ceballos','Calle de la Unidad 1304'),(26,'Carmen','Salinas','Calle de la Verdad 1405'),(27,'Alberto','Maldonado','Calle de la Justicia 1506'),(28,'Verónica','Cruz','Calle de la Paz 1607'),(29,'Esteban','Rivas','Calle de la Fe 1708'),(30,'Lucía','Sánchez','Calle de la Esperanza 1809'),(31,'Jorge','García','Calle de la Sabiduría 1910'),(32,'Teresa','Lara','Calle de la Fuerza 2011'),(33,'Felipe','Mora','Calle de la Luz 2112'),(34,'Clara','Pérez','Calle de la Vida 2213'),(35,'Oscar','Ríos','Calle de la Historia 2314'),(36,'Nora','Vega','Calle de la Cultura 2415'),(37,'Emilio','Cruz','Calle de la Innovación 2516'),(38,'Patricia','Salas','Calle de la Creatividad 2617'),(39,'Santiago','Cano','Calle de la Naturaleza 2718'),(40,'Mariana','Pérez','Calle de la Esperanza 2819');
/*!40000 ALTER TABLE `ciudadano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigoTurno` int(11) NOT NULL,
  `estado` enum('EN_ESPERA','YA_ATENDIDO') DEFAULT NULL,
  `fecha` datetime(6) NOT NULL,
  `tramite` enum('DUDAS','ENTREGA_DOCUMENTACION','OTRAS_CONSULTAS','PRESENTAR_DECLARACION','PRESENTAR_DECLARACION_RENTA','RECLAMACIONES') NOT NULL,
  `ciudadano_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4sfacq920yn3mqnjhs0ff1ggp` (`ciudadano_id`),
  CONSTRAINT `FK4sfacq920yn3mqnjhs0ff1ggp` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,12345,'EN_ESPERA','2024-01-15 10:00:00.000000','PRESENTAR_DECLARACION_RENTA',1),(2,23456,'YA_ATENDIDO','2024-02-20 11:30:00.000000','DUDAS',2),(3,34567,'EN_ESPERA','2024-03-05 09:00:00.000000','ENTREGA_DOCUMENTACION',3),(4,45678,'YA_ATENDIDO','2024-04-10 14:00:00.000000','PRESENTAR_DECLARACION',4),(5,56789,'EN_ESPERA','2024-05-25 15:45:00.000000','RECLAMACIONES',5),(6,67890,'YA_ATENDIDO','2024-06-30 16:30:00.000000','OTRAS_CONSULTAS',6),(7,78901,'EN_ESPERA','2024-07-15 10:15:00.000000','PRESENTAR_DECLARACION_RENTA',7),(8,89012,'YA_ATENDIDO','2024-08-20 11:00:00.000000','DUDAS',8),(9,90123,'EN_ESPERA','2024-09-05 09:30:00.000000','ENTREGA_DOCUMENTACION',9),(10,12346,'YA_ATENDIDO','2024-10-10 14:15:00.000000','PRESENTAR_DECLARACION',10),(11,23457,'EN_ESPERA','2024-11-25 15:00:00.000000','RECLAMACIONES',11),(12,34568,'YA_ATENDIDO','2024-12-30 16:45:00.000000','OTRAS_CONSULTAS',12),(13,45679,'EN_ESPERA','2025-01-15 10:00:00.000000','PRESENTAR_DECLARACION_RENTA',13),(14,56780,'YA_ATENDIDO','2025-02-20 11:30:00.000000','DUDAS',14),(15,67891,'EN_ESPERA','2025-03-05 09:00:00.000000','ENTREGA_DOCUMENTACION',15),(16,78902,'YA_ATENDIDO','2025-04-10 14:00:00.000000','PRESENTAR_DECLARACION',16),(17,89013,'EN_ESPERA','2025-05-25 15:45:00.000000','RECLAMACIONES',17),(18,90124,'YA_ATENDIDO','2025-06-30 16:30:00.000000','OTRAS_CONSULTAS',18),(19,12347,'EN_ESPERA','2025-07-15 10:15:00.000000','PRESENTAR_DECLARACION_RENTA',19),(20,23458,'YA_ATENDIDO','2025-08-20 11:00:00.000000','DUDAS',20),(21,34569,'EN_ESPERA','2025-09-05 09:30:00.000000','ENTREGA_DOCUMENTACION',21),(22,45680,'YA_ATENDIDO','2025-10-10 14:15:00.000000','PRESENTAR_DECLARACION',22),(23,56781,'EN_ESPERA','2025-11-25 15:00:00.000000','RECLAMACIONES',23),(24,67892,'YA_ATENDIDO','2025-12-30 16:45:00.000000','OTRAS_CONSULTAS',24),(25,78903,'EN_ESPERA','2024-01-20 10:00:00.000000','PRESENTAR_DECLARACION_RENTA',25),(26,89014,'YA_ATENDIDO','2024-02-25 11:30:00.000000','DUDAS',26),(27,90125,'EN_ESPERA','2024-03-10 09:00:00.000000','ENTREGA_DOCUMENTACION',27),(28,12348,'YA_ATENDIDO','2024-04-15 14:00:00.000000','PRESENTAR_DECLARACION',28),(29,23459,'EN_ESPERA','2024-05-30 15:45:00.000000','RECLAMACIONES',29),(30,34570,'YA_ATENDIDO','2024-06-05 16:30:00.000000','OTRAS_CONSULTAS',30),(31,45681,'EN_ESPERA','2024-07-20 10:15:00.000000','PRESENTAR_DECLARACION_RENTA',31),(32,56782,'YA_ATENDIDO','2024-08-25 11:00:00.000000','DUDAS',32),(33,67893,'EN_ESPERA','2024-09-10 09:30:00.000000','ENTREGA_DOCUMENTACION',33),(34,78904,'YA_ATENDIDO','2024-10-15 14:15:00.000000','PRESENTAR_DECLARACION',34),(35,89015,'EN_ESPERA','2024-11-30 15:00:00.000000','RECLAMACIONES',35),(36,90126,'YA_ATENDIDO','2024-12-05 16:45:00.000000','OTRAS_CONSULTAS',36),(37,12349,'EN_ESPERA','2025-01-20 10:00:00.000000','PRESENTAR_DECLARACION_RENTA',37),(38,23460,'YA_ATENDIDO','2025-02-25 11:30:00.000000','DUDAS',38),(39,34571,'EN_ESPERA','2025-03-10 09:00:00.000000','ENTREGA_DOCUMENTACION',39),(40,45682,'YA_ATENDIDO','2025-04-15 14:00:00.000000','PRESENTAR_DECLARACION',40);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-23 10:40:27
