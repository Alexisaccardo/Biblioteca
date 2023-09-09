-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-09-2023 a las 18:01:10
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prestamoslibros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `Libros` varchar(50) NOT NULL,
  `Autores` varchar(50) NOT NULL,
  `Prestamos` varchar(30) NOT NULL,
  `Usuarios` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`Libros`, `Autores`, `Prestamos`, `Usuarios`) VALUES
('Al coronel no tiene quien le escriba', 'Gabriel Garcia Marquez', 'Disponible', ''),
('Cien años de soledad', 'Gabriel Garcia Marquez', 'Disponible', ''),
('Don quijote de la mancha', 'Miguel de Servantes Savedra', 'Disponible', ''),
('El gran Gatsby', 'F. Scoott Fitzgerald', 'Disponible', ''),
('El lugar mas bonito del mundo', 'Ann Cameron', 'no disponible', 'Maickel'),
('El rey de la salsa', 'Pedro Baquero', 'no disponible', 'Alexis10'),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Disponible', ''),
('Matar un ruiseñor', 'Harper Lee', 'Disponible', ''),
('Orgullo y Prejuicio', 'Jane Austen', 'Disponible', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`Libros`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
