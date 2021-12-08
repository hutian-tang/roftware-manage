-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-12-08 13:25:21
-- 服务器版本： 10.4.18-MariaDB
-- PHP 版本： 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `experimentalsystem`
--

-- --------------------------------------------------------

--
-- 表的结构 `arrange`
--

CREATE TABLE `arrange` (
  `arrange_id` varchar(255) NOT NULL DEFAULT '',
  `name_exp` varchar(255) NOT NULL DEFAULT '',
  `address` varchar(255) NOT NULL DEFAULT '',
  `teacher_id` varchar(255) DEFAULT NULL,
  `number_use` int(11) DEFAULT NULL,
  `isshared` tinyint(1) NOT NULL DEFAULT 0,
  `type` varchar(255) NOT NULL DEFAULT '',
  `week` int(11) NOT NULL DEFAULT 0,
  `day` int(11) NOT NULL DEFAULT 0,
  `start` int(11) NOT NULL DEFAULT 0,
  `end` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `arrange`
--

INSERT INTO `arrange` (`arrange_id`, `name_exp`, `address`, `teacher_id`, `number_use`, `isshared`, `type`, `week`, `day`, `start`, `end`) VALUES
('1', '2', '3', '4', 5, 6, '7', 8, 9, 10, 11),
('2', '3', '4', '5', 6, 7, '8', 9, 10, 11, 12),
('3', 'hh', '5', '6', 7, 8, '9', 10, 11, 1, 1),
('4', 'hh', '56564', '654', 64546, 1, '654', 65, 564456, 456, 465);

-- --------------------------------------------------------

--
-- 表的结构 `classroom`
--

CREATE TABLE `classroom` (
  `address` varchar(255) NOT NULL DEFAULT '',
  `manager_id` varchar(255) NOT NULL DEFAULT '',
  `number_valid` int(11) NOT NULL DEFAULT 0,
  `number_total` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `classroom`
--

INSERT INTO `classroom` (`address`, `manager_id`, `number_valid`, `number_total`) VALUES
('ss', '10', 2, 3),
('3', '4', 5, 6);

-- --------------------------------------------------------

--
-- 表的结构 `machine`
--

CREATE TABLE `machine` (
  `machine_id` varchar(255) NOT NULL DEFAULT '',
  `address` varchar(255) NOT NULL DEFAULT '',
  `condition` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `machine`
--

INSERT INTO `machine` (`machine_id`, `address`, `condition`) VALUES
('1', '2', '正常'),
('4', '3', '损坏'),
('5', '6', '损坏'),
('6', '77', '正常');

-- --------------------------------------------------------

--
-- 表的结构 `mag`
--

CREATE TABLE `mag` (
  `mag_id` varchar(255) NOT NULL DEFAULT '',
  `message` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(255) NOT NULL DEFAULT '',
  `teacher_id` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE `manager` (
  `manager_id` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`manager_id`, `name`, `password`) VALUES
('123', '1', '2'),
('13', '2', '3');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `student_id` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `class_id` varchar(255) NOT NULL DEFAULT '',
  `department` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`student_id`, `name`, `class_id`, `department`, `password`) VALUES
('1', '2', '3', '4', '5'),
('2', '3', '4', '5', '6');

-- --------------------------------------------------------

--
-- 表的结构 `table`
--

CREATE TABLE `table` (
  `table_id` int(11) NOT NULL DEFAULT 0,
  `address` varchar(255) NOT NULL DEFAULT '',
  `condition` varchar(255) NOT NULL DEFAULT '',
  `arrange_id` varchar(255) NOT NULL DEFAULT '',
  `student_id` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `table`
--

INSERT INTO `table` (`table_id`, `address`, `condition`, `arrange_id`, `student_id`) VALUES
(1, '6', '4', '3', '2'),
(2, '5', '3', '1', '2'),
(4, '4', '5', '6', '7'),
(8, '2', 'g', 'd', 'g'),
(9, '2', 'g', 'd', 'g');

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `department` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `name`, `department`, `password`) VALUES
('1', '2', '3', '4'),
('33', '3', 'dfsaf', '3');

--
-- 转储表的索引
--

--
-- 表的索引 `arrange`
--
ALTER TABLE `arrange`
  ADD PRIMARY KEY (`arrange_id`) USING BTREE;

--
-- 表的索引 `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`machine_id`) USING BTREE;

--
-- 表的索引 `mag`
--
ALTER TABLE `mag`
  ADD PRIMARY KEY (`mag_id`) USING BTREE;

--
-- 表的索引 `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`manager_id`) USING BTREE;

--
-- 表的索引 `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`) USING BTREE;

--
-- 表的索引 `table`
--
ALTER TABLE `table`
  ADD PRIMARY KEY (`table_id`,`arrange_id`) USING BTREE;

--
-- 表的索引 `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`) USING BTREE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
