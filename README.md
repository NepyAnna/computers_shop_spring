# Computers Shop Spring Application

# Project Description

The Computers Shop Spring Application is a Spring Boot project designed to manage information about shops, computers, and their respective owners. It provides an API to perform CRUD operations on these entities, facilitating interaction with shops and their available computer inventory. While the Owner entity is included, it is currently a placeholder and will be further expanded in future updates.

# Main Features

* Manage shops and their computer inventories.

* Add, view, search, and delete computers by brand.

* Retrieve information about shops and their associated computers.

* Future plans to enhance the project with detailed owner management.

# Technologies Used

* Java (21)

* Spring Boot

* Spring Data JPA

* Spring Web

* H2 Database (in-memory database for development)

* Hibernate

* Maven (for dependency management)

# Installation Steps

Clone the Repository:

git clone <repository-url>

# How to Access

API Base URL: http://localhost:8080/api

The project is configured with an in-memory H2 database that initializes with sample data.

Access the H2 console at: http://localhost:8080/h2-console

Use the credentials from application.properties.

# API Endpoints

Shops Endpoints

Get all shops with computers: GET /api/shops

Get shop by ID: GET /api/shops/{id}

Computers Endpoints

Get all computers: GET /api/computers

Search computers by brand: GET /api/computers/?brand={brand}

Add a new computer: POST /api/computers

Delete computers by brand: DELETE /api/computers/{brand}

# Running Tests

[![temp-Imagety9-Hqp.avif](https://i.postimg.cc/Y9Lxj9rP/temp-Imagety9-Hqp.avif)](https://postimg.cc/njZmPnQK)

# Future Enhancements

Full implementation of the Owner entity, including CRUD operations.

Add relationships between Owner and Shop for detailed ownership management.

Improve test coverage and introduce integration tests.

Add support for pagination and sorting in API endpoints.

# Disclaimer

This project is developed as part of a bootcamp learning experience and is intended for educational purposes only.
This project is not meant for commercial use, and any trademarks or references to third-party services  belong to their respective owners. By using this code, you acknowledge that it is a work in progress, created by learners, and comes without warranties or guarantees of any kind.

Use at your own discretion and risk.

# Contributor

NepyAnna [![NepyAnna](https://img.icons8.com/ios-glyphs/30/000000/github.png)](https://github.com/NepyAnna)