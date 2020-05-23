CREATE TABLE product (
	id INT8 UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	code VARCHAR(25),
	description VARCHAR(500),
	amount DOUBLE,
	created_at TIMESTAMP,
	disabled BOOLEAN DEFAULT false
);