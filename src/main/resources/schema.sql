DROP TABLE IF EXISTS tenures;

CREATE TABLE tenures (
  tenureid int NOT NULL AUTO_INCREMENT,
  tenureduration int NOT NULL,
  durationtype varchar(45) NOT NULL,
  active int NOT NULL DEFAULT '1',
  PRIMARY KEY (tenureid)
);

DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  customerid int NOT NULL AUTO_INCREMENT,
  firstname varchar(45) NOT NULL,
  lastname varchar(45) NOT NULL,
  idnumber varchar(45) NOT NULL,
  email varchar(45) DEFAULT NULL,
  active int NOT NULL DEFAULT '1',
  PRIMARY KEY (customerid)
);

DROP TABLE IF EXISTS profiles;

CREATE TABLE profiles (
  profileid int NOT NULL AUTO_INCREMENT,
  customerid int NOT NULL,
  msisdn varchar(20) NOT NULL,
  pinhash varchar(100) NOT NULL,
  active int NOT NULL DEFAULT '1',
  PRIMARY KEY (profileid)
);


DROP TABLE IF EXISTS loanproducts;

CREATE TABLE loanproducts (
  loanproductid int NOT NULL AUTO_INCREMENT,
  loanproductname varchar(45) NOT NULL,
  maxallowablelimit double NOT NULL,
  interest int NOT NULL,
  tenureid int NOT NULL,
  active int NOT NULL DEFAULT '1',
  PRIMARY KEY (loanproductid)
);


DROP TABLE IF EXISTS loanoffer;

CREATE TABLE loanoffer (
  loanofferid int NOT NULL AUTO_INCREMENT,
  loanproductid int NOT NULL,
  profileid int NOT NULL,
  amount double NOT NULL,
  active int NOT NULL DEFAULT '1',
  PRIMARY KEY (loanofferid)
);


DROP TABLE IF EXISTS loan;

CREATE TABLE loan (
  loanid int NOT NULL AUTO_INCREMENT,
  loanofferid int NOT NULL,
  loanprincipal double NOT NULL,
  loanstatus varchar(45) NOT NULL,
  loandate date NOT NULL,
  active int NOT NULL DEFAULT '1',
  PRIMARY KEY (loanid)
);


