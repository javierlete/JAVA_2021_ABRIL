-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema amazonia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema amazonia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amazonia` DEFAULT CHARACTER SET utf8mb4 ;
USE `amazonia` ;

-- -----------------------------------------------------
-- Table `amazonia`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazonia`.`categorias` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TEXT(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazonia`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazonia`.`productos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `descripcion` TEXT(1000) NULL,
  `categorias_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_productos_categorias_idx` (`categorias_id` ASC) VISIBLE,
  CONSTRAINT `fk_productos_categorias`
    FOREIGN KEY (`categorias_id`)
    REFERENCES `amazonia`.`categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
