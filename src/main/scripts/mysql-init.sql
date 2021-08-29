DROP DATABASE IF EXISTS tuproducto;
DROP USER IF EXISTS 'springcommerce'@'localhost';
CREATE DATABASE IF NOT EXISTS tuproducto CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'springcommerce'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON tuproducto.* TO 'springcommerce'@'localhost';
FLUSH PRIVILEGES;
