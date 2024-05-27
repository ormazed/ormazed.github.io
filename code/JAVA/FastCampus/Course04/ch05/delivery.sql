CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `registered_at` DATETIME NULL,
  `unregistered_at` DATETIME NULL,
  `last_login_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `delivery`.`store` (
 `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(100) NOT NULL,
 `address` VARCHAR(150) NOT NULL,
 `status` VARCHAR(50) NULL,
 `category` VARCHAR(50) NULL,
 `star` DOUBLE NULL DEFAULT 0,
 `thumbnail_url` VARCHAR(200) NOT NULL,
 `minimum_amount` DECIMAL(11,4) NOT NULL,
 `minimum_delivery_amount` DECIMAL(11,4) NOT NULL,
 `phone_number` VARCHAR(20) NULL,
 PRIMARY KEY (`id`))
ENGINE = InnoDB;

 