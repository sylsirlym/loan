INSERT INTO `customers`(`firstName`,`lastName`,`idNumber`,`email`,`dateCreated`,`dateModified`) VALUES('John','Doe','1234567','john.doe@gmail.com',now(),now());

INSERT INTO `profiles`(`customerID`,`pinHash`,`dateCreated`,`dateModified`)VALUES(1,'e10adc3949ba59abbe56e057f20f883e',now(),now());

INSERT INTO `tenures`(`tenureDuration`,`durationType`,`dateCreated`,`dateModified`)VALUES(15,'Days',now(),now());
INSERT INTO `tenures`(`tenureDuration`,`durationType`,`dateCreated`,`dateModified`)VALUES(30,'Days',now(),now());

INSERT INTO `loanproducts`(`loanProductName`,`maxAllowableLimit`,`interest`,`tenureID`,`dateCreated`,`dateModified`)VALUES('Product A',10000.00,10,1,now(),now());
INSERT INTO `loanproducts`(`loanProductName`,`maxAllowableLimit`,`interest`,`tenureID`,`dateCreated`,`dateModified`)VALUES('Product B',25000.00,12.5,2,now(),now());

INSERT INTO `loanoffer`(`loanProductID`,`profileID`,`amount`,`dateCreated`,`dateModified`)VALUES(1,1,1200.00,now(),now());
INSERT INTO `loanoffer`(`loanProductID`,`profileID`,`amount`,`dateCreated`,`dateModified`)VALUES(2,1,2000.00,now(),now());