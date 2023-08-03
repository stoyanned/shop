CREATE DATABASE shop;
USE shop;
CREATE TABLE PRODUCT (
                         product_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         description TEXT,
                         price DECIMAL(10, 2) NOT NULL,
                         image_url VARCHAR(255) NOT NULL
);
CREATE TABLE CART (
                      cart_id INT PRIMARY KEY AUTO_INCREMENT,
                      user_id INT,
                      FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);
CREATE TABLE CART_ITEM (
                           cart_item_id INT PRIMARY KEY AUTO_INCREMENT,
                           cart_id INT,
                           product_id INT,
                           quantity INT NOT NULL,
                           FOREIGN KEY (cart_id) REFERENCES CART(cart_id),
                           FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);
CREATE TABLE ORDERS (
                        order_id INT PRIMARY KEY AUTO_INCREMENT,
                        user_id INT,
                        email VARCHAR(255) NOT NULL,
                        address TEXT NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);
CREATE TABLE ORDER_ITEM (
                            order_item_id INT PRIMARY KEY AUTO_INCREMENT,
                            order_id INT,
                            product_id INT,
                            quantity INT NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES ORDERS(order_id),
                            FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);
CREATE TABLE USERS (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL
);
CREATE TABLE ORDERS_HISTORY (
                                order_history_id INT PRIMARY KEY AUTO_INCREMENT,
                                user_id INT,
                                email VARCHAR(255) NOT NULL,
                                address TEXT NOT NULL,
                                name VARCHAR(100) NOT NULL,
                                order_date TIMESTAMP NOT NULL,
                                FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);

CREATE TABLE ORDER_HISTORY_ITEM (
                                    order_history_item_id INT PRIMARY KEY AUTO_INCREMENT,
                                    order_history_id INT,
                                    product_id INT,
                                    quantity INT NOT NULL,
                                    FOREIGN KEY (order_history_id) REFERENCES ORDERS_HISTORY(order_history_id),
                                    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);