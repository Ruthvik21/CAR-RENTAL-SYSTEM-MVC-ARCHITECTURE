CREATE TABLE cars (
  make VARCHAR(50),
  model VARCHAR(50),
  year INT,
  price_per_day DOUBLE,
  inventory INT
);
INSERT INTO cars (make, model, year, price_per_day, inventory)
VALUES
('Toyota', 'Corolla', 2019, 2500.0, 5),
('Honda', 'Civic', 2020, 1000.0, 3),
('Kia', 'Seltos', 2021, 1200.0, 2),
('Toyota', 'Innova Crysta', 2018, 2000.0, 4);
