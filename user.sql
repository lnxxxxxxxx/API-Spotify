-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-07-2023 a las 03:01:36
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spotify_api`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `ID_Pedido` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Telefono` int(20) NOT NULL,
  `Producto` varchar(255) NOT NULL,
  `Lugar_de_entrega` varchar(255) NOT NULL,
  `Provincia` varchar(255) NOT NULL,
  `Localidad` varchar(255) NOT NULL,
  `Codigo_Postal` int(20) NOT NULL,
  `Forma_de_pago` varchar(100) NOT NULL,
  `hora` timestamp NOT NULL DEFAULT current_timestamp(),
  `UsuarioID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`ID_Pedido`, `Nombre`, `Apellido`, `Telefono`, `Producto`, `Lugar_de_entrega`, `Provincia`, `Localidad`, `Codigo_Postal`, `Forma_de_pago`, `hora`, `UsuarioID`) VALUES
(1, 'Pedido1', 'Apellido1', 123456789, 'Producto1', 'Lugar1', 'Provincia1', 'Localidad1', 12345, 'Pago1', '2023-07-15 15:29:14', 1),
(3, 'Leandro', 'Luna', 12345678, 'Queso', 'Rivadavia 9989', 'Buenos Aires', 'Boulogne', 0, 'En efectivo', '2023-07-17 01:06:12', 8),
(4, 'Leandro', 'Luna', 12345678, 'Queso rayado', 'Rivadavia 9989', 'Buenos Aires', 'Boulogne', 0, 'En efectivo', '2023-07-17 01:06:36', 8),
(5, 'Leandro', 'Luna', 12345678, 'Queso rayado', 'Rivadavia 9989', 'Buenos Aires', 'Boulogne', 0, 'En efectivo', '2023-07-17 01:07:12', 8),
(6, 'Leandro', 'Luna', 12345678, 'Queso rayado', 'Rivadavia 9989', 'Buenos Aires', 'Boulogne', 0, 'En efectivo', '2023-07-17 01:08:20', 8),
(7, 'Leandro', 'Luna', 12345678, 'Queso rayado', 'Rivadavia 9989', 'Buenos Aires', 'Boulogne', 0, 'En efectivo', '2023-07-17 01:08:39', 8),
(8, 'Leandro', 'Luna', 12345678, 'Queso rayado', 'Rivadavia 9989', 'Buenos Aires', 'Boulogne', 1069, 'En efectivo', '2023-07-17 01:19:58', 8),
(9, 'Ariel', 'Luna', 123123123, 'Manteca', 'Rivadavia 1243', 'Buenos Aires-GBA', 'Villa Adelina', 1234, 'on', '2023-07-17 22:37:42', 8),
(10, 'Armando', 'Barrera', 1231231231, 'Jugo Tang', 'Calle 1234', 'Buenos Aires', 'San Isidro', 1233, 'En efectivo', '2023-07-17 22:43:58', 8),
(11, 'Jose', 'Maria', 123123213, 'Teclado', 'calle 123123', 'Buenos Aires', 'Vicente López', 123213, 'En efectivo', '2023-07-17 22:45:00', 8),
(12, 'Ariel', 'Lopez', 12123123, 'Mouise', 'Calle 123123', 'Buenos Aires', 'Villa Adelina', 123, 'En efectivo', '2023-07-17 22:48:18', 11),
(13, 'Ariel', 'Lopez', 1123123123, 'Queso La Serenisima', 'Calle 123123', 'Buenos Aires', 'Nuñez', 1123, 'En efectivo', '2023-07-17 22:50:31', 11),
(14, 'Ariel', 'Lopez', 13123123, 'Pc GAMER Ryzen', 'Calle 123123', 'Buenos Aires', 'Nuñez', 123123, 'Mercado Pago', '2023-07-17 22:52:15', 11),
(15, 'Ariel', 'Lopez', 123123123, 'Notebook', 'Calle 1344', 'Buenos Aires', 'Nuñez', 123, 'En efectivo', '2023-07-17 22:52:39', 11),
(16, 'Ariel', 'Lopez', 123123, 'Manteca', 'Calle 12123', 'Buenos Aires', 'Nuñez', 12312, 'En efectivo', '2023-07-17 22:52:59', 11),
(17, 'Claudia', 'Diaz', 123123123, 'Manteca', 'Calle 123', 'Buenos Aires', 'Belgrano', 123123, 'En efectivo', '2023-07-17 23:14:28', 17),
(18, 'Jorge', 'Diaz', 123123123, 'Queso Rayado', 'Calle 123', 'Buenos Aires-GBA', 'San Isidro', 1123, 'En efectivo', '2023-07-17 23:39:07', 19),
(19, 'Juliana', 'Lopez', 1213123, 'Milanesas', 'Calle 123', 'Buenos Aires-GBA', 'San Isidro', 1024, 'En efectivo', '2023-07-17 23:53:57', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL,
  `nombre` varchar(55) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` text NOT NULL,
  `rol` enum('USER','ADMIN') NOT NULL DEFAULT 'USER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `email`, `password`, `rol`) VALUES
