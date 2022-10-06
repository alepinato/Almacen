-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2019 a las 16:32:12
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `almacen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `fecha` date NOT NULL,
  `importe` float NOT NULL,
  `detalle` varchar(40) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`fecha`, `importe`, `detalle`, `tipo`, `id`) VALUES
('2019-11-11', 620, 'Carne', 'E', 31),
('2019-11-13', 310, 'Carne', 'E', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `descripcion` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `descripcion`) VALUES
(1, 'Lacteos: 1'),
(2, 'Fideos: 2'),
(3, 'Bebidas: 3'),
(4, 'Carne: 4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `cedula` int(8) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `telefono` varchar(40) NOT NULL,
  `saldo` int(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `saldo`) VALUES
(14, 54843010, 'Braian', 'Almeida', 'Atillio1437', '47794903', 7513),
(15, 49258654, 'Christian', 'Barco', 'Cuareim', '092912631', 254);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito`
--

CREATE TABLE `credito` (
  `id` int(11) NOT NULL,
  `fecha` varchar(40) NOT NULL,
  `descripcion` varchar(40) NOT NULL,
  `cedula` int(8) NOT NULL,
  `precio` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `credito`
--

INSERT INTO `credito` (`id`, `fecha`, `descripcion`, `cedula`, `precio`) VALUES
(82, '2019-11-11', 'Carne', 0, '465.0'),
(83, '2019-11-11', 'Carne', 0, '775.0'),
(84, '2019-11-13', 'Carne', 0, '620.0'),
(85, '2019-11-13', 'AS', 0, '165.0'),
(86, '2019-11-13', 'Carne', 0, '620.0'),
(87, '2019-11-13', 'Carne', 0, '155.0'),
(88, '2019-11-13', 'Carne', 0, '155.0'),
(89, '2019-11-13', 'Carne', 54843010, '310.0'),
(90, '2019-11-13', 'Carne', 0, '310.0'),
(91, '2019-11-13', 'AS', 54843010, '165.0'),
(92, '2019-11-13', 'Carne', 54843010, '310.0'),
(93, '2019-11-13', 'Carne', 54843010, '310.0'),
(94, '2019-11-13', 'AS', 54843010, '165.0'),
(95, '2019-11-13', 'Carne', 54843010, '310.0'),
(96, '2019-11-13', 'AS', 54843010, '99.0'),
(97, '2019-11-13', 'Carne', 54843010, '155.0'),
(98, '2019-11-13', 'Carne', 54843010, '775.0'),
(99, '2019-11-13', 'AS', 54843010, '99.0'),
(100, '2019-11-13', 'Carne', 54843010, '1550.0'),
(101, '2019-11-13', 'Carne', 49258654, '310.0'),
(102, '2019-11-13', 'AS', 49258654, '66.0'),
(103, '2019-11-13', 'AS', 49258654, '33.0'),
(104, '2019-11-13', 'AS', 49258654, '33.0'),
(105, '2019-11-13', 'Carne', 49258654, '155.0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(40) NOT NULL,
  `preciocosto` float NOT NULL,
  `precioventa` float NOT NULL,
  `categoria` int(30) NOT NULL,
  `cantidad` int(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `descripcion`, `preciocosto`, `precioventa`, `categoria`, `cantidad`) VALUES
(39, 'Carne', 123, 155, 1, -1),
(35, 'Carne', 1235, 155, 1, 43),
(40, 'AS', 27, 33, 4, 39);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `CI` varchar(11) NOT NULL,
  `usuario` varchar(40) NOT NULL,
  `contraseña` varchar(40) NOT NULL,
  `Categoria` varchar(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `CI`, `usuario`, `contraseña`, `Categoria`) VALUES
(2, '000000', 'Admin', '1234', 'A');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `credito`
--
ALTER TABLE `credito`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `credito`
--
ALTER TABLE `credito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
