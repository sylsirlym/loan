INSERT INTO customers(firstname,lastname,idnumber,email) VALUES('John','Doe','1234567','john.doe@gmail.com');

INSERT INTO profiles(customerid,msisdn,pinhash)VALUES(1,'254707123456','e10adc3949ba59abbe56e057f20f883e');

INSERT INTO tenures(tenureduration,durationtype)VALUES(15,'Days');
INSERT INTO tenures(tenureduration,durationtype)VALUES(30,'Days');

INSERT INTO loanproducts(loanproductname,maxallowablelimit,interest,tenureid)VALUES('Product A',10000.00,10,1);
INSERT INTO loanproducts(loanproductname,maxallowablelimit,interest,tenureid)VALUES('Product B',25000.00,12.5,2);

INSERT INTO loanoffer(loanproductid,profileid,amount)VALUES(1,1,12000.00);
INSERT INTO loanoffer(loanproductid,profileid,amount)VALUES(2,1,20000.00);