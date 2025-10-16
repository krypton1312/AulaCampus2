-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Окт 16 2025 г., 09:43
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
-- База данных: `inmobilaria`
--

DELIMITER $$
--
-- Процедуры
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizaAlquiler` (IN `id` INT, IN `nuevoPrecio` DECIMAL(10,2))  BEGIN
	UPDATE alquileres
    SET precioAlquiler = nuevoPrecio
    WHERE idAlquiler = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminaAlquiler` (IN `id` INT)  BEGIN
	DELETE FROM alquileres where idAlquiler = id;
END$$

--
-- Функции
--
CREATE DEFINER=`root`@`localhost` FUNCTION `devuelveImporte` (`id` INT) RETURNS DECIMAL(10,2) BEGIN
	DECLARE precio DECIMAL(10,2);
    SET precio = 0;
    SELECT precioAlquiler INTO precio FROM 	  alquileres WHERE idAlquiler = id;
    RETURN precio;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `devuelveImporteAnnual` (`id` INT) RETURNS DECIMAL(10,2) BEGIN
	DECLARE precio DECIMAL(10,2);
    SET precio = 0;
    SELECT precioAlquiler INTO precio FROM 	  alquileres WHERE idAlquiler = id;
    RETURN precio*1.21*12;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Структура таблицы `alquileres`
--

CREATE TABLE `alquileres` (
  `idAlquiler` int(11) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `poblacion` varchar(30) NOT NULL,
  `codPostal` varchar(10) NOT NULL,
  `precioAlquiler` decimal(6,2) NOT NULL,
  `idContacto` varchar(30) NOT NULL,
  `telefono` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `alquileres`
--

INSERT INTO `alquileres` (`idAlquiler`, `direccion`, `poblacion`, `codPostal`, `precioAlquiler`, `idContacto`, `telefono`) VALUES
(2, 'esta123', 'valencia', '46001', '100.00', '1', '35432');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `alquileres`
--
ALTER TABLE `alquileres`
  ADD PRIMARY KEY (`idAlquiler`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
