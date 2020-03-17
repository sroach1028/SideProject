-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sideproject
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sideproject` ;

-- -----------------------------------------------------
-- Schema sideproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sideproject` DEFAULT CHARACTER SET utf8 ;
USE `sideproject` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(200) NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zip` VARCHAR(45) NULL,
  `country_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(200) NULL,
  `password` VARCHAR(200) NULL,
  `email` VARCHAR(200) NOT NULL,
  `address_id` INT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL DEFAULT 'standard',
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_id_idx` (`address_id` ASC),
  CONSTRAINT `fk_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(200) NOT NULL,
  `image_one` VARCHAR(200) NULL,
  `image_two` VARCHAR(200) NULL,
  `image_three` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orders_placed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orders_placed` ;

CREATE TABLE IF NOT EXISTS `orders_placed` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_placed` VARCHAR(50) NULL,
  `date_requested` VARCHAR(45) NULL,
  `date_fulfilled` VARCHAR(50) NULL,
  `customer_id` INT NULL,
  `ingredients_specified` VARCHAR(500) NULL,
  `ship_address_id` INT NULL,
  `price` DOUBLE NULL,
  `accepted` VARCHAR(20) NULL,
  `item_id` INT NULL,
  `item_quantity` INT NULL,
  `design_specified` VARCHAR(500) NULL,
  `occasion` VARCHAR(500) NULL,
  `allergies_specified` VARCHAR(500) NULL,
  `special_requests` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  INDEX `reader_id_idx` (`customer_id` ASC),
  INDEX `item_id_idx` (`item_id` ASC),
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `book_id`
    FOREIGN KEY (`ship_address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image` ;

CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image_url` VARCHAR(500) NOT NULL,
  `title` VARCHAR(100) NULL,
  `description` VARCHAR(300) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS spuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'spuser'@'localhost' IDENTIFIED BY 'spuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'spuser'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'spuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `sideproject`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`, `country_code`) VALUES (1, '1971 Oswego St', 'Aurora', 'CO', '80010', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `sideproject`;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `address_id`, `phone`, `first_name`, `last_name`, `role`, `enabled`) VALUES (1, 'user', 'user', 'user@user.com', 1, '000-111-1234', 'User', 'Userman', 'standard', 1);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `address_id`, `phone`, `first_name`, `last_name`, `role`, `enabled`) VALUES (2, 'other', 'other', 'other@email.com', 1, '000-222-3455', 'Other', 'Otherman', 'standard', 1);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `address_id`, `phone`, `first_name`, `last_name`, `role`, `enabled`) VALUES (3, 'admin', '$2a$10$5NVjt2axRvPvxRMMPy5kUOvIVkz5VMoPHMdk51sMaX/hFpApcKwly', 'dgower83@gmail.com', 1, '660-909-8500', 'Dianne', 'Gower', 'admin', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item`
-- -----------------------------------------------------
START TRANSACTION;
USE `sideproject`;
INSERT INTO `item` (`id`, `type`, `image_one`, `image_two`, `image_three`) VALUES (1, 'Cookie', NULL, NULL, NULL);
INSERT INTO `item` (`id`, `type`, `image_one`, `image_two`, `image_three`) VALUES (2, 'Cupcake', NULL, NULL, NULL);
INSERT INTO `item` (`id`, `type`, `image_one`, `image_two`, `image_three`) VALUES (3, 'Cake', NULL, NULL, NULL);
INSERT INTO `item` (`id`, `type`, `image_one`, `image_two`, `image_three`) VALUES (4, 'Macaroon', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `orders_placed`
-- -----------------------------------------------------
START TRANSACTION;
USE `sideproject`;
INSERT INTO `orders_placed` (`id`, `date_placed`, `date_requested`, `date_fulfilled`, `customer_id`, `ingredients_specified`, `ship_address_id`, `price`, `accepted`, `item_id`, `item_quantity`, `design_specified`, `occasion`, `allergies_specified`, `special_requests`) VALUES (1001, '2011-11-19', NULL, '2019-11-25', 2, 'Sugar batter and Cream Cheese Icing', 1, 10.99, 'ACCEPTED', 1, 12, 'Minions Characters', 'Birthday', 'None', 'One of each minion type, if possible');

COMMIT;

