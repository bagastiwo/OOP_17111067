-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2018 at 07:04 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_17111067`
--

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `id_gaji` varchar(3) NOT NULL,
  `nominal_gaji` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id_gaji`, `nominal_gaji`) VALUES
('111', '9.999.999'),
('222', '7.000.000'),
('333', '5.000.000');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` varchar(3) NOT NULL,
  `nama_Jabatan` varchar(20) NOT NULL,
  `id_gaji` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama_Jabatan`, `id_gaji`) VALUES
('001', 'CEO', '111'),
('002', 'Manajer Direktur', '222'),
('003', 'Manager HR', '333');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `noHp` varchar(13) NOT NULL,
  `id_Jabatan` varchar(3) NOT NULL,
  `id_wilayahKerja` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama`, `alamat`, `noHp`, `id_Jabatan`, `id_wilayahKerja`) VALUES
('192', 'bagas', 'banjarbaru', '081234567890', '001', '521'),
('193', 'Novi', 'Amuntai', '081122223333', '002', '524'),
('194', 'Bambang', 'Banjarmasin', '089988887777', '003', '521');

-- --------------------------------------------------------

--
-- Table structure for table `wilayahkerja`
--

CREATE TABLE `wilayahkerja` (
  `id_wilayahKerja` varchar(3) NOT NULL,
  `nama_wilayahKerja` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wilayahkerja`
--

INSERT INTO `wilayahkerja` (`id_wilayahKerja`, `nama_wilayahKerja`) VALUES
('521', 'Banjarmasin'),
('522', 'Kandangan'),
('523', 'Barabai'),
('524', 'Amuntai');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`id_gaji`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`),
  ADD KEY `id_gaji` (`id_gaji`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `id_Jabatan` (`id_Jabatan`),
  ADD KEY `id_wilayahKerja` (`id_wilayahKerja`);

--
-- Indexes for table `wilayahkerja`
--
ALTER TABLE `wilayahkerja`
  ADD PRIMARY KEY (`id_wilayahKerja`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD CONSTRAINT `jabatan_ibfk_1` FOREIGN KEY (`id_gaji`) REFERENCES `gaji` (`id_gaji`);

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`id_Jabatan`) REFERENCES `jabatan` (`id_jabatan`),
  ADD CONSTRAINT `pegawai_ibfk_2` FOREIGN KEY (`id_wilayahKerja`) REFERENCES `wilayahkerja` (`id_wilayahKerja`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
