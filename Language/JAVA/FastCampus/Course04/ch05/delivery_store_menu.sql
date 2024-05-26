CREATE TABLE IF NOT EXISTS `delivery`.`store_menu` (
 `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
 `store_id` BIGINT(32) NOT NULL, 
 `name` VARCHAR(100) NOT NULL,
 `amount` DECIMAL(11,4) NOT NULL,
 `status` VARCHAR(50) NOT NULL,
 `thumbnail_url` VARCHAR(200) NOT NULL,
 `like_count` INT NULL DEFAULT 0,
 `sequence` INT NULL DEFAULT 0,
 PRIMARY KEY (`id`))
ENGINE = InnoDB;

ALTER TABLE `delivery`.`store_menu` 
ADD INDEX `idx_store_id` (`store_id` ASC) VISIBLE;
;
