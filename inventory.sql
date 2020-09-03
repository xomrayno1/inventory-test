-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 03, 2020 lúc 10:23 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `inventory`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `auth`
--

CREATE TABLE `auth` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `permission` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `auth`
--

INSERT INTO `auth` (`id`, `activeFlag`, `createDate`, `permission`, `updateDate`, `menu_id`, `role_id`) VALUES
(71, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 1, 1),
(72, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 2, 1),
(73, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 3, 1),
(74, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 4, 1),
(75, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 5, 1),
(76, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 6, 1),
(77, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 7, 1),
(78, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 8, 1),
(79, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 9, 1),
(80, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 10, 1),
(81, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 11, 1),
(82, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 12, 1),
(83, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 13, 1),
(84, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 14, 1),
(85, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 15, 1),
(86, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 16, 1),
(87, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 17, 1),
(88, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 18, 1),
(89, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 19, 1),
(90, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 20, 1),
(91, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 21, 1),
(92, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 22, 1),
(93, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 23, 1),
(94, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 24, 1),
(95, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 25, 1),
(96, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 31, 1),
(97, 1, '2020-08-25 13:52:19', 1, '2020-08-25 13:52:19', 32, 1),
(98, 1, '2020-08-25 13:41:46', 1, '2020-08-25 13:41:46', 33, 1),
(99, 1, '2020-08-25 13:41:46', 1, '2020-08-25 13:41:46', 34, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `activeFlag`, `code`, `createDate`, `description`, `name`, `updateDate`) VALUES
(1, 1, 'SAMSUNG', '2020-08-28 00:00:00', 'Samsung from korea', 'Samsung', '2020-08-31 07:53:41'),
(2, 1, 'APPLE', '2020-08-28 00:00:00', 'apple from USA', 'Apple', '2020-08-31 07:53:52'),
(3, 1, 'Sony', '2020-08-28 00:00:00', 'sony from jappan', 'Sony', '2020-08-31 07:54:17'),
(4, 1, 'LG', '2020-08-28 16:57:13', 'LG from korea', 'LG', '2020-08-31 07:54:04'),
(5, 1, 'HW', '2020-08-30 19:55:09', 'Huwei from china', 'Huwei', '2020-08-30 19:55:09'),
(6, 1, 'VV', '2020-08-30 19:59:53', 'Vivo from china', 'Vivo', '2020-08-30 19:59:53'),
(7, 1, 'Oppo', '2020-08-30 20:17:17', 'Oppo from china', 'Oppo', '2020-08-30 21:29:05'),
(8, 0, 'LG1', '2020-08-30 20:47:43', 'apple from USA', 'Tam', '2020-08-30 20:47:51'),
(9, 0, 'APPLE11', '2020-08-30 20:52:12', 'LG from korea', 'Tam', '2020-08-30 21:14:52'),
(10, 0, 'APPLE1', '2020-08-30 21:29:19', 'apple from USA', 'Nguyễn Thị Việt Dung', '2020-08-30 21:29:21');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `actionName` varchar(255) DEFAULT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

