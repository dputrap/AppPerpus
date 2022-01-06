-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2022 at 06:35 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `noAnggota` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `kelas` varchar(11) NOT NULL,
  `ttl` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`noAnggota`, `nama`, `kelas`, `ttl`, `alamat`) VALUES
('10098', 'Tiara', 'IPA 1', 'Cirebon 17 Desember 2000', 'Cirebon'),
('12789', 'Danu', 'IPA 2', 'Jakarta 24 Februari 2002', 'Karawang');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `idBuku` varchar(11) NOT NULL,
  `namaBuku` varchar(255) NOT NULL,
  `stok` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`idBuku`, `namaBuku`, `stok`) VALUES
('IPA098', 'Buku Paket IPA Kelas 3', '100'),
('IPS078', 'Buku Paket IPS Kelas 1', '120');

-- --------------------------------------------------------

--
-- Table structure for table `datakunjungan`
--

CREATE TABLE `datakunjungan` (
  `noKunjung` int(11) NOT NULL,
  `noAnggota` varchar(255) NOT NULL,
  `tglKunjung` varchar(255) NOT NULL,
  `tujuanKunjung` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datakunjungan`
--

INSERT INTO `datakunjungan` (`noKunjung`, `noAnggota`, `tglKunjung`, `tujuanKunjung`) VALUES
(6, '12789', '7 Juli 2021', 'Membaca'),
(7, '10098', '20 Maret 2021', 'Ngadem');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `idPinjam` int(11) NOT NULL,
  `noAnggota` varchar(255) NOT NULL,
  `idBuku` varchar(255) NOT NULL,
  `statusBuku` varchar(255) NOT NULL,
  `tglPinjam` varchar(255) NOT NULL,
  `durasiPinjam` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`idPinjam`, `noAnggota`, `idBuku`, `statusBuku`, `tglPinjam`, `durasiPinjam`) VALUES
(1, '10098', 'IPA098', 'Dipinjam', '24 Desember 2021', '7 Hari'),
(2, '12789', 'IPS078', 'Dipinjam', '25 Desember 2021', '7 Hari');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `idPengembalian` int(11) NOT NULL,
  `idPinjam` int(11) NOT NULL,
  `noAnggota` varchar(255) NOT NULL,
  `idBuku` varchar(255) NOT NULL,
  `statusBuku` varchar(255) NOT NULL,
  `tglPengembalian` varchar(255) NOT NULL,
  `denda` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`idPengembalian`, `idPinjam`, `noAnggota`, `idBuku`, `statusBuku`, `tglPengembalian`, `denda`) VALUES
(1, 1, '10098', 'IPA098', 'Kembali', '3 Januari 2022', '5000');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `level` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `level`) VALUES
('admin', 'admin123', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`noAnggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`idBuku`);

--
-- Indexes for table `datakunjungan`
--
ALTER TABLE `datakunjungan`
  ADD PRIMARY KEY (`noKunjung`),
  ADD UNIQUE KEY `noAnggota` (`noAnggota`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`idPinjam`),
  ADD UNIQUE KEY `noAnggota` (`noAnggota`),
  ADD UNIQUE KEY `idBuku` (`idBuku`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`idPengembalian`),
  ADD UNIQUE KEY `noAnggota` (`noAnggota`),
  ADD UNIQUE KEY `idBuku` (`idBuku`),
  ADD UNIQUE KEY `idPinjam` (`idPinjam`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datakunjungan`
--
ALTER TABLE `datakunjungan`
  MODIFY `noKunjung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `idPinjam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `idPengembalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `datakunjungan`
--
ALTER TABLE `datakunjungan`
  ADD CONSTRAINT `datakunjungan_ibfk_1` FOREIGN KEY (`noAnggota`) REFERENCES `anggota` (`noAnggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`noAnggota`) REFERENCES `anggota` (`noAnggota`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`idBuku`) REFERENCES `buku` (`idBuku`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`idPinjam`) REFERENCES `peminjaman` (`idPinjam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`noAnggota`) REFERENCES `anggota` (`noAnggota`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pengembalian_ibfk_3` FOREIGN KEY (`idBuku`) REFERENCES `buku` (`idBuku`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
