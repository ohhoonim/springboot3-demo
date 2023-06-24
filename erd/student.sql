DROP TABLE  if exists student;
CREATE TABLE `student` (
  `student_id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
);

DROP TABLE  if exists score;
CREATE TABLE `score` (
  `score_id` bigint(20) NOT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`score_id`,`student_id`),
  KEY `score_FK` (`student_id`),
  CONSTRAINT `score_FK` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ;