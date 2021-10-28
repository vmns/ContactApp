CREATE TABLE `capp`.`capp_user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `loginName` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `role` INT(1) NOT NULL DEFAULT 2,
  `loginStatus` INT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `loginName_UNIQUE` (`loginName` ASC) VISIBLE);