-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2024 a las 12:28:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reto_caballeros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armas`
--

CREATE TABLE `armas` (
  `ID_ARMA` int(11) NOT NULL,
  `TIPO` varchar(255) DEFAULT NULL,
  `FUERZA_ATAQUE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `armas`
--

INSERT INTO `armas` (`ID_ARMA`, `TIPO`, `FUERZA_ATAQUE`) VALUES
(1, 'Excalibur', 95),
(2, 'Joyeuse', 90),
(3, 'Durandal', 95),
(4, 'Maza de bola', 90),
(5, 'Maza de clavo', 80),
(6, 'Maza de estrella', 10),
(7, 'Maza de cadena', 89),
(8, 'Lanza de justa', 80),
(9, 'Lanza de caballería', 10),
(10, 'Lanza de infantería', 89),
(11, 'Espada de Danma', 89),
(12, 'Espada Enma', 89),
(13, 'Sandai Kitetsu', 95),
(14, 'Wado Ichimonji', 95),
(15, 'Katana Roja', 25),
(17, 'Espadasanta', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballeros`
--

CREATE TABLE `caballeros` (
  `NOMBRE` varchar(255) DEFAULT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `FUERZA` int(11) DEFAULT NULL,
  `EXPERIENCIA` int(11) DEFAULT NULL,
  `ID_CABALLERO` int(11) NOT NULL,
  `ID_ESCUDO` int(11) DEFAULT NULL,
  `ID_CABALLO` int(11) DEFAULT NULL,
  `ID_ARMA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caballeros`
--

INSERT INTO `caballeros` (`NOMBRE`, `APELLIDO`, `FUERZA`, `EXPERIENCIA`, `ID_CABALLERO`, `ID_ESCUDO`, `ID_CABALLO`, `ID_ARMA`) VALUES
('Jose', 'Luis', 22, 21, 0, 3, 3, 1),
('Guillermo ', 'de Montpellier', 380, 273, 1, 2, 2, 12),
('Elena', 'De Valois', 430, 48, 2, 4, 4, 3),
('Pedro', 'Del catillo', 270, 62, 5, 6, 1, 11),
('Luka', 'Montwuemado', 500, 100, 6, 7, 5, 6),
('Luis', 'De Congora', 22, 137, 11, 1, 6, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballos`
--

CREATE TABLE `caballos` (
  `ID_CABALLO` int(11) NOT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caballos`
--

INSERT INTO `caballos` (`ID_CABALLO`, `COLOR`, `NOMBRE`) VALUES
(1, 'plateado', 'Trueno de Plata'),
(2, 'negro', 'Viento Veloz'),
(3, 'marron', 'Caballo basico'),
(4, 'negro', 'Luis Fonsi'),
(5, 'Rosa', 'Barbie'),
(6, 'Openhheimer', 'Marron'),
(7, 'Rosa', 'Barbie'),
(8, 'Barbie', 'Rosa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuderos`
--

CREATE TABLE `escuderos` (
  `ID_ESCUDERO` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `EXPERIENCIA` int(11) DEFAULT NULL,
  `ID_CABALLERO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escuderos`
--

INSERT INTO `escuderos` (`ID_ESCUDERO`, `NOMBRE`, `APELLIDO`, `EXPERIENCIA`, `ID_CABALLERO`) VALUES
(18, 'Pablo', 'Antero', 30, 1),
(19, 'Raul', 'Arbiol', 5, 2),
(25, 'Jose', 'Luis', 30, 0),
(26, 'Poortus', 'Just', 5, 5),
(27, 'Pintus', 'Oblack', 5, 6),
(28, 'Luis', 'De gongora', 20, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escudos`
--

CREATE TABLE `escudos` (
  `ID_ESCUDO` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `NIVEL_DEFENSA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escudos`
--

INSERT INTO `escudos` (`ID_ESCUDO`, `NOMBRE`, `NIVEL_DEFENSA`) VALUES
(1, 'Escudo redondo', 80),
(2, 'Escudo de persa', 20),
(3, 'Escudo de romano', 80),
(4, 'Escudo escocés', 75),
(5, 'Escudo vikingo', 95),
(6, 'Escudo basico', 10),
(7, 'Escudo basico', 50),
(10, 'Mata Demonios', 65);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_batallas`
--

CREATE TABLE `historial_batallas` (
  `ID_PJ1` int(11) NOT NULL,
  `ID_PJ2` int(11) NOT NULL,
  `GANADOR` int(11) NOT NULL,
  `FECHA_BATALLA` date DEFAULT NULL,
  `ID_BATALLA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_batallas`
--

INSERT INTO `historial_batallas` (`ID_PJ1`, `ID_PJ2`, `GANADOR`, `FECHA_BATALLA`, `ID_BATALLA`) VALUES
(1, 2, 1, '2024-03-18', 1),
(2, 5, 5, '2024-03-19', 2),
(0, 5, 5, '2024-03-19', 3),
(5, 0, 5, '2024-03-19', 4),
(6, 5, 6, '2024-03-19', 5),
(2, 1, 1, '2024-03-19', 6),
(0, 5, 5, '2024-03-19', 7),
(2, 1, 2, '2024-03-19', 8),
(2, 0, 2, '2024-03-19', 9),
(5, 0, 5, '2024-03-19', 10),
(0, 1, 0, '2024-03-19', 11),
(2, 0, 2, '2024-03-19', 12),
(1, 0, 0, '2024-03-19', 13),
(1, 2, 2, '2024-03-19', 14),
(1, 0, 0, '2024-03-19', 15),
(1, 0, 0, '2024-03-19', 16),
(1, 1, 1, '2024-03-19', 17),
(1, 0, 1, '2024-03-19', 18),
(1, 2, 2, '2024-03-19', 19),
(1, 0, 1, '2024-03-19', 20),
(1, 0, 1, '2024-03-19', 21),
(1, 5, 1, '2024-03-19', 22),
(1, 5, 1, '2024-03-19', 23),
(1, 5, 1, '2024-03-19', 24),
(1, 6, 1, '2024-03-19', 25),
(1, 5, 1, '2024-03-19', 26),
(1, 6, 6, '2024-03-19', 27),
(1, 5, 1, '2024-03-19', 28),
(1, 0, 1, '2024-03-19', 29),
(1, 6, 1, '2024-03-19', 30),
(1, 5, 1, '2024-03-19', 31),
(1, 2, 1, '2024-03-19', 32),
(1, 6, 1, '2024-03-19', 33),
(1, 2, 1, '2024-03-19', 34),
(1, 6, 1, '2024-03-20', 35),
(1, 2, 1, '2024-03-20', 36),
(11, 6, 11, '2024-03-20', 37);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `armas`
--
ALTER TABLE `armas`
  ADD PRIMARY KEY (`ID_ARMA`);

--
-- Indices de la tabla `caballeros`
--
ALTER TABLE `caballeros`
  ADD PRIMARY KEY (`ID_CABALLERO`),
  ADD UNIQUE KEY `ID_ESCUDO` (`ID_ESCUDO`),
  ADD UNIQUE KEY `ID_CABALLO` (`ID_CABALLO`),
  ADD UNIQUE KEY `ID_ARMA` (`ID_ARMA`);

--
-- Indices de la tabla `caballos`
--
ALTER TABLE `caballos`
  ADD PRIMARY KEY (`ID_CABALLO`);

--
-- Indices de la tabla `escuderos`
--
ALTER TABLE `escuderos`
  ADD PRIMARY KEY (`ID_ESCUDERO`),
  ADD UNIQUE KEY `ID_CABALLERO` (`ID_CABALLERO`);

--
-- Indices de la tabla `escudos`
--
ALTER TABLE `escudos`
  ADD PRIMARY KEY (`ID_ESCUDO`);

--
-- Indices de la tabla `historial_batallas`
--
ALTER TABLE `historial_batallas`
  ADD PRIMARY KEY (`ID_BATALLA`,`ID_PJ2`) USING BTREE,
  ADD KEY `FK_GANADOR` (`GANADOR`),
  ADD KEY `FK_HB` (`ID_PJ2`,`ID_PJ1`) USING BTREE,
  ADD KEY `FK_PJ1` (`ID_PJ1`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `armas`
--
ALTER TABLE `armas`
  MODIFY `ID_ARMA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `caballeros`
--
ALTER TABLE `caballeros`
  MODIFY `ID_CABALLERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `caballos`
--
ALTER TABLE `caballos`
  MODIFY `ID_CABALLO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `escuderos`
--
ALTER TABLE `escuderos`
  MODIFY `ID_ESCUDERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `escudos`
--
ALTER TABLE `escudos`
  MODIFY `ID_ESCUDO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `historial_batallas`
--
ALTER TABLE `historial_batallas`
  MODIFY `ID_BATALLA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caballeros`
--
ALTER TABLE `caballeros`
  ADD CONSTRAINT `caballeros_ibfk_1` FOREIGN KEY (`ID_CABALLO`) REFERENCES `caballos` (`ID_CABALLO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `caballeros_ibfk_2` FOREIGN KEY (`ID_ESCUDO`) REFERENCES `escudos` (`ID_ESCUDO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `caballeros_ibfk_3` FOREIGN KEY (`ID_ARMA`) REFERENCES `armas` (`ID_ARMA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `escuderos`
--
ALTER TABLE `escuderos`
  ADD CONSTRAINT `escuderos_ibfk_1` FOREIGN KEY (`ID_CABALLERO`) REFERENCES `caballeros` (`ID_CABALLERO`);

--
-- Filtros para la tabla `historial_batallas`
--
ALTER TABLE `historial_batallas`
  ADD CONSTRAINT `FK_GANADOR` FOREIGN KEY (`GANADOR`) REFERENCES `caballeros` (`ID_CABALLERO`),
  ADD CONSTRAINT `FK_HB` FOREIGN KEY (`ID_PJ2`) REFERENCES `caballeros` (`ID_CABALLERO`),
  ADD CONSTRAINT `FK_HB_CB_PJ1` FOREIGN KEY (`ID_PJ1`) REFERENCES `caballeros` (`ID_CABALLERO`),
  ADD CONSTRAINT `FK_HB_CB_PJ2` FOREIGN KEY (`ID_PJ2`) REFERENCES `caballeros` (`ID_CABALLERO`),
  ADD CONSTRAINT `FK_PJ1` FOREIGN KEY (`ID_PJ1`) REFERENCES `caballeros` (`ID_CABALLERO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
