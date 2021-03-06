-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.3.7-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 flowt 的数据库结构
CREATE DATABASE IF NOT EXISTS `flowt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flowt`;

-- 导出  表 flowt.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `CustomerId` bigint(20) NOT NULL AUTO_INCREMENT,
  `CustomerName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CustomerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.customer 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 导出  表 flowt.datasyncmessage 结构
CREATE TABLE IF NOT EXISTS `datasyncmessage` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Memo` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `SqlText` varchar(255) DEFAULT NULL,
  `UpdateSqlText` varchar(255) DEFAULT NULL,
  `SqlMessageNo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_h2jjsf9ymdcjxcjjhd6uiixm7` (`SqlMessageNo`),
  CONSTRAINT `FK_h2jjsf9ymdcjxcjjhd6uiixm7` FOREIGN KEY (`SqlMessageNo`) REFERENCES `sqlmessage` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.datasyncmessage 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `datasyncmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `datasyncmessage` ENABLE KEYS */;

-- 导出  表 flowt.exceltable 结构
CREATE TABLE IF NOT EXISTS `exceltable` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `IsSplitTable` int(11) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `SqlText` text DEFAULT NULL,
  `TableName` varchar(255) DEFAULT NULL,
  `CodeIcon` varchar(255) DEFAULT NULL,
  `DeptIcon` varchar(255) DEFAULT NULL,
  `FinishDateIcon` varchar(255) DEFAULT NULL,
  `StartDateIcon` varchar(255) DEFAULT NULL,
  `SqlMessageNo` bigint(20) DEFAULT NULL,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`Id`),
  KEY `FK_oa8ad3qwa6roswfyuiot214q2` (`SqlMessageNo`),
  CONSTRAINT `FK_oa8ad3qwa6roswfyuiot214q2` FOREIGN KEY (`SqlMessageNo`) REFERENCES `sqlmessage` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.exceltable 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `exceltable` DISABLE KEYS */;
INSERT IGNORE INTO `exceltable` (`Id`, `IsSplitTable`, `Memo`, `SqlText`, `TableName`, `CodeIcon`, `DeptIcon`, `FinishDateIcon`, `StartDateIcon`, `SqlMessageNo`, `CreateDate`, `UpdateDate`) VALUES
	(1, 0, '', 'select a.id as 翼闸编号,c.Code as 工号,c.Name as 姓名,convert(varchar(30),a.Data_datetime,20) as 打卡时间 ,convert(varchar(10),b.Clock_id)+b.Clock_name as\'考勤机和门闸\'\r\nfrom attend_data a \r\nleft join ICCO_Clockskq b on a.ID = b.Clock_id \r\nleft join ZlEmployee c on  a.WorkNo=c.Code --a.workid=c.cardno\r\nleft join zldept d on c.Dept = d.Code\r\nwhere\r\nc.Dept like \'@Dept\'+\'%\' and \r\na.Data_datetime between \'@StartTime\' and  \'@FinishTime\'+\' 23:59:59.000\'  and\r\na.id in (\'6322\',\'6300\',\'5014\',\'6264\',\'6344\',\'6216\',\'6211\',\'6207\',\'6329\',\'6326\',\'6348\',\'6350\',\'6289\',\'6282\',\'6464\',\'6451\',\'6351\')\r\norder by a.Data_datetime,b.Clock_id desc\r\n', 'test', '', '@Dept', '@FinishTime', '@StartTime', 1, '2018-07-13 14:17:45', '2018-07-13 14:17:45');
/*!40000 ALTER TABLE `exceltable` ENABLE KEYS */;

-- 导出  表 flowt.hqlmessage 结构
CREATE TABLE IF NOT EXISTS `hqlmessage` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Hql` varchar(255) DEFAULT NULL,
  `KeyMap` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `ActionName` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.hqlmessage 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `hqlmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `hqlmessage` ENABLE KEYS */;

-- 导出  表 flowt.interceptedlog 结构
CREATE TABLE IF NOT EXISTS `interceptedlog` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DateTime` datetime DEFAULT NULL,
  `Ip` varchar(255) DEFAULT NULL,
  `UrI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.interceptedlog 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `interceptedlog` DISABLE KEYS */;
INSERT IGNORE INTO `interceptedlog` (`Id`, `DateTime`, `Ip`, `UrI`) VALUES
	(1, NULL, '192.168.117.189', '/Flowt/TxCode'),
	(2, NULL, '192.168.80.186', '/Flowt/TxCode');
/*!40000 ALTER TABLE `interceptedlog` ENABLE KEYS */;

-- 导出  表 flowt.logmessage 结构
CREATE TABLE IF NOT EXISTS `logmessage` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ActionTime` datetime DEFAULT NULL,
  `Message` varchar(255) DEFAULT NULL,
  `UserId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.logmessage 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `logmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `logmessage` ENABLE KEYS */;

