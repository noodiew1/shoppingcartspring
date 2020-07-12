
CREATE TABLE IF NOT EXISTS cart(
  orderId INT, 
  itemId INT, 
  customerId INT, 
  quantity INT
);

insert into cart values (1, 2, 3, 4);