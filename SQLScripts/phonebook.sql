CREATE DATABASE `phonebook`;
USE `phonebook`;
CREATE TABLE `contacts` (
	`id` INT auto_increment NOT NULL,
    `firstName` varchar(45),
    `lastName` varchar(45),
    primary key(`id`)
);