-- 导出  表 flowt.menu 结构
CREATE TABLE IF NOT EXISTS `menu` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Memo` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `OrderNo` int(11) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `OrderBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.menu 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT IGNORE INTO `menu` (`Id`, `Memo`, `Name`, `OrderNo`, `Title`, `OrderBy`) VALUES
	(1, '系统设置', '系统设置', 0, '系统设置', 0),
	(8, '菜单设置', '菜单设置', 1, '菜单设置', 0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 导出  表 flowt.message 结构
CREATE TABLE IF NOT EXISTS `message` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `KeyValue` varchar(255) DEFAULT NULL,
  `MessageValue` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.message 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- 导出  表 flowt.messagetable 结构
CREATE TABLE IF NOT EXISTS `messagetable` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Memo` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  `OrderNo` int(11) DEFAULT NULL,
  `Menu_id` bigint(20) DEFAULT NULL,
  `Tip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_aayjedu9m054so23lv4l4boky` (`Menu_id`),
  CONSTRAINT `FK_aayjedu9m054so23lv4l4boky` FOREIGN KEY (`Menu_id`) REFERENCES `menu` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.messagetable 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `messagetable` DISABLE KEYS */;
INSERT IGNORE INTO `messagetable` (`Id`, `Memo`, `Name`, `Type`, `Title`, `Url`, `OrderNo`, `Menu_id`, `Tip`) VALUES
	(1, NULL, 'Computer', 'Basic', '准入IP地址设置', '/PageIndex/IndexPage/Computer', 0, 1, '说明:<br/>1.系统登录时会进行Ip检查，准入IP里没有信息是不可以访问的<br/>2.查询功能可查询所有列'),
	(2, NULL, 'User', 'Other', '用户设置', '/User/IndexPage', 0, 1, NULL),
	(3, NULL, 'Menu', 'Basic', '菜单管理', '/PageIndex/IndexPage/Menu', 0, 8, '说明:<br/>1.顺序编号值越越靠前'),
	(4, NULL, 'MessageTable', 'Basic', '子菜单管理', '/PageIndex/IndexPage/MessageTable', 0, 8, '说明:<br/>1.顺序编号值越越靠前'),
	(6, NULL, 'MessageTableDetial', 'Basic', '菜单明细', '/PageIndex/IndexPage/MessageTableDetial', 0, 8, ''),
	(9, NULL, 'MessageTableAction', 'Basic', '子菜单请求', '/PageIndex/IndexPage/MessageTableAction', 0, 8, ''),
	(10, NULL, 'Role', 'Basic', '权限管理', '/PageIndex/IndexPage/Role', 0, 1, NULL);
/*!40000 ALTER TABLE `messagetable` ENABLE KEYS */;

-- 导出  表 flowt.messagetableaction 结构
CREATE TABLE IF NOT EXISTS `messagetableaction` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ActionName` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  `MessageTable_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_n7wpqnj2yubnjt6xlgahg1vkj` (`MessageTable_id`),
  CONSTRAINT `FK_n7wpqnj2yubnjt6xlgahg1vkj` FOREIGN KEY (`MessageTable_id`) REFERENCES `messagetable` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.messagetableaction 的数据：~56 rows (大约)
/*!40000 ALTER TABLE `messagetableaction` DISABLE KEYS */;
INSERT IGNORE INTO `messagetableaction` (`Id`, `ActionName`, `Name`, `Type`, `Url`, `MessageTable_id`) VALUES
	(1, 'Computer', '查询所有', 'Find', '/Computer/FindAll', 1),
	(2, 'Computer', '显示详细信息', 'Show', '/Computer/FindById', 1),
	(3, 'Computer', '删除信息', 'Del', '/Computer/Del', 1),
	(4, 'Computer', '增加页面', 'AddPage', '/Page/AddPage', 1),
	(5, 'Computer', '编辑页面', 'EditPage', '/Computer/FindById', 1),
	(6, 'Computer', '增加信息', 'Add', '/Computer/Add', 1),
	(7, 'Computer', '编辑信息', 'Edit', '/Computer/Update', 1),
	(8, 'Computer', '按条件查询', 'FindByKey', '/Computer/FindAll', 1),
	(9, 'User', '增加页面', 'AddPage', '/Page/AddPage', 2),
	(10, 'User', '查询所有', 'Find', '/User/FindAll', 2),
	(11, 'User', '按条件查询', 'FindByKey', '/User/FindByKey', 2),
	(12, 'User', '显示详细信息', 'Show', '/User/FindById', 2),
	(13, 'User', '编辑页面', 'EditPage', '/User/FindById', 2),
	(14, 'User', '删除信息', 'Del', '/User/Del', 2),
	(15, 'User', '增加信息', 'Add', '/User/Add', 2),
	(16, 'User', '修改信息', 'Edit', '/User/Update', 2),
	(17, 'Menu', '查询所有', 'Find', '/Menu/FindAll', 3),
	(18, 'Menu', '显示详细信息', 'Show', '/Menu/FindById', 3),
	(19, 'Menu', '增加页面', 'AddPage', '/Page/AddPage?ActionName=Menu', 3),
	(20, 'Menu', '新增数据', 'Add', '/Menu/Add', 3),
	(21, 'Menu', '删除信息', 'Del', '/Menu/Del', 3),
	(22, 'Menu', '修改页面', 'EditPage', '/Menu/FindById', 3),
	(23, 'Menu', '修改数据', 'Edit', '/Menu/Edit', 3),
	(24, 'Menu', '按条件查询', 'FindByKey', '/Menu/FindByKey', 3),
	(25, 'MessageTable', '查询所有', 'Find', '/MessageTable/FindAll', 4),
	(26, 'MessageTable', '显示详细信息', 'Show', '/MessageTable/FindById', 4),
	(27, 'MessageTable', '增加页面', 'AddPage', '/Page/AddPage', 4),
	(28, 'MessageTable', '新增数据', 'Add', '/MessageTable/Add', 4),
	(29, 'MessageTable', '删除信息', 'Del', '/MessageTable/Del', 4),
	(30, 'MessageTable', '修改页面', 'EditPage', '/MessageTable/FindById', 4),
	(31, 'MessageTable', '修改数据', 'Edit', '/MessageTable/Edit', 4),
	(32, 'MessageTable', '按条件查询', 'FindByKey', '/MessageTable/FindByKey', 4),
	(55, 'MessageTableDetial', '查询所有', 'Find', '/MessageTableDetial/FindAll', 6),
	(56, 'MessageTableDetial', '显示详细信息', 'Show', '/MessageTableDetial/FindById', 6),
	(57, 'MessageTableDetial', '增加页面', 'AddPage', '/Page/AddPage', 6),
	(58, 'MessageTableDetial', '新增数据', 'Add', '/MessageTableDetial/Add', 6),
	(59, 'MessageTableDetial', '删除信息', 'Del', '/MessageTableDetial/Del', 6),
	(60, 'MessageTableDetial', '修改页面', 'EditPage', '/MessageTableDetial/FindById', 6),
	(61, 'MessageTableDetial', '修改数据', 'Edit', '/MessageTableDetial/Edit', 6),
	(62, 'MessageTableDetial', '按条件查询', 'FindByKey', '/MessageTableDetial/FindByKey', 6),
	(70, 'MessageTableAction', '查询所有', 'Find', '/MessageTableAction/FindAll', 9),
	(71, 'MessageTableAction', '显示详细信息', 'Show', '/MessageTableAction/FindById', 9),
	(72, 'MessageTableAction', '增加页面', 'AddPage', '/Page/AddPage?ActionName=Menu', 9),
	(73, 'MessageTableAction', '新增数据', 'Add', '/MessageTableAction/Add', 9),
	(74, 'MessageTableAction', '删除信息', 'Del', '/MessageTableAction/Del', 9),
	(75, 'MessageTableAction', '修改页面', 'EditPage', '/MessageTableAction/FindById', 9),
	(76, 'MessageTableAction', '修改数据', 'Edit', '/MessageTableAction/Edit', 9),
	(77, 'MessageTableAction', '按条件查询', 'FindByKey', '/MessageTableAction/FindByKey', 9),
	(85, 'Role', '查询所有', 'Find', '/Role/FindAll', 10),
	(86, 'Role', '显示详细信息', 'Show', '/Role/FindById', 10),
	(87, 'Role', '增加页面', 'AddPage', '/Page/AddPage?ActionName=Menu', 10),
	(88, 'Role', '新增数据', 'Add', '/Role/Add', 10),
	(89, 'Role', '删除信息', 'Del', '/Role/Del', 10),
	(90, 'Role', '修改页面', 'EditPage', '/Role/FindById', 10),
	(91, 'Role', '修改数据', 'Edit', '/Role/Edit', 10),
	(92, 'Role', '按条件查询', 'FindByKey', '/Role/FindByKey', 10);
/*!40000 ALTER TABLE `messagetableaction` ENABLE KEYS */;

-- 导出  表 flowt.messagetabledetial 结构
CREATE TABLE IF NOT EXISTS `messagetabledetial` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `KeyName` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `MessageTable_id` bigint(20) DEFAULT NULL,
  `OrderNo` int(11) NOT NULL DEFAULT 0,
  `IsAdd` int(11) NOT NULL DEFAULT 0,
  `IsEdit` int(11) NOT NULL DEFAULT 0,
  `IsShow` int(11) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`Id`),
  KEY `FK_16brbwxm07jialhapfje9l5yr` (`MessageTable_id`),
  CONSTRAINT `FK_16brbwxm07jialhapfje9l5yr` FOREIGN KEY (`MessageTable_id`) REFERENCES `messagetable` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.messagetabledetial 的数据：~39 rows (大约)
