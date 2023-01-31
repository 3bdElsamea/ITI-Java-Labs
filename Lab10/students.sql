-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2023 at 08:17 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iti`
--

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `department` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `age`, `department`, `email`) VALUES
(1, 'ahmed', 23, 'os', 'asayed4761@gmail.com'),
(2, 'Mohamed', 25, 'Pd', 'Mohamed@gmail.com'),
(3, 'Elshaar', 22, 'os', 'Elshaar@gmail.com'),
(4, 'Nader', 25, 'Pd', 'Nader@gmail.com'),
(5, 'Amr', 25, 'os', 'Amr@gmail.com'),
(6, 'Noor', 23, 'Pd', 'Noor@gmail.com'),
(7, 'Eman', 23, 'Pd', 'Eman@gmail.com'),
(8, 'Asmaa', 25, 'os', 'Asmaa@gmail.com'),
(9, 'Hossam', 30, 'os', 'Hossam@gmail.com'),
(10, 'Peter', 28, 'os', 'peter@gmail.com'),
(26, 'ahmed ', 25, 'os', 'ahmed@ahmed.com'),
(27, 'ahmed ', 25, 'os', 'ahmed@ahmed.com'),
(28, 'ahmed ', 25, 'os', 'ahmed@ahmed.com'),
(29, 'ahmed ', 25, 'os', 'ahmed@ahmed.com'),
(30, 'ahmed ', 25, 'os', 'ahmed@ahmed.com'),
(31, 'ahmed ', 25, 'os', 'ahmed@ahmed.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
