# Online Shop Application

This project is an **e-commerce platform** built with **Spring Boot** and **Java**, providing users with the ability to browse, purchase products, and manage their shopping cart and profile.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Prerequisites](#prerequisites)
4. [Installation](#installation)
5. [Database Configuration](#database-configuration)
6. [Running the Application](#running-the-application)
7. [Usage](#usage)
8. [Project Structure](#project-structure)
9. [Contributing](#contributing)

---

## Features

- **User Authentication:** Registration, login, and role-based access control (user and admin).
- **Product Catalog:** View, search, and filter products with pagination.
- **Shopping Cart:** Add, update, and remove items from the cart.
- **Order Management:** Place orders, view order history.
- **Admin Features:** Manage products, orders, and users.

---

## Technologies Used

- **Java 11+**: Core programming language.
- **Spring Boot**: Framework for dependency injection, web application, and RESTful API.
- **Spring Data JPA**: For interaction with the database using Hibernate.
- **Thymeleaf**: Template engine for rendering views.
- **MySQL**: Relational database management.
- **Maven**: For managing dependencies.
- **Lombok**: To reduce boilerplate code with annotations like `@Getter`, `@Setter`.
- **Bootstrap**: For responsive front-end design.

---

## Prerequisites

Ensure you have the following software installed:

- **Java 11+**
- **Maven**
- **MySQL** (or a compatible relational database)

---

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/stoyanned/shop.git
   cd shop
   
2. **Install Maven dependencies:**

    ```bash
    mvn clean install
   
3. **Lombok Configuration:**

If Lombok isn't working properly in your IDE, ensure that the Lombok plugin is installed and annotation processing is enabled.

## Database Configuration

1. **Set up a MySQL database:**

    ```sql
    CREATE DATABASE shop_db;

2. **Open the src/main/resources/application.properties file and configure your MySQL database connection:**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/shop_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
Replace your_username and your_password with your MySQL credentials.

## Running the Application

1. **Run the application using Maven:**

    ```bash
    mvn spring-boot:run
   
2. **Open a web browser and navigate to http://localhost:8080.**

## Usage

- Register a new user by navigating to the /register URL and filling in the required details.
- Login with your credentials, after which you can browse products.
- Add products to the shopping cart, manage the cart, and proceed to checkout to place an order.
- As an Admin, you can access the admin panel to manage users, products, and orders.

## Project Structure

Here's an overview of the key files and directories:

- **/src/main/java/com/example/shop**: Contains the Java code, including models, controllers, repositories, and services.
- **/src/main/resources/templates**: Thymeleaf templates for rendering the web pages.
- **/src/main/resources/static**: Contains static resources like CSS, JS, and images.
- **/src/main/resources/application.properties**: Application configuration properties.

## Contributing

1. **Fork the repository.**
2. **Create a new branch**: `git checkout -b feature/your-feature`
3. **Commit your changes**: `git commit -m 'Add some feature'`
4. **Push to the branch**: `git push origin feature/your-feature`
5. **Submit a pull request**.
