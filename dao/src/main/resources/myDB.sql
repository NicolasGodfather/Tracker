# CREATE DATABASE  IF NOT EXISTS `tracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
# USE `tracker`;
#
# DROP TABLE IF EXISTS `users`;
# SET @saved_cs_client     = @@character_set_client;
# SET character_set_client = utf8;
# CREATE TABLE `users` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `login` varchar(45) NOT NULL,
#   `password` varchar(255) NOT NULL,
#   `name` varchar(45) NOT NULL,
#   `surname` varchar(45) NOT NULL,
#   `email` varchar(100) DEFAULT NULL,
#   `skype` varchar(20) DEFAULT NULL,
#   `created_in` datetime NOT NULL,
#   `updated_in` datetime NOT NULL,
#   PRIMARY KEY (`id`),
#   UNIQUE KEY `login_UNIQUE` (`login`)
# ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
# SET character_set_client = @saved_cs_client;
#
# LOCK TABLES `users` WRITE;
# ALTER TABLE `users` DISABLE KEYS;
# INSERT INTO `users` VALUES
#   (1,'root','root','System','Admin','godfather6worlds@gmail.com','nico90','2016-08-17 20:06:27','2016-08-17 20:06:27'),
#   (2,'test','test','Test','User',NULL,NULL,'2016-08-18 10:07:18','2016-08-18 10:07:18'),
#   (3,'nico','root','Nicolas','Asinovich','nicolas.asinovich@gmail.com','micolasman','2016-08-19 00:13:27','2016-08-19 00:13:27'),
#   (15,'metalgod','pass','Mike','Mouse','nicolas.asinovich@gmail.com','fit34','2016-08-19 18:57:45','2016-08-19 18:57:45');
# ALTER TABLE `users` ENABLE KEYS;
# UNLOCK TABLES;
