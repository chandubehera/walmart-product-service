Running the Application
Start your Spring Boot application.
Open H2 Console:
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:productdb
Username: sa
Password: (leave blank)

SELECT * FROM products;

API Testing via Postman

Add a New Product
POST /api/products
Request Body:
{
"name": "MacBook Pro",
"description": "M3 Chip, 16GB RAM",
"category": "Electronics",
"price": 1999.99,
"stockQuantity": 15
}

Get Product by ID
GET /api/products/1

Search Products
GET /api/products/search?keyword=iPhone

Bulk Upload
POST /api/products/bulk-upload

Request Body:
[
{
"name": "iPad Air",
"description": "Apple iPad Air 2023",
"category": "Tablets",
"price": 599.99,
"stockQuantity": 40
},
{
"name": "Dell XPS 15",
"description": "High-performance laptop",
"category": "Laptops",
"price": 1499.99,
"stockQuantity": 25
}
]



Example API Response for a Non-Existing Product
Request: GET /api/products/999
Response:
{
"error": "Product Not Found",
"message": "Product not found"
}