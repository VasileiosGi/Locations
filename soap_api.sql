-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 12 Ιαν 2020 στις 19:32:12
-- Έκδοση διακομιστή: 10.1.9-MariaDB
-- Έκδοση PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `soap_api`
--
CREATE DATABASE IF NOT EXISTS `soap_api` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `soap_api`;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `locations`
--

CREATE TABLE `locations` (
  `id` int(11) NOT NULL COMMENT 'This is a primary key.',
  `location` point NOT NULL COMMENT 'This is the column where points are stored.',
  `closest_requests` int(11) NOT NULL DEFAULT '0' COMMENT 'This is the column that stores the number of the closest requests.',
  `name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT 'This is the column where the points name is stored.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `locations`
--

INSERT INTO `locations` (`id`, `location`, `closest_requests`, `name`) VALUES
(1, '\0\0\0\0\0\0\0\0\0\0\0\0\0@\0\0\0\0\0\0@', 2, 'A'),
(2, '\0\0\0\0\0\0\0\0\0\0\0\0\0I@\0\0\0\0\0\0I@', 1, 'C'),
(3, '\0\0\0\0\0\0\0\0\0\0\0\0\0 @\0\0\0\0\0\0 @', 0, 'D'),
(4, '\0\0\0\0\0\0\0333333$@������ @', 4, 'S'),
(5, '\0\0\0\0\0\0\0?�n���?d@�z�''@', 76, 'AA'),
(6, '\0\0\0\0\0\0\0��Q��?!�lV�@', 0, 'EW'),
(7, '\0\0\0\0\0\0\0섗��)@��r޿�?', 0, 'AS'),
(8, '\0\0\0\0\0\0\0ffffff�?�C�l��\0@', 0, 'SW');

--
-- Δείκτες `locations`
--
DELIMITER $$
CREATE TRIGGER `tgr_delete` AFTER DELETE ON `locations` FOR EACH ROW BEGIN
    delete from locations_memory where id=old.id;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_update` AFTER UPDATE ON `locations` FOR EACH ROW BEGIN
UPDATE
  locations_memory
SET
  location = AsText(NEW.location),
  name = NEW.name,
  closest_requests = NEW.closest_requests
WHERE
  id = NEW.id;END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trgr_insert` AFTER INSERT ON `locations` FOR EACH ROW BEGIN
    insert into locations_memory (id,name,location,closest_requests) values (new.id,new.name,AsText(new.location),new.closest_requests);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `locations_memory`
--

CREATE TABLE `locations_memory` (
  `id` int(11) NOT NULL,
  `location` varchar(500) NOT NULL,
  `closest_requests` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL
) ENGINE=MEMORY DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `locations_memory`
--

INSERT INTO `locations_memory` (`id`, `location`, `closest_requests`, `name`) VALUES
(1, 'POINT(5 5)', 2, 'A'),
(2, 'POINT(50 50)', 1, 'C'),
(3, 'POINT(8 8)', 0, 'D'),
(4, 'POINT(10.1 8.4)', 4, 'S'),
(5, 'POINT(1.2344999999999826 5.78903)', 76, 'AA'),
(6, 'POINT(1.32 2.7487)', 0, 'EW'),
(7, 'POINT(12.546546 1.234343)', 0, 'AS'),
(8, 'POINT(1.9 2.123)', 0, 'SW');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `location_uq` (`location`(25));

--
-- Ευρετήρια για πίνακα `locations_memory`
--
ALTER TABLE `locations_memory`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `location_uk` (`location`),
  ADD UNIQUE KEY `name_uk` (`name`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `locations`
--
ALTER TABLE `locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'This is a primary key.', AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT για πίνακα `locations_memory`
--
ALTER TABLE `locations_memory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
