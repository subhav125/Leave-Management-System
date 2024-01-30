-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2024 at 11:41 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ngpdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `leave_details`
--

CREATE TABLE `leave_details` (
  `name` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `leave_type` varchar(50) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `number_of_days` int(11) NOT NULL,
  `reason` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leave_details`
--

INSERT INTO `leave_details` (`name`, `phone`, `leave_type`, `start_date`, `end_date`, `number_of_days`, `reason`, `created_at`) VALUES
('Tamil', '7487847', 'vacation', '2004-03-12', '2020-04-12', 4, 'fever', '2024-01-29 13:42:37'),
('Subha', '+918072002861', 'personal', '2024-01-30', '2024-02-01', 2, 'Cousin wedding', '2024-01-30 02:23:44'),
('Tamil', '1234567', 'sick', '2024-01-31', '2024-02-01', 2, 'fever', '2024-01-30 03:46:25'),
('Rithu', '987654321', 'personal', '2024-02-02', '2024-02-05', 3, 'marriage', '2024-01-30 03:53:07'),
('Rithu', '987654321', 'vacation', '2024-01-30', '2024-01-31', 1, 'rty', '2024-01-30 03:57:09'),
('Dhanu', '9345841403', 'personal', '2024-02-08', '2024-02-10', 3, 'Chithi marriage', '2024-01-30 04:17:52');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
