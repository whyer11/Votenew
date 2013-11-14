create database sbpms;

use sbpms;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `e_mail` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `report_to` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'ROOT','202cb962ac59075b964b07152d234b70','123@123.com','SUP','SUP'),(2,'SS','202cb962ac59075b964b07152d234b70','SS@SS.com','SS','SS');
UNLOCK TABLES;

