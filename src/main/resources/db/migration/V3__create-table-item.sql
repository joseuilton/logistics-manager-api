CREATE TABLE item(
  item_id SERIAL PRIMARY KEY UNIQUE,
  product_id TEXT NOT NULL,
  ean_code VARCHAR(13) UNIQUE,

  CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE
);