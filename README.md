# Ecommerce Console Application
This is a console-based ecommerce application that allows you to manage your product catalog, track inventory, and view sales and profitability reports.

# Build
```java
docker build -t ecommerceapp . && docker run --rm -i ecommerceapp
```
Command descriptions and parameters:
save_product {product_id} {product_name} {price}: Add a new product to the catalog or modify an existing one. The catalog sets the selling price. For example:

save_product prod001 iphone 2800
purchase_product {product_id} {quantity} {price}: Purchase a product, increasing its balance based on the specified quantity. For example:

purchase_product prod001 10 2500
order_product {product_id} {quantity}: Place an order for the product, decreasing its balance according to the specified quantity. For example:

order_product prod001 3
get_quantity_of_product {product_id}: Return the remaining quantity of a specific product. For example:

get_quantity_of_product prod001
Output: 7
get_average_price {product_id}: Calculate and display the average price of a specific product based on its purchase history. For example, if you purchased 10 phone001 for 2000 and later purchased 30 more phone001 for 3000, the average price of phone001 is 2750 based on the purchase history.

get_average_price prod001
Output: 2750
get_product_profit {product_id}: Calculate and display the profit earned from a specific product by comparing the average purchase price with the average order price. For example, if you purchased 10 phones for 2000 and later purchased 30 more phones for 3000. Then, you sold 5 phones for 3500, 10 phones for 3800, and 15 phones for 4000. The average purchase price is 2750, the average order price is 3850, the profit per unit is 1100, and the total profit is 33000.

get_product_profit prod001
Output: 33000
get_fewest_product: Return the name of the product with the lowest remaining quantity. If there is more than one such product, return any one. For example:

get_fewest_product
Output: iphone
get_most_popular_product: Return the name of the product with the highest number of orders. If there is more than one such product, return any one. For example:

get_most_popular_product
Output: iphone
get_orders_report: Generate a report of all orders, including the product ID, product name, quantity, price, cost of goods sold (COGS), and selling price.

export_orders_report {path}: Export the report generated by the get_orders_report command to a CSV file at the specified file path.

exit: Close the console application.

# Bonus Tasks (Optional)
get_orders_report: Generate a report of all orders, including the product ID, product name, quantity, price, cost of goods sold (COGS), and selling price.

export_orders_report {path}: Export the report generated by the get_orders_report command to a CSV file at the specified file path.
