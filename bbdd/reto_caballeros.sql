-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2024 a las 12:42:52
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
('Guillermo ', 'de Montpellier', 380, 0, 1, 2, 2, 2),
('Elena', 'de Valois', 420, 0, 2, 1, 1, 5);

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
(3, 'marron', 'Caballo basico');

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
(4, 'Pedro ', 'el Valiente', 0, 2),
(5, 'Diego ', 'el Audaz ', 0, 1);

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
(7, 'Escudo basico', 50);

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
  MODIFY `ID_CABALLERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `caballos`
--
ALTER TABLE `caballos`
  MODIFY `ID_CABALLO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `escuderos`
--
ALTER TABLE `escuderos`
  MODIFY `ID_ESCUDERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `escudos`
--
ALTER TABLE `escudos`
  MODIFY `ID_ESCUDO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