INSERT INTO `invoice` (`id`, `activeFlag`, `code`, `createDate`, `price`, `qty`, `type`, `updateDate`, `PRODUCT_ID`) VALUES
(3, 1, 'APPLE1', '2020-09-03 14:00:57', '1550000.00', 14, 2, '2020-09-03 14:00:57', 14),
(4, 1, 'APPLE', '2020-09-03 14:05:47', '1250000.00', 13, 1, '2020-09-03 14:05:47', 14),
(5, 1, 'OPPO1', '2020-09-03 14:11:57', '12500000.00', 15, 1, '2020-09-03 14:11:57', 13),
(6, 1, 'APPLE2', '2020-09-03 14:14:28', '125000000.00', 17, 1, '2020-09-03 14:14:28', 13),
(7, 1, 'APPLE3', '2020-09-03 14:18:42', '125000000.00', 20, 1, '2020-09-03 14:18:42', 14),
(8, 1, 'APPLE4', '2020-09-03 14:20:57', '125000000.00', 26, 1, '2020-09-03 14:20:57', 14),
(9, 1, 'APPLE6', '2020-09-03 14:30:26', '125000000.00', 1566, 1, '2020-09-03 14:30:26', 14),
(10, 1, 'abc', '2020-09-03 14:34:56', '130000.00', 13, 1, '2020-09-03 14:34:56', 13),
(11, 1, 'OPPOReno31111', '2020-09-03 14:36:07', '13343434.00', 13, 1, '2020-09-03 14:36:07', 13),
(12, 1, 'OPPOReno31111323', '2020-09-03 14:46:56', '1250000.00', 13, 1, '2020-09-03 14:46:56', 13),
(13, 1, 'APPLE15', '2020-09-03 14:50:14', '1250000.00', 13, 1, '2020-09-03 14:50:14', 14),
(14, 1, 'OPPOReno322', '2020-09-03 14:51:16', '1421.00', 13, 1, '2020-09-03 14:51:16', 13),
(15, 1, 'OPPOReno3211', '2020-09-03 14:52:55', '13131331.00', 133, 1, '2020-09-03 14:52:55', 13),
(16, 1, 'OPPOReno33343', '2020-09-03 15:06:35', '12500000022.00', 1333, 1, '2020-09-03 15:06:35', 13),
(17, 1, 'OPPOReno3555', '2020-09-03 15:13:22', '23233.00', 13, 1, '2020-09-03 15:13:22', 13),
(18, 1, 'APPLE123', '2020-09-03 15:17:14', '13133.00', 131, 1, '2020-09-03 15:17:14', 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderIndex` int(11) NOT NULL,
  `parentId` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `menu`
--

INSERT INTO `menu` (`id`, `activeFlag`, `createDate`, `name`, `orderIndex`, `parentId`, `updateDate`, `url`) VALUES
(1, 1, '2020-08-25 13:41:23', 'Sản phẩm', 1, 0, '2020-08-25 13:41:46', '/product'),
(2, 1, '2020-08-25 13:41:23', 'Kho', 2, 0, '2020-08-25 13:41:46', '/stock'),
(3, 1, '2020-08-25 13:41:23', 'Quản lý', 3, 0, '2020-08-25 13:41:46', '/management'),
(4, 1, '2020-08-25 13:41:23', 'Danh sách sản phẩm', 2, 1, '2020-08-25 13:41:46', '/product-info/list'),
(5, 1, '2020-08-25 13:41:23', 'Danh sách category', 1, 1, '2020-08-25 13:41:46', '/category/list'),
(6, 1, '2020-08-25 13:41:23', 'Sửa', -1, 1, '2020-08-25 13:41:46', '/category/edit'),
(7, 1, '2020-08-25 13:41:23', 'Xem', -1, 1, '2020-08-25 13:41:46', '/category/view'),
(8, 1, '2020-08-25 13:41:23', 'Thêm mới', -1, 1, '2020-08-25 13:41:46', '/category/add'),
(9, 1, '2020-08-25 13:41:23', 'Lưu', -1, 1, '2020-08-25 13:41:46', '/category/save'),
(10, 1, '2020-08-25 13:41:23', 'Xóa', -1, 1, '2020-08-25 13:41:46', '/category/delete'),
(11, 1, '2020-08-25 13:41:23', 'Sửa', -1, 1, '2020-08-25 13:41:46', '/product-info/edit'),
(12, 1, '2020-08-25 13:41:23', 'Xem', -1, 1, '2020-08-25 13:41:46', '/product-info/view'),
(13, 1, '2020-08-25 13:41:23', 'Thêm mới', -1, 1, '2020-08-25 13:41:46', '/product-info/add'),
(14, 1, '2020-08-25 13:41:23', 'Lưu', -1, 1, '2020-08-25 13:41:46', '/product-info/save'),
(15, 1, '2020-08-25 13:41:23', 'Xóa', -1, 1, '2020-08-25 13:41:46', '/product-info/delete'),
(16, 1, '2020-08-25 13:41:23', 'Danh sách nhập kho', 1, 2, '2020-08-25 13:41:46', '/goods-receipt/list'),
(17, 1, '2020-08-25 13:41:23', 'Danh sách xuất kho', 2, 2, '2020-08-25 13:41:46', '/goods-issue/list'),
(18, 1, '2020-08-25 13:41:23', 'Sản phẩm trong kho', 3, 2, '2020-08-25 13:41:46', '/product-in-stock/list'),
(19, 1, '2020-08-25 13:41:23', 'Lịch sử kho', 4, 2, '2020-08-25 13:41:46', '/history/list'),
(20, 1, '2020-08-25 13:41:23', 'Danh sách user', 1, 3, '2020-08-25 13:41:46', '/user/list'),
(21, 1, '2020-08-25 13:41:23', 'Danh sách menu', 3, 3, '2020-08-25 13:41:46', '/menu/list'),
(22, 1, '2020-08-25 13:41:23', 'Danh sách quyền', 2, 3, '2020-08-25 13:41:46', '/role/list'),
(23, 1, '2020-08-25 13:41:23', 'Save', -1, 3, '2020-08-25 13:41:46', '/user/save'),
(24, 1, '2020-08-25 13:41:23', 'Edit', -1, 3, '2020-08-25 13:41:46', '/user/edit'),
(25, 1, '2020-08-25 13:41:23', 'View', -1, 3, '2020-08-25 13:41:46', '/user/view'),
(26, 1, '2020-08-25 13:41:23', 'Add', -1, 3, '2020-08-25 13:41:46', '/user/add'),
(27, 1, '2020-08-25 13:41:23', 'Save', -1, 3, '2020-08-25 13:41:46', '/role/save'),
(28, 1, '2020-08-25 13:41:23', 'Edit', -1, 3, '2020-08-25 13:41:46', '/role/edit'),
(29, 1, '2020-08-25 13:41:23', 'View', -1, 3, '2020-08-25 13:41:46', '/role/view'),
(30, 1, '2020-08-25 13:41:23', 'Add', -1, 3, '2020-08-25 13:41:46', '/role/add'),
(31, 1, '2020-09-03 08:23:15', 'Thêm mới', -1, 2, '2020-09-03 08:23:15', '/goods-issue/add'),
(32, 1, '2020-08-25 13:41:46', 'Thêm mới', -1, 2, '2020-08-25 13:41:46', '/goods-receipt/add'),
(33, 1, '2020-09-03 08:23:15', 'Save', -1, 2, '2020-09-03 08:23:15', '/goods-receipt/save'),
(34, 1, '2020-09-03 08:23:15', 'Save', -1, 2, '2020-09-03 08:23:15', '/goods-issue/save');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productinfo`
--

CREATE TABLE `productinfo` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `CATE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `productinfo`
--

INSERT INTO `productinfo` (`id`, `activeFlag`, `code`, `createDate`, `description`, `imgUrl`, `name`, `updateDate`, `CATE_ID`) VALUES
(13, 1, 'APPLEReno3', '2020-09-02 08:47:01', 'Điện thoại OPPO Reno3', '/images/1599011380936_oppo-reno3-trang-400x460-400x460.png', 'Điện thoại OPPO Reno3', '2020-09-02 08:54:10', 7),
(14, 1, ' iPhone 11 Pro Max 64GB', '2020-09-03 12:23:55', 'Camera được cải tiến mạnh mẽ', '/images/1599110635738_iphone-11-pro-max-black-400x460.png', 'Điện thoại iPhone 11 Pro Max 64GB', '2020-09-03 12:40:33', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productsinstock`
--

CREATE TABLE `productsinstock` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `productsinstock`
--

INSERT INTO `productsinstock` (`id`, `activeFlag`, `createDate`, `price`, `qty`, `updateDate`, `PRODUCT_ID`) VALUES
(1, 1, '2020-09-03 14:00:57', '279000000.00', 15, '2020-09-03 14:00:57', 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `activeFlag`, `createDate`, `description`, `roleName`, `updateDate`) VALUES
(1, 1, '2020-08-24 00:00:00', 'Admin of system', 'admin', '2020-08-24 00:00:00'),
(2, 1, '2020-08-24 00:00:00', 'Staff of system', 'staff', '2020-08-24 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `activeFlag`, `createDate`, `email`, `name`, `password`, `updateDate`, `userName`) VALUES
(1, 1, '2020-08-24 00:00:00', 'xomrayno5@gmail.com', 'Nguyen Chi Tam', '1234', '2020-08-24 00:00:00', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `usersrole`
--

CREATE TABLE `usersrole` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `usersrole`
--

INSERT INTO `usersrole` (`id`, `activeFlag`, `createDate`, `updateDate`, `role_id`, `users_id`) VALUES
(1, 1, '2020-08-25 13:55:50', '2020-08-25 13:55:50', 1, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfum0d6jnhosfl6y9k41ve6n9g` (`menu_id`),
  ADD KEY `FK3r30mkdo6hpqatfij7oo7oh6l` (`role_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqhvkmgweosid2o7s6ne12cxp4` (`PRODUCT_ID`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6kykls46km2jvm63r4my5nmn6` (`PRODUCT_ID`);

--
-- Chỉ mục cho bảng `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `productinfo`
--
ALTER TABLE `productinfo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiye8p584c5txpy1d3em55js9t` (`CATE_ID`);

--
-- Chỉ mục cho bảng `productsinstock`
--
ALTER TABLE `productsinstock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi4yu06jccvxv69lmjwai93ufs` (`PRODUCT_ID`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `usersrole`
--
ALTER TABLE `usersrole`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4v4kx00qalctqg3meby0wsevf` (`role_id`),
  ADD KEY `FKq6xwvd0fwwx5bv2dl1lyx6t0c` (`users_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `auth`
--
ALTER TABLE `auth`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT cho bảng `productinfo`
--
ALTER TABLE `productinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `productsinstock`
--
ALTER TABLE `productsinstock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `usersrole`
--
ALTER TABLE `usersrole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `auth`
--
ALTER TABLE `auth`
  ADD CONSTRAINT `FK3r30mkdo6hpqatfij7oo7oh6l` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKfum0d6jnhosfl6y9k41ve6n9g` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`);

--
-- Các ràng buộc cho bảng `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `FKqhvkmgweosid2o7s6ne12cxp4` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `productinfo` (`id`);

--
-- Các ràng buộc cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `FK6kykls46km2jvm63r4my5nmn6` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `productinfo` (`id`);

--
-- Các ràng buộc cho bảng `productinfo`
--
ALTER TABLE `productinfo`
  ADD CONSTRAINT `FKiye8p584c5txpy1d3em55js9t` FOREIGN KEY (`CATE_ID`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `productsinstock`
--
ALTER TABLE `productsinstock`
  ADD CONSTRAINT `FKi4yu06jccvxv69lmjwai93ufs` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `productinfo` (`id`),
  ADD CONSTRAINT `FKiaidrywjk178owkaf75rycttb` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `productinfo` (`id`);

--
-- Các ràng buộc cho bảng `usersrole`
--
ALTER TABLE `usersrole`
  ADD CONSTRAINT `FK4v4kx00qalctqg3meby0wsevf` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKq6xwvd0fwwx5bv2dl1lyx6t0c` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
