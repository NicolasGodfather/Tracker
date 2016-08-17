CREATE DATABASE  IF NOT EXISTS `task_tracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `task_tracker`;

DROP TABLE IF EXISTS `categories`;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;

CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `workflow_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_c_workflow_id_idx` (`workflow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `categories` WRITE;
ALTER TABLE `categories` DISABLE KEYS;
INSERT INTO `categories` VALUES (1,'Project','2016-08-17 08:38:10','2016-08-17 08:38:10',1),
(2,'Task','2016-08-17 08:38:10','2016-08-17 08:38:10',2),(3,'Bug','2016-08-17 08:38:10','2016-08-17 08:38:10',3);
ALTER TABLE `categories` ENABLE KEYS ;
UNLOCK TABLES;

DROP TABLE IF EXISTS `comments`;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment` text,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_task_id_idx` (`task_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_task_c_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_c_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `comments` WRITE;
ALTER TABLE `comments` DISABLE KEYS;
ALTER TABLE `comments` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `roles`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `roles` WRITE;
ALTER TABLE `roles` DISABLE KEYS;
INSERT INTO `roles` VALUES (1,'admin','2014-10-30 23:39:01','2014-10-30 23:39:01'),
  (2,'project manager','2014-10-30 23:39:01','2014-10-30 23:39:01'),(3,'analyst','2014-10-30 23:39:01','2014-10-30 23:39:01'),
  (4,'developer','2014-10-30 23:39:01','2014-10-30 23:39:01'),(5,'tester','2014-10-30 23:39:01','2014-10-30 23:39:01');
ALTER TABLE `roles` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `statuses`;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `statuses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `statuses` WRITE;
ALTER TABLE `statuses` DISABLE KEYS;
INSERT INTO `statuses` VALUES (1,'New','2014-10-17 19:56:01','2014-10-17 19:56:01'),(2,'In progress','2014-10-17 19:56:01','2014-10-17 19:56:01'),(3,'Opened','2014-10-17 19:56:01','2014-10-17 19:56:01'),(4,'Closed','2014-10-17 19:56:01','2014-10-17 19:56:01'),(5,'Finished','2014-10-17 19:56:01','2014-10-17 19:56:01'),(6,'Feedback','2014-10-17 19:56:01','2014-10-17 19:56:01'),(7,'Check','2014-10-17 19:56:01','2014-10-17 19:56:01'),(8,'Fixed','2014-10-17 19:56:01','2014-10-17 19:56:01');
ALTER TABLE `statuses` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `tasks`;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` text,
  `parent_id` int(11) DEFAULT '0',
  `status_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `deadline` datetime DEFAULT NULL,
  `creator_id` int(11) NOT NULL,
  `assignee_id` int(11) NOT NULL,
  `workflow_id` int(11) NOT NULL,
  `progress` int(11) DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_status_id_idx` (`status_id`),
  KEY `fk_category_id_idx` (`category_id`),
  KEY `fk_creator_id_idx` (`creator_id`),
  KEY `fk_assignee_id_idx` (`assignee_id`),
  KEY `fk_workflow_id_idx` (`workflow_id`),
  CONSTRAINT `fk_assignee_id` FOREIGN KEY (`assignee_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_status_id` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_workflow_id` FOREIGN KEY (`workflow_id`) REFERENCES `workflows` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;


LOCK TABLES `tasks` WRITE;
ALTER TABLE `tasks` DISABLE KEYS;
ALTER TABLE `tasks` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `users`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `users` WRITE;
ALTER TABLE `users` DISABLE KEYS;
INSERT INTO `users` VALUES (1,'root','root','System','Admin','doctorrokter@gmail.com',NULL,'2014-10-17 20:06:27','2014-10-17 20:06:27'),(2,'test','test','Test','User',NULL,NULL,'2014-10-18 10:07:18','2014-10-18 10:07:18'),(3,'doctorrokter','root','Mikhail','Chachkouski','doctorrokter@gmail.com','375259092555','2014-10-31 00:13:27','2014-10-31 00:13:27'),(11,'metalhead','p@ssw0rd','Mike','Oldfield','doctorrokter@gmail.com','375259092555','2014-11-07 18:57:45','2014-11-07 18:57:45');
ALTER TABLE `users` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `users_roles`;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `fk_users_roles_1_idx` (`user_id`),
  KEY `fk_users_roles_2_idx` (`role_id`),
  CONSTRAINT `fk_users_roles_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_users_roles_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `users_roles` WRITE;
ALTER TABLE `users_roles` DISABLE KEYS;
INSERT INTO `users_roles` VALUES (2,5),(3,4),(1,1),(11,2),(11,3);
ALTER TABLE `users_roles` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `workflows`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `workflows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `workflows` WRITE;
ALTER TABLE `workflows` DISABLE KEYS;
INSERT INTO `workflows` VALUES (1,'Project workflow','2014-10-17 08:49:52','2014-10-17 08:49:52'),(2,'Task workflow','2014-10-17 08:49:52','2014-10-17 08:49:52'),(3,'Bug workflow','2014-10-17 08:49:52','2014-10-17 08:49:52');
ALTER TABLE `workflows` ENABLE KEYS;
UNLOCK TABLES;

DROP TABLE IF EXISTS `workflows_statuses`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `workflows_statuses` (
  `workflow_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  KEY `fk_workflow_w_id_idx` (`workflow_id`),
  KEY `fk_status_w_id_idx` (`status_id`),
  CONSTRAINT `fk_status_w_id` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_workflow_w_id` FOREIGN KEY (`workflow_id`) REFERENCES `workflows` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
SET character_set_client = @saved_cs_client;

LOCK TABLES `workflows_statuses` WRITE;
ALTER TABLE `workflows_statuses` DISABLE KEYS;
INSERT INTO `workflows_statuses` VALUES (1,2),(1,3),(1,4),(2,1),(2,2),(2,5),(2,6),(2,7),(3,1),(3,2),(3,8),(3,6),(3,7);
ALTER TABLE `workflows_statuses` ENABLE KEYS;
UNLOCK TABLES;
SET TIME_ZONE=@OLD_TIME_ZONE;
