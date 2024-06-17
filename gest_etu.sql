-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2022 at 09:53 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gest_etu`
--

-- --------------------------------------------------------

--
-- Table structure for table `decanat`
--

CREATE TABLE `decanat` (
  `MAT_D` varchar(15) NOT NULL,
  `LIBELLE` varchar(15) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `NUTIL` varchar(15) NOT NULL,
  `MP` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `etudiants`
--

CREATE TABLE `etudiants` (
  `MAT` varchar(15) NOT NULL,
  `NOM` varchar(15) NOT NULL,
  `POSTNOM` varchar(15) NOT NULL,
  `PRENOM` varchar(15) NOT NULL,
  `SEXE` varchar(15) NOT NULL,
  `TEL` varchar(15) NOT NULL,
  `ADRESSE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `etudiants`
--

INSERT INTO `etudiants` (`MAT`, `NOM`, `POSTNOM`, `PRENOM`, `SEXE`, `TEL`, `ADRESSE`) VALUES
('1641314223K', 'MANANDA', 'KALULU', 'MODRIC', 'M', '12323', 'SIBAYA');

-- --------------------------------------------------------

--
-- Table structure for table `progres`
--

CREATE TABLE `progres` (
  `ID_PROGRES` smallint(6) NOT NULL AUTO_INCREMENT,
  `LIBELLE` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `suivie`
--

CREATE TABLE `suivie` (
  `ID_SUIVIE` varchar(15) NOT NULL,
  `MAT_D` varchar(15) NOT NULL,
  `MAT` varchar(15) NOT NULL,
  `ID_PROGRES` smallint(6) NOT NULL,
  `Pourcentage` varchar(15) DEFAULT NULL,
  `MENTION` varchar(15) DEFAULT NULL,
  `PROMOTION` varchar(15) DEFAULT NULL,
  `FACULTE` varchar(15) DEFAULT NULL,
  `PAYER_FRAIS` varchar(5) NOT NULL,
  `FINIR_ANNEE` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `decanat`
--
ALTER TABLE `decanat`
  ADD PRIMARY KEY (`MAT_D`);

--
-- Indexes for table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`MAT`);

--
-- Indexes for table `progres`
--
ALTER TABLE `progres`
  ADD PRIMARY KEY (`ID_PROGRES`);

--
-- Indexes for table `suivie`
--
ALTER TABLE `suivie`
  ADD PRIMARY KEY (`ID_SUIVIE`),
  ADD KEY `FK_CONCERNER` (`MAT`),
  ADD KEY `FK_DECRIRE` (`ID_PROGRES`),
  ADD KEY `FK_DECRIRE2` (`MAT_D`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `suivie`
--
ALTER TABLE `suivie`
  ADD CONSTRAINT `FK_CONCERNER` FOREIGN KEY (`MAT`) REFERENCES `etudiants` (`MAT`),
  ADD CONSTRAINT `FK_DECRIRE` FOREIGN KEY (`ID_PROGRES`) REFERENCES `progres` (`ID_PROGRES`),
  ADD CONSTRAINT `FK_DECRIRE2` FOREIGN KEY (`MAT_D`) REFERENCES `decanat` (`MAT_D`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
