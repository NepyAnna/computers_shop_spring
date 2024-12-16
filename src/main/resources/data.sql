
INSERT INTO owners (name_owner) VALUES
('John Doe'),
('Jane Smith');

INSERT INTO shops (name_store, id_tax, id_owner) VALUES
('TechStore', 12345, 1),
('GadgetWorld', 67890, 2);

INSERT INTO computers (brand, memory_size, processor_specification, operation_system, price, id_shop) VALUES
('Dell', 16, 'Intel i7', 'Windows 10', 1200, 1),
('HP', 8, 'AMD Ryzen 5', 'Windows 11', 800, 2),
('Apple', 32, 'M1', 'macOS', 2500, 1),
('Lenovo', 16, 'Intel i5', 'Windows 10', 1000, 2);
