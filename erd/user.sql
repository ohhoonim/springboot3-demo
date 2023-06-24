-- testdb.`user` definition
DROP TABLE  if exists user;
CREATE TABLE `user` (
  `user_id` binary(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `user` (user_id, email, name, password) VALUES(0x32E77ACC06294B09973693DFCCFDAD40, 'matthew@ohhoonim.dev', 'matthew', '$2a$10$60cjRo2ZCK9lU4m6xSH6/uYCklNg8bv7nRrpXi.HMUgvxSYnLKFwa');
