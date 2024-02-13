CREATE TABLE IF NOT EXISTS `securitytest`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `enabled` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `securitytest`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


INSERT INTO `securitytest`.`authorities` VALUES (NULL, 'gugu', 'write');
INSERT INTO `securitytest`.`users` VALUES (NULL, 'gugu', '1234', '1');