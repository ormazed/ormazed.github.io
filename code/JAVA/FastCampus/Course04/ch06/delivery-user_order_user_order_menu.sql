CREATE TABLE IF NOT EXISTS `user_order`(
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(32) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `amount` DECIMAL(11,4) NOT NULL,
  `ordered_at` DATETIME NULL,  
  `accepted_at` DATETIME NULL,  
  `cooking_started_at` DATETIME NULL,  
  `delivery_started_at` DATETIME NULL,  
  `received_at` DATETIME NULL,  
  PRIMARY KEY (`id`),
  INDEX `idx_user_id` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `user_order_menu`(
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `user_order_id` BIGINT(32) NOT NULL,
  `store_menu_id` BIGINT(32) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_user_order_id` (`user_order_id` ASC) VISIBLE,
  INDEX `idx_store_menu_id` (`store_menu_id` ASC) VISIBLE)
ENGINE = InnoDB;