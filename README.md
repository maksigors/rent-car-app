# Rent Car App

The Rent Car App project in Java, utilizing the Spring Framework, is a web application that models
the functionality of a car rental service. This project encompasses essential components and features
that enable users to rent, reserve and manage vehicles.
The application also integrates a Telegram chat-bot for notifications about rented vehicles, as well as
vehicles with expired or expiring rentals on the current day. A payment module has also been implemented.

### Key Features:

`User Registration and Authentication:` Users can create accounts, log into the
system, and access the service's functionality.

`Telegram Notifications:` Managers and users can receive notifications via a
Telegram chatbot regarding rental expirations.

`Viewing Available Cars:` Users can browse a list of available cars, with
information about the model, year of manufacture, rental cost, and more.

`Renting Cars:` Users can select a specific car and rent it
immediately or for a specified date. The system calculates the rental cost based on
duration and other parameters.

`Order Management:` Managers can view current and past orders.

`Administration:` Administrators possess special access rights for managing cars
(adding, editing, deleting), viewing and managing users, and orders.

### Technolegies:
• Programming Language: **Java 17**

• **Framework**: Spring

• **Spring Boot** 2.7.14

• **Spring MVC** 5.3.20

• **Spring Security** 5.6.10

• **Spring Data JPA**

• **Telegram bot API** 6.7.0

• **Data Storage:** Utilization of a relational database (MySQL)
to store information about cars, users, and orders.

• **Authentication and Authorization:** Implementation of Spring Security
to ensure user security, authentication, and authorization.

• **Lombok:** an annotation-based Java library
that allows you to reduce boilerplate code.

• **Mapstruct:** a code generator that greatly simplifies the implementation of mappings
between Java bean types based on a convention over configuration approach.

• **Liquibase:** ensures the application database is updated along with the application code
by using Spring Boot auto-configuration and features.

• **Swagger ui:**  allows development team to visualize and interact with the API's resources
without having any of the implementation logic in place.

• **Docker:** an open-source centralized platform designed to create, deploy, and run applications.

• **Jackson Databind:** to convert JSON to and from POJO (Plain Old Java Object)
using property accessor or using annotations.

• **MySQL 8.0.22:** Relational Database Management System

## Endpoint description:

### Authentication Controller

    POST/login - login user
    POST/register - register new user

### Car Controller

    POST/cars - create new car
    GET/cars/ - get all cars
    GET/cars/{id} - get car by ID
    PUT/cars/{id} - update car by ID
    DELETE/cars/{id} - delete car by ID

### Payment Controller

    GET/payments - get payment by user ID
    POST/payments - create payment
    GET/payments/cancel - handle cancel payment
    GET/payments/success - handle success payment

### User Controller

    PUT/users/{id}/role - update role
    GET/users/me - get  user
    PUT/users/me - update  user

### Rental Controller

    GET/rentals/{id} - get rental by ID
    GET/rentals?user_id - get actual rental by user ID 
    POST/rentals - create new rental
    POST/rentals/{id}/return - set actual return date 

### Project Launch

Ensure that you have **`Java`** and **`Maven`** installed.

Clone this repository to your computer.

Configure the project settings to specify the database connection parameters.

- configure application.properties file
  ![img.png](img.png)

- configure liquibase.properties file
  ![img_1.png](img_1.png)

Launch the application
![img_2.png](img_2.png)

Open a web browser and navigate to http://localhost:8080/swagger-ui.html to access the web interface.
![img_3.png](img_3.png)


### Conclusion
The Rent Car App project in Java Spring
demonstrates the basic functionality of a car rental service.
It can serve as a starting point for further development and expansion,
including adding new features, enhancing the user interface, and optimizing performance.