-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Окт 23 2025 г., 10:17
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `eventos`
--

-- --------------------------------------------------------

--
-- Структура таблицы `eventos`
--

CREATE TABLE `eventos` (
  `IdEvento` int(11) NOT NULL,
  `nombreEvento` varchar(30) NOT NULL,
  `precioEvento` decimal(5,2) NOT NULL,
  `recaudacionEvento` decimal(10,2) NOT NULL,
  `entradasVendidas` int(11) NOT NULL,
  `aforoEvento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `eventos`
--

INSERT INTO `eventos` (`IdEvento`, `nombreEvento`, `precioEvento`, `recaudacionEvento`, `entradasVendidas`, `aforoEvento`) VALUES
(1, 'Concierto de Morgen', '20.00', '200.00', 10, 2000);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`IdEvento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
