CREATE TABLE `users` (
  `id` int PRIMARY KEY,
  `username` varchar(255) UNIQUE NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` ENUM ('USER', 'ADMIN') DEFAULT "USER",
  `verified` boolean DEFAULT false,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp DEFAULT (now())
);

CREATE TABLE `products` (
  `id` int PRIMARY KEY,
  `title` varchar(255) UNIQUE NOT NULL,
  `description` varchar(255),
  `quantity` int,
  `price` float NOT NULL,
  `color` varchar(255),
  `size` ENUM ('SMALL', 'MEDIUM', 'LARGE'),
  `discount` float,
  `category` varchar(255),
  `slug` varchar(255) UNIQUE NOT NULL,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp DEFAULT (now())
);

CREATE TABLE `cart_items` (
  `id` int PRIMARY KEY,
  `quantity` int NOT NULL,
  `product_id` int,
  `user_id` int
);

CREATE TABLE `order_items` (
  `id` int PRIMARY KEY,
  `quantity` int NOT NULL,
  `price` int NOT NULL,
  `product_id` int,
  `order_id` int
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY,
  `user_id` int,
  `total` float,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp DEFAULT (now())
);

ALTER TABLE `cart_items` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `cart_items` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `order_items` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `order_items` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
