CREATE DATABASE  IF NOT EXISTS `pet_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pet_shop`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: pet_shop
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `user_id` int NOT NULL,
                             `contact_name` varchar(255) DEFAULT NULL,
                             `phone` varchar(255) NOT NULL,
                             `detail_address` varchar(255) NOT NULL,
                             `city` varchar(255) NOT NULL,
                             `state` varchar(255) NOT NULL,
                             `is_deleted` varchar(1) DEFAULT '0',
                             `created_date` datetime(6) DEFAULT NULL,
                             `updated_date` datetime(6) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `idx_addresses_user` (`user_id`),
                             KEY `idx_addresses_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `user_id` int NOT NULL,
                        `created_date` datetime(6) DEFAULT NULL,
                        `updated_date` datetime(6) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uk_cart_user` (`user_id`),
                        KEY `idx_cart_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `cart_id` int NOT NULL,
                              `product_variant_id` int NOT NULL,
                              `quantity` int NOT NULL,
                              `is_deleted` varchar(1) DEFAULT '0',
                              `created_date` datetime(6) DEFAULT NULL,
                              `updated_date` datetime(6) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `idx_cart_items_cart` (`cart_id`),
                              KEY `idx_cart_items_variant` (`product_variant_id`),
                              KEY `idx_cart_items_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) NOT NULL,
                              `description` varchar(255) DEFAULT NULL,
                              `is_featured` varchar(1) DEFAULT '0',
                              `is_deleted` varchar(1) DEFAULT '0',
                              `created_date` datetime(6) DEFAULT NULL,
                              `updated_date` datetime(6) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `idx_categories_featured` (`is_featured`),
                              KEY `idx_categories_deleted` (`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Pet Food','Bao gồm các loại thức ăn khô, ướt, pate, snack cho chó mèo và các loại thú cưng khác.','0','0','2025-10-23 23:41:55.678000','2025-10-23 23:41:55.678000'),(2,'Pet Accessories','Dây dắt, vòng cổ, quần áo, nơ, mũ và các phụ kiện trang trí dễ thương cho thú cưng.','0','0','2025-10-23 23:42:17.631000','2025-10-23 23:42:17.631000'),(3,'Pet Toys','Các loại đồ chơi giúp thú cưng vận động, giải trí và phát triển trí tuệ như bóng, xương gặm, đồ chơi phát tiếng.','0','0','2025-10-23 23:42:31.429000','2025-10-23 23:42:31.429000'),(4,'Pet Houses & Cages','Chuồng, lồng, giường ngủ, nệm và nhà di động tiện lợi cho chó, mèo và thú nhỏ.','0','0','2025-10-23 23:45:08.693000','2025-10-23 23:45:08.693000');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invalidated_token`
--

DROP TABLE IF EXISTS `invalidated_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invalidated_token` (
                                     `id` varchar(255) NOT NULL,
                                     `expiry_time` datetime(6) DEFAULT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invalidated_token`
--

LOCK TABLES `invalidated_token` WRITE;
/*!40000 ALTER TABLE `invalidated_token` DISABLE KEYS */;
INSERT INTO `invalidated_token` VALUES ('0df62b81-5632-480a-b86f-a13cc8513529','2025-10-23 23:01:10.000000'),('3a72b73b-adef-4544-a8eb-673ea002163b','2025-10-25 20:31:16.000000'),('67c7b483-d909-460a-838c-b6d1d2a5e728','2025-10-25 19:01:40.000000'),('6e24b92c-8b3d-45f5-929e-9dcbba2834b6','2025-10-23 23:11:10.000000'),('7c4dfa5a-190d-4098-92b9-3cb78d35f6b2','2025-10-23 23:01:37.000000'),('a1dce9f6-2225-40cd-bb43-9ed75f4f08f5','2025-10-23 23:09:32.000000'),('a43cd87a-9c97-459c-9b31-d2fc6a3b7b08','2025-10-25 18:06:39.000000'),('d178694d-9bce-413a-992d-dcdc5e496513','2025-10-24 00:06:11.000000');
/*!40000 ALTER TABLE `invalidated_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `order_id` int NOT NULL,
                               `product_variant_id` int NOT NULL,
                               `quantity` int NOT NULL,
                               `unit_price` float NOT NULL,
                               `total_price` float NOT NULL,
                               `is_deleted` varchar(1) DEFAULT '0',
                               `created_date` datetime(6) DEFAULT NULL,
                               `updated_date` datetime(6) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `idx_order_items_order` (`order_id`),
                               KEY `idx_order_items_variant` (`product_variant_id`),
                               KEY `idx_order_items_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `orderCode` varchar(255) NOT NULL,
                          `user_id` int NOT NULL,
                          `total_amount` float NOT NULL,
                          `shipping_amount` float NOT NULL,
                          `discount_amount` float DEFAULT NULL,
                          `payment_method` varchar(255) NOT NULL,
                          `status` varchar(255) NOT NULL,
                          `is_deleted` varchar(1) DEFAULT '0',
                          `created_date` datetime(6) DEFAULT NULL,
                          `updated_date` datetime(6) DEFAULT NULL,
                          `order_code` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `uk_orders_code` (`orderCode`),
                          KEY `idx_orders_user` (`user_id`),
                          KEY `idx_orders_status` (`status`),
                          KEY `idx_orders_deleted` (`is_deleted`),
                          KEY `idx_orders_created` (`created_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `order_id` int NOT NULL,
                            `amount` float NOT NULL,
                            `payment_methods` varchar(255) NOT NULL,
                            `status` varchar(255) NOT NULL,
                            `provider_reference` varchar(255) NOT NULL,
                            `paid_at` date NOT NULL,
                            `is_deleted` varchar(1) DEFAULT '0',
                            `created_date` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `idx_payments_order` (`order_id`),
                            KEY `idx_payments_status` (`status`),
                            KEY `idx_payments_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
                              `name` varchar(255) NOT NULL,
                              `description` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `product_id` int NOT NULL,
                                  `image_url` varchar(255) NOT NULL,
                                  `position` int DEFAULT '0',
                                  `is_primary` int DEFAULT '0',
                                  `is_deleted` varchar(1) DEFAULT '0',
                                  `created_date` datetime(6) DEFAULT NULL,
                                  `updated_date` datetime(6) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `idx_images_product` (`product_id`),
                                  KEY `idx_images_position` (`product_id`,`position`),
                                  KEY `idx_images_primary` (`product_id`,`is_primary`),
                                  KEY `idx_images_deleted` (`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
INSERT INTO `product_images` VALUES (1,2,'https://res.cloudinary.com/di2a8fvuv/image/upload/v1761239125/petshop/product/petshop/product/2_1761239114173_0.jpg.jpg',1,1,'0','2025-10-24 00:05:26.843000','2025-10-24 00:08:07.451000'),(2,2,'https://res.cloudinary.com/di2a8fvuv/image/upload/v1761239127/petshop/product/petshop/product/2_1761239126882_1.jpg.jpg',2,0,'0','2025-10-24 00:05:28.374000','2025-10-24 00:05:28.374000'),(3,1,'https://res.cloudinary.com/di2a8fvuv/image/upload/v1761239586/petshop/product/petshop/product/1_1761239581264_0.webp.webp',1,1,'0','2025-10-24 00:13:07.417000','2025-10-24 00:13:18.508000'),(4,3,'https://res.cloudinary.com/di2a8fvuv/image/upload/v1761387407/petshop/product/petshop/product/3_1761387404548_0.webp.webp',1,1,'0','2025-10-25 17:16:48.485000','2025-10-25 17:17:03.189000');
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variants`
--

DROP TABLE IF EXISTS `product_variants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variants` (
                                    `id` int NOT NULL AUTO_INCREMENT,
                                    `product_id` int NOT NULL,
                                    `variant_name` varchar(255) NOT NULL,
                                    `weight` float DEFAULT NULL,
                                    `price` float DEFAULT NULL,
                                    `stock_quantity` int NOT NULL DEFAULT '0',
                                    `sold_quantity` int NOT NULL DEFAULT '0',
                                    `is_deleted` varchar(1) DEFAULT '0',
                                    `created_date` datetime(6) DEFAULT NULL,
                                    `updated_date` datetime(6) DEFAULT NULL,
                                    `product_image_id` int DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `idx_variants_product` (`product_id`),
                                    KEY `idx_variants_deleted` (`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variants`
--

LOCK TABLES `product_variants` WRITE;
/*!40000 ALTER TABLE `product_variants` DISABLE KEYS */;
INSERT INTO `product_variants` VALUES (1,2,'Whiskas Cá ngừ',85,18000,50,0,'0','2025-10-24 00:06:56.733000','2025-10-24 00:06:56.733000',1),(2,2,'Whiskas Gà',85,18000,50,0,'0','2025-10-24 00:07:19.010000','2025-10-24 00:07:19.010000',2),(3,1,'SmartHeart 1.5kg',1.5,140000,50,0,'0','2025-10-24 00:14:03.576000','2025-10-24 00:14:03.576000',3),(4,3,'Pedigree',25,50000,50,0,'0','2025-10-25 17:17:27.413000','2025-10-25 17:17:27.413000',4);
/*!40000 ALTER TABLE `product_variants` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_insert_variant` AFTER INSERT ON `product_variants` FOR EACH ROW BEGIN
    UPDATE products p
    SET
        p.stock_quantity = (
            SELECT COALESCE(SUM(v.stock_quantity), 0)
            FROM product_variants v
            WHERE v.product_id = NEW.product_id
              AND v.is_deleted = '0'
        ),
        p.sold_quantity = (
            SELECT COALESCE(SUM(v.sold_quantity), 0)
            FROM product_variants v
            WHERE v.product_id = NEW.product_id
              AND v.is_deleted = '0'
        )
    WHERE p.id = NEW.product_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_update_variant` AFTER UPDATE ON `product_variants` FOR EACH ROW BEGIN
    UPDATE products p
    SET
        p.stock_quantity = (
            SELECT COALESCE(SUM(v.stock_quantity), 0)
            FROM product_variants v
            WHERE v.product_id = NEW.product_id
              AND v.is_deleted = '0'
        ),
        p.sold_quantity = (
            SELECT COALESCE(SUM(v.sold_quantity), 0)
            FROM product_variants v
            WHERE v.product_id = NEW.product_id
              AND v.is_deleted = '0'
        )
    WHERE p.id = NEW.product_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_delete_variant` AFTER DELETE ON `product_variants` FOR EACH ROW BEGIN
    UPDATE products p
    SET
        p.stock_quantity = (
            SELECT COALESCE(SUM(v.stock_quantity), 0)
            FROM product_variants v
            WHERE v.product_id = OLD.product_id
              AND v.is_deleted = '0'
        ),
        p.sold_quantity = (
            SELECT COALESCE(SUM(v.sold_quantity), 0)
            FROM product_variants v
            WHERE v.product_id = OLD.product_id
              AND v.is_deleted = '0'
        )
    WHERE p.id = OLD.product_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `category_id` int DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `short_description` varchar(255) DEFAULT NULL,
                            `description` varchar(255) DEFAULT NULL,
                            `sold_quantity` int NOT NULL DEFAULT '0',
                            `stock_quantity` int NOT NULL DEFAULT '0',
                            `is_deleted` varchar(1) DEFAULT '0',
                            `is_featured` varchar(1) DEFAULT '0',
                            `created_date` datetime(6) DEFAULT NULL,
                            `updated_date` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `idx_products_category` (`category_id`),
                            KEY `idx_products_featured` (`is_featured`),
                            KEY `idx_products_deleted` (`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,'Thức ăn khô cho chó SmartHeart ','Hạt dinh dưỡng cao cấp','Hạt dinh dưỡng cao cấp cho chó trưởng thành, giúp lông mượt và xương chắc khỏe.',0,50,'0','1','2025-10-23 23:49:09.221000','2025-10-25 21:24:47.120000'),(2,0,'Pate cho mèo Whiskas','Thức ăn ướt hương cá ngừ','Thức ăn ướt hương cá ngừ giàu đạm, dễ tiêu hóa cho mèo.',0,100,'0','0','2025-10-23 23:49:52.422000','2025-10-25 17:56:04.693000'),(3,0,'Snack thưởng cho chó Pedigree','Snack mềm thơm ngon giúp tăng cường răng nướu và hệ tiêu hóa.','45000',0,50,'1','1','2025-10-25 17:15:45.888000','2025-10-25 21:24:55.708000'),(4,0,'Dây dắt chó cao su co giãn','Dây dắt bền chắc','Dây dắt bền chắc, có thể điều chỉnh độ dài, phù hợp cho mọi giống chó.',0,0,'0','1','2025-10-25 17:21:14.632000','2025-10-25 19:32:27.995000'),(5,2,'Vòng cổ có chuông cho mèo','Vòng cổ nhẹ','Vòng cổ nhẹ, điều chỉnh linh hoạt, có chuông nhỏ đáng yêu.',0,0,'0','0','2025-10-25 17:21:38.876000','2025-10-25 17:21:38.876000'),(6,1,'Áo thun cho chó mèo','Áo cotton co giãn','Áo cotton co giãn, dễ mặc, nhiều size cho thú cưng.',0,0,'0','1','2025-10-25 17:21:55.258000','2025-10-30 22:05:07.908000'),(7,3,'Xương cao su phát tiếng','Đồ chơi gặm dai','Đồ chơi gặm dai, giúp làm sạch răng và giảm stress cho chó.',0,0,'0','0','2025-10-25 17:22:13.402000','2025-10-25 17:22:13.402000'),(8,0,'Bóng chuông cho mèo','Quả bóng nhỏ có chuông','Quả bóng nhỏ có chuông bên trong kích thích mèo vận động.',0,0,'0','1','2025-10-25 17:22:32.417000','2025-10-25 19:32:27.652000'),(9,0,'Đồ chơi chuột giả','Chuột giả bằng vải mềm, di chuyển tự nhiên, kích thích bản năng săn mồi.','Chuột giả bằng vải mềm, di chuyển tự nhiên, kích thích bản năng săn mồi.',0,0,'0','1','2025-10-25 17:22:48.310000','2025-10-25 19:31:30.304000');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int NOT NULL,
                           `product_id` int NOT NULL,
                           `rating` smallint NOT NULL,
                           `comment` varchar(255) DEFAULT NULL,
                           `is_verified` smallint DEFAULT '0',
                           `is_deleted` varchar(1) DEFAULT '0',
                           `created_date` datetime(6) DEFAULT NULL,
                           `updated_date` datetime(6) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `idx_reviews_product` (`product_id`),
                           KEY `idx_reviews_user` (`user_id`),
                           KEY `idx_reviews_rating` (`product_id`,`rating`),
                           KEY `idx_reviews_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
                        `name` varchar(255) NOT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('CUSTOMER','Customer role'),('SHOP','Shop role');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permissions` (
                                    `role_name` varchar(255) NOT NULL,
                                    `permissions_name` varchar(255) NOT NULL,
                                    PRIMARY KEY (`role_name`,`permissions_name`),
                                    KEY `idx_permissions_name` (`permissions_name`),
                                    CONSTRAINT `fk_role_permissions_permission` FOREIGN KEY (`permissions_name`) REFERENCES `permission` (`name`) ON DELETE CASCADE,
                                    CONSTRAINT `fk_role_permissions_role` FOREIGN KEY (`role_name`) REFERENCES `role` (`name`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_user` (
                             `role_name` varchar(255) NOT NULL,
                             `user_id` int NOT NULL,
                             UNIQUE KEY `UKnjajel6a2q8tr36emb9l8vw7n` (`user_id`),
                             KEY `FKlaou0yym5spx4g7223d96ughs` (`role_name`),
                             CONSTRAINT `FKhvai2k29vlwpt9wod4sw4ghmn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                             CONSTRAINT `FKlaou0yym5spx4g7223d96ughs` FOREIGN KEY (`role_name`) REFERENCES `role` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_appointments`
--

DROP TABLE IF EXISTS `service_appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_appointments` (
                                        `id` int NOT NULL AUTO_INCREMENT,
                                        `service_id` int NOT NULL,
                                        `user_id` bigint NOT NULL,
                                        `name_pet` varchar(255) NOT NULL,
                                        `specie_pet` varchar(255) NOT NULL,
                                        `appointment_start` datetime(6) NOT NULL,
                                        `appointment_end` datetime(6) NOT NULL,
                                        `status` enum('CANCELED','COMPLETED','NO_SHOW','SCHEDULED') NOT NULL,
                                        `notes` text,
                                        `created_date` datetime(6) DEFAULT NULL,
                                        `updated_date` datetime(6) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `idx_appointments_service` (`service_id`),
                                        KEY `idx_appointments_user` (`user_id`),
                                        KEY `idx_appointments_status` (`status`),
                                        KEY `idx_appointments_start` (`appointment_start`),
                                        KEY `idx_appointments_date_range` (`appointment_start`,`appointment_end`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_appointments`
--

LOCK TABLES `service_appointments` WRITE;
/*!40000 ALTER TABLE `service_appointments` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` text NOT NULL,
                            `title` text NOT NULL,
                            `description` text NOT NULL,
                            `duration_minutes` int NOT NULL DEFAULT '30',
                            `price` decimal(12,2) DEFAULT '0.00',
                            `is_active` varchar(1) DEFAULT '1',
                            `create_date` datetime(6) DEFAULT NULL,
                            `update_date` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `idx_services_active` (`is_active`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Basic Grooming','Tắm rửa & chải lông cho thú cưng','Dịch vụ tắm rửa, sấy khô, chải lông, cắt móng và làm sạch tai giúp thú cưng sạch sẽ, thơm tho và thoải mái.',60,200000.00,'1','2025-10-23 22:57:28.103016','2025-10-23 23:39:00.942387'),(2,'Full Grooming','Cắt tỉa tạo kiểu toàn thân','Bao gồm tắm rửa, sấy lông, cắt tỉa tạo kiểu, vệ sinh tai, mài móng, và kiểm tra da lông cho thú cưng.',90,350000.00,'1','2025-10-23 22:58:07.516179','2025-10-23 22:58:07.516179'),(3,'Health Checkup','Khám sức khỏe định kỳ cho thú cưng','Bác sĩ thú y kiểm tra tổng quát các chỉ số sức khỏe, cân nặng, răng miệng, da lông và tim phổi.',30,150000.00,'1','2025-10-23 22:58:34.290574','2025-10-23 22:58:34.290574'),(4,'Vaccination','Tiêm phòng định kỳ','Cung cấp các loại vắc-xin phòng bệnh thông thường như dại, care, parvo, cúm mèo... giúp thú cưng khỏe mạnh.',20,100000.00,'1','2025-10-23 23:40:46.763101','2025-10-23 23:40:46.763101'),(5,'Pet Boarding','Lưu trú cho thú cưng theo ngày','Dịch vụ trông giữ thú cưng 24/7 trong môi trường sạch sẽ, an toàn, có điều hòa và khu vui chơi riêng.',1440,250000.00,'1','2025-10-23 23:41:07.735163','2025-10-23 23:41:07.735163'),(6,'Pet Spa','Massage & thư giãn cho thú cưng','Dịch vụ massage nhẹ nhàng giúp giảm căng thẳng, kích thích lưu thông máu, cải thiện tâm trạng cho thú cưng.',45,180000.00,'1','2025-10-23 23:41:25.797581','2025-10-23 23:41:25.797581');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `email` varchar(100) NOT NULL,
                         `password` varchar(100) NOT NULL,
                         `username` varchar(100) NOT NULL,
                         `full_name` varchar(100) NOT NULL,
                         `phone` varchar(100) NOT NULL,
                         `role_name` varchar(255) DEFAULT NULL,
                         `is_deleted` varchar(1) DEFAULT '0',
                         `created_date` datetime(6) DEFAULT NULL,
                         `updated_date` datetime(6) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `uk_users_email` (`email`),
                         UNIQUE KEY `uk_users_username` (`username`),
                         KEY `idx_users_role` (`role_name`),
                         KEY `idx_users_deleted` (`is_deleted`),
                         CONSTRAINT `fk_users_role` FOREIGN KEY (`role_name`) REFERENCES `role` (`name`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@gmail.com','$2a$10$zX6ci0/cOMd3sk4ArDE3uOespi1FNPUDN3PfaJNAYHCwtuQUABmLe','admin','Admin','0123456789','SHOP','0','2025-10-23 22:46:01.835000','2025-10-23 22:46:01.835000'),(2,'hoangvit2k4@gmail.com','$2a$10$ggeSUe4GHzGS2XxQ4dc3C.QGa9IP0MOupt4SR3I15DFXzj/TmeD4.','customer','Customer Test','0987654321','CUSTOMER','0','2025-10-23 22:46:01.914000','2025-10-23 22:46:01.914000');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pet_shop'
--

--
-- Dumping routines for database 'pet_shop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-30 22:16:42
