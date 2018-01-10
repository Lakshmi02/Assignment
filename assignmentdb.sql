-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2018 at 07:15 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assignmentdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `fileimportinfo`
--

CREATE TABLE `fileimportinfo` (
  `file_id` int(10) NOT NULL AUTO_INCREMENT,
  `filename` varchar(30) NOT NULL,
  `time_taken_to_process` varchar(10) NULL DEFAULT '0',
  `count_of_InvalidData` int(10) NULL DEFAULT '0',
  `count_of_total_deals` int(10) NULL DEFAULT '0',
   PRIMARY KEY (file_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `validdata`
--

CREATE TABLE `validdata` (
  `deal_unique_id` int(11) NOT NULL,
  `from_currency_ISO_code` varchar(10) NOT NULL,
  `to_currency_ISO_code` varchar(10) NOT NULL,
  `deal_timestamp` varchar(10) NOT NULL,
  `deal_amount` int(11) NOT NULL,
  `file_id` int(11) NOT NULL,  
  PRIMARY KEY (deal_unique_id),
  FOREIGN KEY (file_id) REFERENCES fileimportinfo (file_id)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `invaliddata`
--

CREATE TABLE `invaliddata` (
  `deal_unique_id` int(11) NOT NULL,
  `from_currency_ISO_code` varchar(10),
  `to_currency_ISO_code` varchar(10),
  `deal_timestamp` varchar(10),
  `deal_amount` int(11),
  `file_id` int(11) NOT NULL,  
  PRIMARY KEY (deal_unique_id),
  FOREIGN KEY (file_id) REFERENCES fileimportinfo (file_id)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `count_of_deals_per_currency`
--

CREATE TABLE `count_of_deals_per_currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_currency_ISO_code` varchar(10) NOT NULL,
  `count_of_deals` int(11) NOT NULL,  
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;