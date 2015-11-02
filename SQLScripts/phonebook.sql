CREATE DATABASE `phonebook`;
USE `phonebook`;
CREATE TABLE `contacts` (
	`id` INT auto_increment NOT NULL,
    `firstName` varchar(45) NOT NULL,
    `lastName` varchar(45) NOT NULL,
    primary key(`id`)
);