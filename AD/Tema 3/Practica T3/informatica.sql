-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Окт 31 2025 г., 08:31
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
-- База данных: `informatica`
--

-- --------------------------------------------------------

--
-- Структура таблицы `equipos`
--

CREATE TABLE `equipos` (
  `IdEquipo` int(11) NOT NULL,
  `capacidadDisco` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `gbMemoria` int(11) NOT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `pulgadasPantalla` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `equipos`
--

INSERT INTO `equipos` (`IdEquipo`, `capacidadDisco`, `descripcion`, `gbMemoria`, `marca`, `modelo`, `precio`, `pulgadasPantalla`) VALUES
(1, 512, 'Portátil HP con procesador Intel i5, 8GB RAM y disco SSD de 512GB. Ideal para estudiantes.', 8, 'HP', 'HP Pavilion 15', 899.99, 15),
(2, 1000, 'Ultrabook ligero con pantalla de 14 pulgadas, 16GB RAM y SSD de 1TB.', 16, 'Lenovo', 'Lenovo IdeaPad Slim 14', 1199.5, 14),
(3, 256, 'Equipo compacto de 13 pulgadas con 4GB de RAM y 256GB SSD.', 4, 'Asus', 'Asus VivoBook 13', 699, 13),
(4, 1000, 'Portátil de alto rendimiento con 32GB de memoria, 1TB de disco duro y pantalla de 16 pulgadas.', 32, 'Dell', 'Dell Inspiron 16', 1350, 16);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`IdEquipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
