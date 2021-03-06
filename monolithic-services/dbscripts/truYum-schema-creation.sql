-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `truyum` DEFAULT CHARACTER SET utf8 ;
USE `truyum` ;

-- -----------------------------------------------------
-- Table `truyum`.`menu_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`menu_item` (
  `me_id` INT(11) NOT NULL AUTO_INCREMENT,
  `me_name` VARCHAR(100) NULL DEFAULT NULL,
  `me_price` DECIMAL(8,2) NOT NULL DEFAULT 0,
  `me_active` TINYINT(1) NULL DEFAULT NULL,
  `me_date_of_launch` DATE NULL DEFAULT NULL,
  `me_category` VARCHAR(45) NULL DEFAULT NULL,
  `me_free_delivery` TINYINT(1) NULL DEFAULT NULL,
  `me_image_link` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`me_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL DEFAULT NULL,
  `us_password` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`cart` (
  `ct_id` INT(3) NOT NULL AUTO_INCREMENT,
  `ct_us_id` INT(3) NULL DEFAULT NULL,
  `ct_pr_id` INT(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ct_id`),
  INDEX `ct_us_fk_idx` (`ct_us_id` ASC),
  INDEX `ct_pr_fk_idx` (`ct_pr_id` ASC),
  CONSTRAINT `ct_pr_fk`
    FOREIGN KEY (`ct_pr_id`)
    REFERENCES `truyum`.`menu_item` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ct_us_fk`
    FOREIGN KEY (`ct_us_id`)
    REFERENCES `truyum`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`user_role` (
  `ur_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT(11) NULL DEFAULT NULL,
  `ur_ro_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_us_id_idx` (`ur_us_id` ASC),
  INDEX `fk_ro_id_idx` (`ur_ro_id` ASC),
  CONSTRAINT `fk_ro_id`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `truyum`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_us_id`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `truyum`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
