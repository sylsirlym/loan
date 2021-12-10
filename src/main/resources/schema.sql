DROP TABLE IF EXISTS `tenures`;

CREATE TABLE `tenures` (
  `tenureID` int NOT NULL AUTO_INCREMENT,
  `tenureDuration` int NOT NULL,
  `durationType` varchar(45) NOT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateModified` date DEFAULT NULL,
  `active` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`tenureID`)
);

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `idNumber` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateModified` date DEFAULT NULL,
  `active` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`customerID`)
);

DROP TABLE IF EXISTS `profiles`;

CREATE TABLE `profiles` (
  `profileID` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `pinHash` varchar(100) NOT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateModified` date DEFAULT NULL,
  `active` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`profileID`)
);


DROP TABLE IF EXISTS `loanProducts`;

CREATE TABLE `loanProducts` (
  `loanProductID` int NOT NULL AUTO_INCREMENT,
  `loanProductName` varchar(45) NOT NULL,
  `maxAllowableLimit` double NOT NULL,
  `interest` int NOT NULL,
  `tenureID` int NOT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateModified` date DEFAULT NULL,
  `active` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`loanProductID`)
);


DROP TABLE IF EXISTS `loanOffer`;

CREATE TABLE `loanOffer` (
  `loanOfferID` int NOT NULL AUTO_INCREMENT,
  `loanProductID` int NOT NULL,
  `profileID` int NOT NULL,
  `amount` double NOT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateModified` date DEFAULT NULL,
  `active` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`loanOfferID`)
);


DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
  `loanID` int NOT NULL AUTO_INCREMENT,
  `loanOfferID` int NOT NULL,
  `loanPrincipal` double NOT NULL,
  `loanStatus` varchar(45) NOT NULL,
  `loanDate` date NOT NULL,
  `active` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`loanID`)
);


