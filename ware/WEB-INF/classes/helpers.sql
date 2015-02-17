SET foreign_key_checks = 0;
TRUNCATE QuizTest;
SET foreign_key_checks = 1;

DROP DATABASE AnatomicalAtlas;
SET GLOBAL max_allowed_packet=1073741824;
CREATE DATABASE AnatomicalAtlas;