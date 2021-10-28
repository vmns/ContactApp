CREATE TABLE `capp`.`new_table` (
  `contactId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NULL,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `remarks` VARCHAR(45) NULL,
  PRIMARY KEY (`contactId`),
  INDEX `user_fk_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`userId`)
    REFERENCES `capp`.`capp_user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);