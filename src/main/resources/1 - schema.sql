DROP TABLE IF EXISTS product;

CREATE TABLE product (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	code VARCHAR(25),
	description VARCHAR(500),
	amount DECIMAL,
	created_at DATE,
	disabled BOOLEAN DEFAULT false
);