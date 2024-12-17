-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2024 at 05:05 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `slibrary`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `address`, `phone`) VALUES
(5, 'lav Nikolajevic Tolstoj', 'Ruska 255', 564546456),
(6, 'Vilijam Sekspir', 'Nepoznata', 456456456),
(7, 'Carls Dikens', 'nepozna', 365435446),
(8, 'Ralf Elison', 'Nepoznato', 87894564),
(9, 'Djovani Bokaco', 'Nepoznato', 78454),
(10, 'Dzordz Eliot', 'fdfdsfdsgd', 456456),
(11, 'Chinua Achebe', 'Nigerija	', 0),
(12, 'Jane Austen', 'England', 0),
(13, 'Samuel Beckett', 'Ireland', 0),
(14, 'Nikolaj Gogolj', 'Ukraine', 0);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `bname` varchar(255) NOT NULL,
  `category` int(11) NOT NULL,
  `author` int(11) NOT NULL,
  `publisher` int(11) NOT NULL,
  `contents` varchar(255) NOT NULL,
  `pages` int(11) NOT NULL,
  `edition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `bname`, `category`, `author`, `publisher`, `contents`, `pages`, `edition`) VALUES
(1, 'hjhjh', 1, 4, 1, 'jhjh', 667, 2),
(2, 'gfdgdfgd', 1, 4, 1, 'gfgfgf', 3333, 2),
(3, 'gdfgdfg', 1, 4, 1, 'fsdgsdg', 1111, 1),
(4, 'dsadsa', 1, 4, 2, 'sdsafsaf', 23232, 3),
(5, 'Bajka o princu', 10, 7, 2, 'bajke', 255, 2),
(6, 'Nasredin Hodza', 10, 6, 1, 'bajke', 555, 3),
(7, 'Enciklopedija Britaniika', 11, 9, 4, 'svet', 2555, 3),
(9, 'Bajka o princu', 7, 5, 1, 'bajke', 255, 2),
(11, 'Božanstvena komedija', 13, 12, 4, 'recnik', 255, 3),
(12, 'Orkanski visovi', 8, 8, 5, 'visovi', 555, 4),
(13, 'Ljubav u doba kolere', 16, 14, 8, 'fiction', 1256, 3),
(14, 'Samostalni ljudi', 11, 10, 2, 'sve', 5222, 3);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `catname` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `catname`, `status`) VALUES
(7, 'Knjiga po godinama', 'Active'),
(8, 'Astronomske knjige', 'Active'),
(9, 'Crkvene pesmarice', 'Active'),
(10, 'Knjige za decu', 'Active'),
(11, 'Enciklopedije', 'Active'),
(12, 'Leksikoni', 'Active'),
(13, 'Recnici', 'Active'),
(14, 'Romani', 'Active'),
(15, 'Knjizevni zanrovi i jos po nesto', 'Active'),
(16, 'Fikcije', 'DeActive');

-- --------------------------------------------------------

--
-- Table structure for table `lendbook`
--

CREATE TABLE `lendbook` (
  `id` int(11) NOT NULL,
  `memberid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `issuedate` date NOT NULL,
  `returndate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lendbook`
--

INSERT INTO `lendbook` (`id`, `memberid`, `bookid`, `issuedate`, `returndate`) VALUES
(21, 3, 5, '2024-12-01', '2024-12-31'),
(22, 4, 7, '2024-12-17', '2024-12-18'),
(23, 5, 4, '2024-12-15', '2024-12-17'),
(26, 3, 4, '2024-12-01', '2024-12-10'),
(29, 2, 1, '2024-06-03', '2024-08-13'),
(30, 6, 12, '2024-07-01', '2024-08-16'),
(31, 7, 14, '2024-10-09', '2024-11-06');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `name`, `address`, `phone`) VALUES
(2, 'Aleksandar Grbic', 'Dositejeva 12a', 600587293),
(3, 'Momcilo Milovanovic', 'Gremlinska bb', 645897552),
(4, 'Nemanja Zoranovic', 'Visegradska 13a', 847848941),
(5, 'Zoran Rakic', 'Nikole Radojcic 25', 6420058),
(6, 'Miroslav Djukic', 'Nikolajeva 16', 635879644),
(7, 'Milovan Djoric', 'Parobrodska 355', 64875964);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`, `address`, `phone`) VALUES
(1, 'Laguna', 'Nemanjina 33', 112345783),
(2, 'Mladost', 'Karadjordjeva 66', 242143666),
(4, 'Izdavacka kuca Arete', 'dsfdsfds', 545645614),
(5, 'Makart', 'fdsfd', 56456),
(6, 'Delfi Knjizare', 'fdgfdgfd', 4564),
(7, 'Only smile', 'dfdsfdsgds', 5456),
(8, 'Admiral Books', 'Partiyanska bb', 112536547);

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `id` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `mname` varchar(255) NOT NULL,
  `bname` varchar(255) NOT NULL,
  `returndate` varchar(255) NOT NULL,
  `elp` int(11) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`id`, `mid`, `mname`, `bname`, `returndate`, `elp`, `fine`) VALUES
(4, 4, 'Nemanja', 'Enciklopedija Britaniika', '2024-12-31', 0, 0),
(5, 3, 'Momcilo', 'Nasredin Hodza', '2024-12-20', 0, 0),
(6, 2, 'Aleksandar Grbic', 'dsadsa', '2024-12-17', 0, 0),
(7, 2, 'Aleksandar Grbic', 'Nasredin Hodza', '2024-11-04', 43, 4300),
(8, 2, 'Aleksandar Grbic', 'hjhjh', '2024-12-16', 1, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lendbook`
--
ALTER TABLE `lendbook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `returnbook`
--
ALTER TABLE `returnbook`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `lendbook`
--
ALTER TABLE `lendbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `returnbook`
--
ALTER TABLE `returnbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
