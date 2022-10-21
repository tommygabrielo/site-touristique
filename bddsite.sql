-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 21 sep. 2022 à 10:20
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bddsite`
--

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nom` char(20) NOT NULL,
  `lieu` char(25) NOT NULL,
  `loyer` bigint(7) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id`, `nom`, `lieu`, `loyer`) VALUES
(1, 'Fihavanana', 'Ranomafana', 4000),
(2, 'Anjaha', 'Ambalavao', 5000),
(3, 'Havana', 'Fianar', 800),
(7, 'Ranomafana', 'Fianar', 2000000),
(8, 'Nosy kely', 'Fianar', 10000),
(9, 'Andringitra', 'Ambalavao', 2000),
(12, 'Isalo', 'Ranohira', 4000);

-- --------------------------------------------------------

--
-- Structure de la table `visiter`
--

DROP TABLE IF EXISTS `visiter`;
CREATE TABLE IF NOT EXISTS `visiter` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `idSite` int(11) NOT NULL,
  `idCli` int(11) NOT NULL,
  `nbjour` int(9) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idSite` (`idSite`),
  KEY `idCli` (`idCli`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visiter`
--

INSERT INTO `visiter` (`id`, `idSite`, `idCli`, `nbjour`, `date`) VALUES
(1, 3, 3, 3, '2022-08-12'),
(2, 1, 1, 2222, '2022-09-03'),
(3, 1, 1, 1, '2022-09-08'),
(4, 1, 2, 35, '2022-11-26'),
(5, 2, 1, 2, '2022-09-10'),
(6, 2, 2, 5, '2022-08-02'),
(7, 8, 4, 5, '2022-08-16'),
(8, 8, 3, 5, '2022-08-03'),
(9, 8, 4, 5, '2022-08-17'),
(10, 9, 5, 6, '2022-08-24'),
(11, 8, 4, 6, '2022-08-17'),
(13, 8, 4, 5, '2022-08-18'),
(14, 2, 10, 20, '2022-08-24'),
(15, 3, 2, 5, '2022-08-22'),
(16, 12, 11, 4, '2022-08-18');

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
CREATE TABLE IF NOT EXISTS `visiteur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(150) NOT NULL,
  `adress` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`id`, `nom`, `adress`) VALUES
(5, 'Nambinina', 'Anjoma'),
(2, 'LULU', 'TULEAR'),
(3, 'RABE', 'MAHAJANGA'),
(4, 'Tommy', 'Tambohobe'),
(9, 'Zanabololona', 'Fianarantsoa'),
(10, 'Rindra', 'Ambalafary'),
(11, 'Vola', 'Tanambao');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
