-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-12-11 07:10:45
-- 服务器版本： 10.4.22-MariaDB
-- PHP 版本： 7.4.26

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
  `number_selected` int(11) NOT NULL DEFAULT 0,
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

INSERT INTO `arrange` (`arrange_id`, `name_exp`, `address`, `teacher_id`, `number_use`, `number_selected`, `isshared`, `type`, `week`, `day`, `start`, `end`) VALUES
('1', '加法器实验', '1001', '1', 5, 1, 0, '普通实验', 17, 1, 3, 3),
('2', '加法器实验', '1001', '1', 5, 0, 0, '普通实验', 17, 2, 1, 1),
('3', '运算器实验', '1002', '1', 7, 0, 1, '普通实验', 18, 4, 3, 3),
('4', '单周期CPU实验', '1002', '2', 7, 2, 0, '普通实验', 20, 4, 1, 2),
('5', '计算机组成', '1002', '2', 5, 0, 1, '开放性实验', 19, 5, 1, 2);

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
('1001', '1', 5, 5),
('1002', '1', 9, 10);

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
('1', '1001', '正常'),
('1', '1002', '正常'),
('10', '1002', '正常'),
('2', '1001', '正常'),
('2', '1002', '正常'),
('3', '1001', '正常'),
('3', '1002', '正常'),
('4', '1001', '正常'),
('4', '1002', '正常'),
('5', '1001', '正常'),
('5', '1002', '正常'),
('6', '1002', '损坏'),
('7', '1002', '正常'),
('8', '1002', '正常'),
('9', '1002', '正常');

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
('1', 'admin', 'admin');

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
('1', '919106840201', '软件工程1班', '计算机课程与工程学院', '123456'),
('10', '919106840304', '智能科学与技术2班', '计算机科学与工程学院', '123456'),
('11', '919106840303', '智能科学与技术1班', '计算机科学与工程学院', '123456'),
('2', '919106840202', '软件工程1班', '计算机科学与工程学院', '123456'),
('3', '919106840101', '计算机科学与技术1班', '计算机科学与工程学院', '123456'),
('4', '919106840102', '计算机科学与技术2班', '计算机科学与工程学院', '123456'),
('5', '919106840301', '智能科学与技术1班', '计算机科学与工程学院', '123456'),
('6', '919106840302', '智能科学与技术2班', '计算机科学与工程学院', '123456'),
('7', '919106840401', '网络安全班', '计算机科学与工程学院', '123456');

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
(1, '1001', '正常', '1', '1'),
(1, '1002', '正常', '4', '2'),
(2, '1002', '正常', '4', '1');

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
('1', '组原教师1', '计算机科学与工程学院', '123456'),
('2', '实验室教师1', '计算机科学与工程学院', '123456');

--
-- 转储表的索引
--

--
-- 表的索引 `arrange`
--
ALTER TABLE `arrange`
  ADD PRIMARY KEY (`arrange_id`) USING BTREE;

--
-- 表的索引 `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`address`);

--
-- 表的索引 `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`machine_id`,`address`);

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