(1, 'Leandro Luna', 'lean@hotmail.com', '123', 'USER'),
(2, 'Leandro', 'lean1@hotmail.com', '1234', 'USER'),
(3, 'Leandro', 'lean2@hotmail.com', '1234', 'USER'),
(4, 'Leandro', 'lean232@hotmail.com', '31234', 'ADMIN'),
(5, 'Leandro', 'lean5@hotmail.com', '31234', 'USER'),
(6, 'Leandro', 'lean64@hotmail.com', '31234', 'USER'),
(7, 'Leandro', 'lean9@hotmail.com', '$2a$10$.UMUsvv8V/sCCyiLkSQTTu52YVe1nPhA02WVKfhEt8SvXcIWWqvVm', 'USER'),
(8, 'Leandro', 'leann@hotmail.com', '$2a$10$b1gStLlpfhflg3vGA1d7NuU5xwv84jyY/Gh84btMqmYRua4F0tnx6', 'USER'),
(9, 'Leandro', 'leannn@hotmail.com', '$2a$10$xTNqyV3tuXr/QK.zypP0TOHO.fHeAvHjmisVX/EFH/5MQEvTeSuE2', 'ADMIN'),
(10, 'Leandro', 'lea@hotmail.com', '$2a$10$tpUI4kLPe7N18QKZz8d5ZOmJmjc3Od2H8Z9ZJHGCBtLk97Q5LNnIy', 'ADMIN'),
(11, 'Ariel ', 'Ariel@gmail.com', '$2a$10$xY9dtNpZAlGWhKLMBvRp4e4p0pIM4nmicrxwVqx5shoysJdd5nnwW', 'USER'),
(12, 'Esteban ', 'Esteban@gmail.com', '$2a$10$Ad1cHAa5B421miZX58DLWOIJ4uuczvr11fP047Nom2ihk1r09J7xe', 'USER'),
(13, 'Julian', 'Julian@gmail.com', '$2a$10$.s9V.Z.RjQOz0L4NbdaFX.3HfmYpRQ0wv2DHKFRnF6ZgctcCU.Phi', 'USER'),
(14, 'Carlos', 'Carlos@hotmail.com', '$2a$10$AmjRt8DDNqQtM/odmAzhHupf58TWfPpV91EwvRjbQZEhBdY66Ec3W', 'USER'),
(15, 'Carlos Suarez', 'Carlos1@gmail.com', '$2a$10$YKURhiereTMODOzqfNTXp.a5hbdRFsbafL9ppkH6BvkIUJXveFivK', 'USER'),
(16, 'Claudia', 'claudia@gmail.com', '$2a$10$QZ9T22x830A0wNrM6F3MEOQVxMjLGz6R1A16BXG.M0HwUXU1qTLpO', 'USER'),
(17, 'Claudia', 'Claudia@hotmail.com', '$2a$10$C/COs.8hMD4P2JTLPoD4COKUTV/iQAPszzOrUaZgomL4D0uIZoJ3O', 'USER'),
(18, 'Jorge', 'Jorge@gmail.com', '$2a$10$1x8kTZhowrE.AQVguwl7luprCVFIAs.gBp9D5lot4aMCECxxzZMKy', 'USER'),
(19, 'Jorge', 'Jorge@hotmail.com', '$2a$10$DFXNepxqe1/gecMPYMwyk.BvGkRBZ1he/XLUbtwMiLbiwM50iVnGm', 'USER'),
(20, 'Yonathan', 'Yoni@gmail.com', '$2a$10$fKnl1dx3xV.j984CE7gE7OfvoZeJMODOBAdC9YE8OpPUvvLpBLOqq', 'USER'),
(21, 'Juliana', 'Juliana@gmail.com', '$2a$10$LlKLLy73Me.piKwna1SDJeMH1/D42JoTL9P4B9EwgRHERcaVG0RMG', 'USER');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`ID_Pedido`),
  ADD KEY `FK_Usuario_Pedidos` (`UsuarioID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `ID_Pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `FK_Usuario_Pedidos` FOREIGN KEY (`UsuarioID`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