/*!40000 ALTER TABLE `messagetabledetial` DISABLE KEYS */;
INSERT IGNORE INTO `messagetabledetial` (`Id`, `KeyName`, `Name`, `Title`, `MessageTable_id`, `OrderNo`, `IsAdd`, `IsEdit`, `IsShow`) VALUES
	(1, 'id', 'Id', 'Id', 2, 0, 0, 1, 1),
	(2, 'userName', 'UserName', '用户名', 2, 0, 1, 1, 1),
	(3, 'password', 'Password', '密码', 2, 0, 1, 1, 1),
	(4, 'createDate', 'CreateDate', '创建时间', 2, 0, 0, 0, 1),
	(5, 'updateDate', 'UpdateDate', '更新时间', 2, 0, 0, 0, 1),
	(6, 'id', 'Id', 'Id', 1, 0, 0, 1, 1),
	(7, 'loginName', 'LoginName', '登录名', 1, 0, 1, 1, 1),
	(8, 'ip', 'Ip', 'Ip', 1, 0, 1, 1, 1),
	(9, 'userCode', 'UserCode', '账号编码', 1, 0, 0, 0, 1),
	(10, 'userName', 'UserName', '账号名称', 1, 0, 0, 0, 1),
	(11, 'id', 'Id', 'Id', 3, 0, 0, 1, 1),
	(12, 'name', 'Name', '名称', 3, 0, 1, 1, 1),
	(13, 'title', 'Title', '标题', 3, 0, 1, 1, 1),
	(14, 'memo', 'Memo', '备注', 3, 0, 1, 1, 1),
	(15, 'orderBy', 'OrderBy', '顺序编号', 3, 0, 1, 1, 1),
	(16, 'id', 'Id', 'Id', 4, 0, 0, 0, 1),
	(17, 'name', 'Name', '名称', 4, 0, 1, 1, 1),
	(18, 'type', 'Type', '类型', 4, 0, 1, 1, 1),
	(20, 'url', 'Url', '链接', 4, 0, 1, 1, 1),
	(21, 'title', 'Title', '标题', 4, 1, 1, 1, 1),
	(22, 'orderNo', 'OrderNo', '顺序编号', 4, 1, 1, 1, 1),
	(23, 'tip', 'Tip', '提示', 4, 0, 1, 1, 1),
	(24, 'upMenu', '', '上级菜单', 4, 0, 0, 0, 1),
	(25, 'id', 'Id', 'Id', 6, 0, 0, 1, 1),
	(26, 'name', 'Name', '名称', 6, 0, 1, 1, 1),
	(27, 'title', 'Title', '标题', 6, 0, 1, 1, 1),
	(28, 'isEdit', 'IsEdit', '是否编辑', 6, 0, 1, 1, 1),
	(29, 'orderNo', 'OrderNo', '顺序编号', 6, 0, 1, 1, 1),
	(32, 'keyName', 'KeyName', '关键字', 6, 0, 1, 1, 1),
	(33, 'isAdd', 'IsAdd', '是否新增', 6, 0, 1, 1, 1),
	(34, 'isShow', 'IsShow', '是否显示详细信息', 6, 0, 1, 1, 1),
	(35, 'id', 'Id', 'Id', 9, 0, 0, 1, 1),
	(36, 'type', 'Type', '类型', 9, 0, 1, 1, 1),
	(37, 'name', 'Name', '名称', 9, 0, 1, 1, 1),
	(38, 'ActionName', 'ActionName', '请求名', 9, 0, 1, 1, 1),
	(39, 'url', 'Url', 'Url', 9, 0, 1, 1, 1),
	(42, 'id', 'Id', 'Id', 10, 0, 1, 1, 1),
	(43, 'roleName', 'RoleName', '权限名称', 10, 0, 1, 1, 1),
	(44, 'memo', 'Memo', '备注', 10, 0, 1, 1, 1);
/*!40000 ALTER TABLE `messagetabledetial` ENABLE KEYS */;

-- 导出  表 flowt.orders 结构
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderId` bigint(20) NOT NULL AUTO_INCREMENT,
  `OrderName` varchar(255) DEFAULT NULL,
  `Customer_Id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FK_l6s3w8ix8y7ff10xgbuuwwwx9` (`Customer_Id`),
  CONSTRAINT `FK_l6s3w8ix8y7ff10xgbuuwwwx9` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`CustomerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.orders 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- 导出  表 flowt.pass_computer 结构
CREATE TABLE IF NOT EXISTS `pass_computer` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Ip` varchar(255) DEFAULT NULL,
  `LoginName` varchar(255) DEFAULT NULL,
  `UserCode` varchar(255) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.pass_computer 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `pass_computer` DISABLE KEYS */;
INSERT IGNORE INTO `pass_computer` (`Id`, `Ip`, `LoginName`, `UserCode`, `UserName`) VALUES
	(10, '192.168.80.186', 'p00848', 'Admin', 'Admin'),
	(15, '127.0.0.1', 'test1', 'Admin', 'Admin');
/*!40000 ALTER TABLE `pass_computer` ENABLE KEYS */;

-- 导出  表 flowt.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Memo` varchar(255) DEFAULT NULL,
  `RoleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.role 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT IGNORE INTO `role` (`id`, `Memo`, `RoleName`) VALUES
	(1, '管理员', 'admin'),
	(4, '普通用户', 'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 flowt.sqlmessage 结构
CREATE TABLE IF NOT EXISTS `sqlmessage` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `DatabaseName` varchar(255) DEFAULT NULL,
  `Ip` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  `UpdateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `UserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UK_hdktuedwisw8lglcdq5o429k` (`Memo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.sqlmessage 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sqlmessage` DISABLE KEYS */;
INSERT IGNORE INTO `sqlmessage` (`Id`, `CreateDate`, `DatabaseName`, `Ip`, `Memo`, `Password`, `Type`, `UpdateDate`, `UserName`) VALUES
	(1, '2018-06-08 10:00:29', 'TxCard', '192.168.117.20\\tong', '117.20人事数据库', 'app#%(app23', 2, '2018-06-08 10:00:29', 'tx_app');
/*!40000 ALTER TABLE `sqlmessage` ENABLE KEYS */;

-- 导出  表 flowt.systemtype 结构
CREATE TABLE IF NOT EXISTS `systemtype` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `SystemKey` varchar(255) DEFAULT NULL,
  `SystemName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.systemtype 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `systemtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `systemtype` ENABLE KEYS */;

-- 导出  表 flowt.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `Password` varchar(255) DEFAULT NULL,
  `UpdateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `UserName` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  `Role_Id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_3yhggk8adpg8mwaiiqj4nitnx` (`Role_Id`),
  CONSTRAINT `FK_3yhggk8adpg8mwaiiqj4nitnx` FOREIGN KEY (`Role_Id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.sys_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT IGNORE INTO `sys_user` (`Id`, `CreateDate`, `Password`, `UpdateDate`, `UserName`, `Role`, `Role_Id`) VALUES
	(1, '2018-06-19 13:38:53', 'admin', '2018-06-19 13:38:53', 'admin', '1', 1),
	(8, '2018-08-02 11:59:49', 'test', '2018-08-02 11:59:49', 'test', '1', 1);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 flowt.user_1 结构
CREATE TABLE IF NOT EXISTS `user_1` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `Password` varchar(255) DEFAULT NULL,
  `UpdateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `UserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.user_1 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_1` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_1` ENABLE KEYS */;

-- 导出  表 flowt.vuemenuitem 结构
CREATE TABLE IF NOT EXISTS `vuemenuitem` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Icon` varchar(255) DEFAULT NULL,
  `IndexName` varchar(255) DEFAULT NULL,
  `OrderNo` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Uri` varchar(255) DEFAULT NULL,
  `VueTable_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_t1ioxxynvob3a93ry6ji1wvgx` (`VueTable_id`),
  CONSTRAINT `FK_t1ioxxynvob3a93ry6ji1wvgx` FOREIGN KEY (`VueTable_id`) REFERENCES `vuetable` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.vuemenuitem 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `vuemenuitem` DISABLE KEYS */;
INSERT IGNORE INTO `vuemenuitem` (`Id`, `Icon`, `IndexName`, `OrderNo`, `Title`, `Uri`, `VueTable_id`) VALUES
	(1, '', 'user', '0', '用户管理', '', 1);
/*!40000 ALTER TABLE `vuemenuitem` ENABLE KEYS */;

-- 导出  表 flowt.vuetable 结构
CREATE TABLE IF NOT EXISTS `vuetable` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Icon` varchar(255) DEFAULT NULL,
  `Ttile` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  flowt.vuetable 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `vuetable` DISABLE KEYS */;
INSERT IGNORE INTO `vuetable` (`Id`, `Icon`, `Ttile`, `Title`) VALUES
	(1, 'el-icon-setting', NULL, '系统设置'),
	(2, 'el-icon-document', NULL, '菜单设置');
/*!40000 ALTER TABLE `vuetable` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
