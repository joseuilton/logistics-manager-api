# Requirements
## Itens
- [] The user should create an item
  - [] The user not should create an item for a product that does not exists
- [] The user should delete an item
  - [] The user not should delete an item that does not exist
- [] The user should update an item
- [] The user should list one single item
  - [] The user not should list an item that does not exist
- [] The user should list all itens
  - [] The user should paginate the itens
  - [] The user should search itens by product name
- [] The user should get one item by ean code
  - [] The user not should get one item that does not exist

## Products
- [] The user should create a product
  - [] The user not should create a produt with invalid categoryId
  - [] The user not should create a product with empty name
  - [] The user not should create a product with empty price or invalid format
  - [] The user not should create a product with empty description
- [] The user should delete a product
  - [] The user not should delete a product that does not exist
- [] The user should update a product
  - [] The user not should update the price with invalid format
  - [] The user should update the name
  - [] The user should update the description
- [] The user should list one single product
  - [] The user not should list one product that does not exist
- [] The user should list all products
  - [] The user should paginate the products
  - [] The user should search products by name

## Customers
- [] The user should create a customer
  - [] The user not should create a customer with empty name
  - [] The user not should create a product with empty email or invalid format
  - [] The user not should create a product with empty phone or invalid format
  - [] The user not should create a product with empty cnpj
- [] The user should delete a customer
  - [] The user not should delete a customer that does not exist
- [] The user should update a customer
  - [] The user not should update the email with invalid format
  - [] The user not should update the phone with invalid format
  - [] The user should update the name
  - [] The user should update the address
  - [] The user should update the cnpj
- [] The user should list one single customer
  - [] The user not should list one customer that does not exist
- [] The user should list all customers
  - [] The user should paginate the customers
  - [] The user should search customers by name

# Database
- A product can have multiple itens
- An item can be of single product

## Entitities
´´´text
Customers
- customerId [uuid, PK]
- name [varchar(255), not null]
- email [varchar(255), not null]
- phone [varchar(255), not null]
- address [varchar(255), not null]
- cnpj [varchar(14), not null]
- createdAt [timestamp, default now()]
- updatedAt [timestamp, null]

Products
- productId [uuid, PK]
- name [varchar(255), not null]
- description [varchar(255), not null]
- priceInCents [INT, not null]
- createdAt [timestamp, default now()]
- updatedAt [timestamp, null]

Itens
- itemId [integer, default autoincrement()]
- productId [uuid, FK]
- eanCode [varchar(13), nullable, unique]
- createdAt [timestamp, default now()]
- updatedAt [timestamp, null]

´´´