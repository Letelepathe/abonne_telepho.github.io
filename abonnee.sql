-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2022 at 10:18 AM
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
-- Database: `abonnee`
--

-- --------------------------------------------------------

--
-- Table structure for table `abonnees`
--

CREATE TABLE `abonnees` (
  `NOMCOMPLET` varchar(50) NOT NULL,
  `ADRESSE` varchar(50) NOT NULL,
  `AGE` varchar(99) NOT NULL,
  `SEXE` varchar(15) NOT NULL,
  `TEL` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `abonnees`
--

INSERT INTO `abonnees` (`NOMCOMPLET`, `ADRESSE`, `AGE`, `SEXE`, `TEL`) VALUES
('MALUNDU OLOFINDJANA', 'KATULUSI 33R Q/MPINDI C/KALAMU', '35', 'F', '082-504-432'),
('FABRICE ISOLOKE', 'MAKALA 34BIS', '45', 'M', '084-030-373'),
('KABUNDU LOLOLA', 'KINSUKA', '38', 'F', '085-534-474');

-- --------------------------------------------------------

--
-- Table structure for table `appel`
--

CREATE TABLE `appel` (
  `ID_APP` int(11) NOT NULL,
  `ID_TYPE` int(11) NOT NULL,
  `TEL` varchar(15) NOT NULL,
  `MINUTES` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appel`
--

INSERT INTO `appel` (`ID_APP`, `ID_TYPE`, `TEL`, `MINUTES`) VALUES
(1, 3, '082-504-432', '2');

-- --------------------------------------------------------

--
-- Table structure for table `forfait_internet`
--

CREATE TABLE `forfait_internet` (
  `ID_NET` int(11) NOT NULL,
  `TEL` varchar(15) NOT NULL,
  `ID_TYPE` int(11) DEFAULT NULL,
  `CAPACITE` varchar(15) NOT NULL,
  `TYPE_FI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `forfait_internet`
--

INSERT INTO `forfait_internet` (`ID_NET`, `TEL`, `ID_TYPE`, `CAPACITE`, `TYPE_FI`) VALUES
(1, '084-030-373', NULL, '100', 'BUTU ETANA TE');

-- --------------------------------------------------------

--
-- Table structure for table `forfait_sms`
--

CREATE TABLE `forfait_sms` (
  `ID_SMS` smallint(6) NOT NULL,
  `TEL` varchar(15) NOT NULL,
  `ID_TYPE` int(11) NOT NULL,
  `NBRE` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `forfait_sms`
--

INSERT INTO `forfait_sms` (`ID_SMS`, `TEL`, `ID_TYPE`, `NBRE`) VALUES
(2, '082-504-432', 1, '300'),
(4, '082-504-432', 1, '500');

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE `types` (
  `ID_TYPE` int(11) NOT NULL,
  `SMS` varchar(15) DEFAULT NULL,
  `APPELL` varchar(15) DEFAULT NULL,
  `DUREE` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`ID_TYPE`, `SMS`, `APPELL`, `DUREE`) VALUES
(1, 'TOUT_RESEAU', '', '24H'),
(2, 'RESEAU_LOCAL', '', '24H'),
(3, '', 'TOUT_RESEAU', '24H'),
(4, '', 'MASOLO_NA_VOISI', '24H');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abonnees`
--
ALTER TABLE `abonnees`
  ADD PRIMARY KEY (`TEL`);

--
-- Indexes for table `appel`
--
ALTER TABLE `appel`
  ADD PRIMARY KEY (`ID_APP`),
  ADD KEY `FK_ACTIVER3` (`TEL`),
  ADD KEY `FK_CONCERNER` (`ID_TYPE`);

--
-- Indexes for table `forfait_internet`
--
ALTER TABLE `forfait_internet`
  ADD PRIMARY KEY (`ID_NET`),
  ADD KEY `FK_ACTIVER1` (`TEL`),
  ADD KEY `FK_FORFAIT_TYPE` (`ID_TYPE`);

--
-- Indexes for table `forfait_sms`
--
ALTER TABLE `forfait_sms`
  ADD PRIMARY KEY (`ID_SMS`),
  ADD KEY `FK_ACTIVER2` (`TEL`),
  ADD KEY `FK_CORRESPOND` (`ID_TYPE`);

--
-- Indexes for table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`ID_TYPE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appel`
--
ALTER TABLE `appel`
  MODIFY `ID_APP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `forfait_internet`
--
ALTER TABLE `forfait_internet`
  MODIFY `ID_NET` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `forfait_sms`
--
ALTER TABLE `forfait_sms`
  MODIFY `ID_SMS` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `types`
--
ALTER TABLE `types`
  MODIFY `ID_TYPE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appel`
--
ALTER TABLE `appel`
  ADD CONSTRAINT `FK_ACTIVER3` FOREIGN KEY (`TEL`) REFERENCES `abonnees` (`TEL`),
  ADD CONSTRAINT `FK_CONCERNER` FOREIGN KEY (`ID_TYPE`) REFERENCES `types` (`ID_TYPE`);

--
-- Constraints for table `forfait_internet`
--
ALTER TABLE `forfait_internet`
  ADD CONSTRAINT `FK_ACTIVER1` FOREIGN KEY (`TEL`) REFERENCES `abonnees` (`TEL`),
  ADD CONSTRAINT `FK_FORFAIT_TYPE` FOREIGN KEY (`ID_TYPE`) REFERENCES `types` (`ID_TYPE`);

--
-- Constraints for table `forfait_sms`
--
ALTER TABLE `forfait_sms`
  ADD CONSTRAINT `FK_ACTIVER2` FOREIGN KEY (`TEL`) REFERENCES `abonnees` (`TEL`),
  ADD CONSTRAINT `FK_CORRESPOND` FOREIGN KEY (`ID_TYPE`) REFERENCES `types` (`ID_TYPE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
