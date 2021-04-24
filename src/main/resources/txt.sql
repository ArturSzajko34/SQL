
select customerName,phone,city  from customers;

select distinct city from customers;

select distinct productScale from products;

select * from employees
where jobTitle = "Sales Rep";

select addressLine1,addressLine2 from offices
where country = "USA";

select * from payments
where paymentDate > "2005-05-30";

select * from orders
where requiredDate > "2003-11-11" and status = "Cancelled";

select * from products
where (productLine = "Motorcycles" OR productLine ="Trucks and Buses")
and
productScale = "1:18";

select * from products
where productScale = "1:18";

select * from orders;

select * from orders
where requiredDate > "2005-04-08" and not status = "Shipped";

select * from orders
where requiredDate < "2005-04-08" and status != "Shipped";

select * from orderdetails;

SELECT * FROM orderdetails
ORDER BY priceEach DESC;

SELECT * FROM orderdetails
ORDER BY priceEach DESC;

select customerName from customers
where addressLine2 is not Null
and state is null;

select customerName from customers
order by customerName
limit 3;

select MIN(priceEach)
from orderdetails;

SELECT MIN(priceEach),MAX(priceEach) FROM orderdetails;

select avg(priceEach) AS "średnia wartość" from orderdetails;

select count(country) from customers
where country = "France";

select country from customers;

select sum(creditLimit) from customers
where country = "Germany";

select * from customers
where customerName like "Auto%";

select customerNumber,creditLimit from customers
where creditLimit between 20000 and 60000;

select * from products;

select count(buyPrice) from products
where buyPrice between 30 and 60
and productLine IN("Motorcycles","Planes","Ships","Trains");

select orderDate from orders;

select count(*) from orders
where orderDate between "2003-01-01" and "2005-12-31";

select count(country),country from customers
group by country;

select
count(productLine),
MIN(buyPrice),
MAX(buyPrice),
avg(buyPrice) AS "Srednia",
productLine
from products
group by productLine;

select productLine,avg(buyPrice) from products
group by productLine
having avg (buyPrice) > 50;

select customerNumber,customerName from customers
group by creditLimit
having avg (creditLimit) > 0

SELECT * FROM customers join orders
on customers.customerNumber = orders.customerNumber
where customers.contactLastName = 'Schmitt';

select * from offices;

select * from employees join offices
on employees.officeCode = offices.officeCode
where offices.country = "USA";

select * from orderdetails;

select products.productName, orderdetails.quantityOrdered from products join orderdetails
on products.productCode = orderdetails.productCode
where
orderdetails.orderNumber = 10145;

select * from customers;

select count(customers.customerName) from customers join orders
on customers.customerNumber = orders.customerNumber
join orderdetails
on orders.orderNumber = orderdetails.orderNumber
join products
on orderdetails.productCode = products.productCode
where products.productName = "18th Century Vintage Horse Carriage";

INSERT INTO customers (customerNumber,customerName,contactLastName,phone,contactFirstName,addressLine1,addressLine2,city,country)
VALUES (2, "jaro", "Dario", 518097280,"test","Powstancow","Powstanców","Zabki","Polska");


select * from customers
where customerName = "jaro";


select * from employees;


INSERT INTO employees (employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle)
VALUES (2,"Artur","Szajko","dupa","aszajko25@gmail.com",6,1002,"QA");

select * from orders;

INSERT INTO orders (orderNumber,orderDate,requiredDate,shippedDate,status,comments,customerNumber)
VALUES (10426,"2021-04-11","2021-04-11","2021-04-11","Shipped","Check on availability.",2);

select * from orderdetails;


INSERT INTO orderdetails (orderNumber,productCode,quantityOrdered,priceEach,orderLineNumber)
VALUES (10426,"S18_1749",50,100.10,3);

select * from products;


INSERT INTO products
(productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP)
VALUES ("S10_6666","1952 Alpine Renault 1300","Classic Cars","1:10","Classic Metal Creations","dupa","7305",100.10,10.10);


select * from orderdetails;

update customers
SET customerName= "Artuditu"
where customerNumber = 2;

select customerName from customers
where customerName = "Artuditu";


select * from customers;



select count(country) from customers
where country = "Australia";

select * from customers
where country = "Australia";


delete FROM classicmodels.orderdetails
where orderNumber in (select orderNumber FROM classicmodels.orders where customerNumber
IN (SELECT customers.customerNumber from customers where customers.country = 'Australia'));

delete  FROM classicmodels.orders where customerNumber
IN (SELECT customers.customerNumber from customers where customers.country = 'Australia');


DELETE FROM classicmodels.payments where customerNumber
IN (SELECT customers.customerNumber from customers where customers.country = 'Australia');

DELETE FROM Customers WHERE country='Australia';

CREATE TABLE employee_ASZ
( id int,
 first_name varchar(255),
 last_Name varchar(255),
 position varchar(255) ,
 salary int,
 manager_id int );

 select * from employee_ASZ;


  update employee_ASZ
SET last_Name = "Krok"
where salary = 35000;

 INSERT INTO employee_ASZ (id,first_name,last_Name,position,salary)
 VALUES (0, "Pawel", "Mirecki", "CEO",120000);

INSERT INTO employee_ASZ (id,first_name,last_Name,position,salary,manager_id)
 VALUES (15, "Boleslaw", "Chmiel", "Sr Principal",30000,12);

 select * from employee_asz
 where id = 1;

 select * from employee_asz
 where last_Name = "Oleksy";

DELETE FROM employee_asz WHERE last_Name like "%K";

DELETE FROM employee_asz WHERE last_Name = "Kowal";

update employee_asz
SET last_Name = "Oleksy"
where id = 1;

ALTER TABLE employee_asz
ADD PRIMARY KEY(id);

CREATE INDEX index_manager
ON employee_asz (manager_id);


 // "orders" z jaka tabelą chcemy zrobic połaczenie, clietnId - klucz obcy z tabeli do której robimy połaczenie, klucz głowny z tabeli z której sie łączymy
ALTER TABLE orders ADD CONSTRAINT fk_smarphone_order FOREIGN KEY (clientId) REFERENCES smartphone(id);

ALTER TABLE orders ADD CONSTRAINT fk_smarphone_order FOREIGN KEY (clientId) REFERENCES smartphone(id);
ALTER TABLE client ADD CONSTRAINT fk_client_order FOREIGN KEY (id) REFERENCES orders(clientId);
ALTER TABLE address ADD CONSTRAINT fk_address_client_id FOREIGN KEY (id) REFERENCES client(id);

















































