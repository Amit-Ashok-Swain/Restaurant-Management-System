<h1 align="center">Restaurant Management System</h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java-21-darkblue.svg" />
  </a>
  <a href="Maven url">
    <img alt="Maven" src="https://img.shields.io/badge/Maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.1-brightgreen.svg" />
  </a>
  <a href="License url">
    <img alt="BSD Clause 3" src="https://img.shields.io/badge/License-BSD_3--Clause-blue.svg"/>
  </a>
</p>

---

<p align="left">

## Overview

The Restaurant Management System is a Spring Boot-based application that provides a set of CRUD (Create, Read, Update, Delete) operations for managing users, including Admin, Normal User, and Visitor, along with food items in a restaurant. The system enforces role-based access control, ensuring that each type of user has the appropriate privileges.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java 21
- **Database:** MySQL
- **Build Tool:** Maven
- **Documentation:** SpringDoc OpenAPI (Swagger UI)
- **Email Handling:** JavaMail API

## Dependencies

The project utilizes the following dependencies:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **MySQL Connector/J (Runtime Dependency)**: The MySQL JDBC driver for connecting to MySQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **Springdoc OpenAPI (Swagger UI)**: Adds Swagger UI for documenting and testing API endpoints.

- **Spring Boot Starter Validation**: Includes validation support for request data binding and response data rendering.

- **JavaMail API**: Used for sending emails.
  
- **Spring Security**: Ensures secure authentication and authorization for your application.


## Data Flow

### Controller

| Controller             | Functions Used                                                      |
|------------------------|---------------------------------------------------------------------|
| `AdminController`     | - `addAdmin`: Add a new admin user.<br/> - `addFoodItem`: Add a new food item to the menu. |
| `UserController`       | - `signUpUser`: Register a new user.<br/> - `signInUser`: Authenticate and sign in a user.<br/> - `addOrder`: Place a food order.<br/> - `getAllFoodItems`: Retrieve a list of all food items. |
| `VisitorController`    | - `getAllFoodItems`: Retrieve a list of all food items for visitors. |

### Services

| Service             | Functions Used                                                      |
|---------------------|---------------------------------------------------------------------|
| `AdminService`     | - `addAdmin`: Add a new admin user.<br/> - `ifAdminExistOrNot`: Check if an admin exists. |
| `AuthenticationService` | - `saveAuthToken`: Save an authentication token.<br/> - `authenticate`: Authenticate user based on an authentication token. |
| `FoodService`      | - `addFoodItem`: Add a new food item to the menu.<br/> - `isFoodInTheMenu`: Check if a food item exists in the menu.<br/> - `getAllFoodItems`: Retrieve a list of all food items. |
| `OrderService`     | - `addOrder`: Place a food order. |
| `UserService`      | - `signUpUser`: Register a new user.<br/> - `signInUser`: Authenticate and sign in a user.<br/> - `findFirstByUserEmail`: Retrieve a user by email. |

### Repository

| Repository             | Purpose                                    |
|------------------------|--------------------------------------------|
| `IAdminRepo`           | Access and manage admin users in the database. |
| `IAuthenticationRepo`  | Access and manage authentication tokens in the database. |
| `IFoodRepo`            | Access and manage food items in the database. |
| `IOrderRepo`           | Access and manage orders in the database. |
| `IUserRepo`            | Access and manage users in the database. |

## Database Design and Database Table

The database contains tables for users (including admins, normal users, and visitors), food items, orders, and authentication tokens.

### Database Design

### User Table

- **id (BIGINT - Primary Key)**: This field serves as the primary key, ensuring each user has a unique identifier.
- **username (VARCHAR(255))**: Stores the username of the user.
- **password (VARCHAR(255))**: Represents the hashed and salted password of the user.
- **email (VARCHAR(255))**: Contains the email address of the user.
- **role (VARCHAR(50))**: Denotes the role of the user, which can be "Admin," "Normal User," or "Visitor."
- **is_signed_up (BOOLEAN)**: Indicates whether the user is signed up (true) or not (false).
- **is_signed_in (BOOLEAN)**: Indicates whether the user is currently signed in (true) or not (false).
- **created_at (TIMESTAMP)**: Records the timestamp of when the user account was created.

### Food Item Table

- **id (BIGINT - Primary Key)**: A unique identifier for each food item.
- **name (VARCHAR(255))**: The name of the food item.
- **description (TEXT)**: Provides a detailed description of the food item.
- **price (DECIMAL(10,2))**: Stores the price of the food item with two decimal places.
- **type (VARCHAR(50))**: Represents the type of food item (e.g., "Appetizer," "Main Course").

### Order Table

- **id (BIGINT - Primary Key)**: A unique identifier for each order.
- **user_id (BIGINT - Foreign Key)**: A foreign key referencing the user who placed the order.
- **food_item_id (BIGINT - Foreign Key)**: A foreign key referencing the ordered food item.
- **status (VARCHAR(50))**: Indicates the status of the order, such as "Placed" or "Delivered."
- **order_date (TIMESTAMP)**: Records the timestamp when the order was placed.

### Detailed Database Design

### User Table

| Column Name    | Data Type    | Description                                           |
| -------------- | ------------ | ----------------------------------------------------- |
| id             | BIGINT (PK)  | Unique identifier for each user.                      |
| username       | VARCHAR(255) | Username of the user.                                 |
| password       | VARCHAR(255) | Password of the user (hashed and salted).             |
| email          | VARCHAR(255) | Email address of the user.                            |
| role           | VARCHAR(50)  | Role of the user (Admin, Normal User, Visitor).       |
| is_signed_up   | BOOLEAN      | Indicates whether the user is signed up or not.       |
| is_signed_in   | BOOLEAN      | Indicates whether the user is signed in or not.       |
| created_at     | TIMESTAMP    | Timestamp of user creation.                           |

### Food Item Table

| Column Name    | Data Type    | Description                                           |
| -------------- | ------------ | ----------------------------------------------------- |
| id             | BIGINT (PK)  | Unique identifier for each food item.                 |
| name           | VARCHAR(255) | Name of the food item.                                |
| description    | TEXT         | Description of the food item.                         |
| price          | DECIMAL(10,2)| Price of the food item.                               |
| type           | VARCHAR(50)  | Type of food item (e.g., Appetizer, Main Course).     |

### Order Table

| Column Name    | Data Type    | Description                                           |
| -------------- | ------------ | ----------------------------------------------------- |
| id             | BIGINT (PK)  | Unique identifier for each order.                     |
| user_id        | BIGINT (FK)  | Foreign key referencing the user who placed the order.|
| food_item_id   | BIGINT (FK)  | Foreign key referencing the ordered food item.        |
| status         | VARCHAR(50)  | Status of the order (e.g., Placed, Delivered).         |
| order_date     | TIMESTAMP    | Timestamp of order placement. 


## Data Structures Used in the Project


### Entity Classes

1. **User Entity**: This class represents the structure of user data in the database. It includes fields such as `id`, `username`, `password`, `email`, `role`, `is_signed_up`, `is_signed_in`, and `created_at`. These fields are mapped to corresponding columns in the User Table.

2. **Food Item Entity**: This class defines the structure for food item data in the database. It includes fields like `id`, `name`, `description`, `price`, and `type`. These fields are mapped to corresponding columns in the Food Item Table.

3. **Order Entity**: This class represents the structure of order data in the database. It includes fields such as `id`, `user`, `foodItem`, `status`, and `orderDate`. The `user` and `foodItem` fields are mapped as foreign keys to the User Table and Food Item Table, respectively.

### Data Transfer Object (DTO) Classes

1. **SignUpRequest**: This DTO class is used to encapsulate the data needed to sign up a new user. It includes fields for `username`, `password`, and `email`.

2. **SignInRequest**: This DTO class encapsulates the data required to sign in a user. It includes fields for `username` and `password`.

3. **FoodItemRequest**: This DTO class is used for adding a new food item to the system. It includes fields for `name`, `description`, `price`, and `type`.

4. **OrderRequest**: This DTO class represents the data needed to place a food order. It includes fields for `userId` and `foodItemId`.

5. **UserResponse**: This DTO class is used to send user-related information as a response. It includes fields for `id`, `username`, `email`, and `role`.

6. **FoodItemResponse**: This DTO class is used to send food item-related information as a response. It includes fields for `id`, `name`, `description`, `price`, and `type`.

7. **OrderResponse**: This DTO class is used to send order-related information as a response. It includes fields for `id`, `user` (containing user information), `foodItem` (containing food item information), `status`, and `orderDate`.

These data structures, both entity classes and DTO classes, are essential components of the project, defining the structure of data and requests/responses used in the system.

1. **User Entity**: Represents user data in the database.

   ```java
   @Entity
   public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
   
       private String username;
       private String password;
       private String email;
       private String role;
       private boolean isSignedUp;
       private boolean isSignedIn;
       private LocalDateTime createdAt;
   
       // Getters and setters
   }
   ```

2. **Food Item Entity**: Represents food item data in the database.

   ```java
   @Entity
   public class FoodItem {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
   
       private String name;
       private String description;
       private BigDecimal price;
       private String type;
   
       // Getters and setters
   }
   ```

3. **Order Entity**: Represents order data in the database.

   ```java
   @Entity
   public class Order {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
   
       @ManyToOne
       @JoinColumn(name = "user_id")
       private User user;
   
       @ManyToOne
       @JoinColumn(name = "food_item_id")
       private FoodItem foodItem;
   
       private String status;
       private LocalDateTime orderDate;
   
       // Getters and setters
   }
   ```

### Data Transfer Object (DTO) Classes

1. **SignUpRequest**: Represents the data needed to sign up a new user.

   ```java
   public class SignUpRequest {
       private String username;
       private String password;
       private String email;
   
       // Getters and setters
   }
   ```

2. **SignInRequest**: Represents the data needed to sign in a user.

   ```java
   public class SignInRequest {
       private String username;
       private String password;
   
       // Getters and setters
   }
   ```

3. **FoodItemRequest**: Represents the data needed to add a new food item.

   ```java
   public class FoodItemRequest {
       private String name;
       private String description;
       private BigDecimal price;
       private String type;
   
       // Getters and setters
   }
   ```

4. **OrderRequest**: Represents the data needed to place a food order.

   ```java
   public class OrderRequest {
       private Long userId;
       private Long foodItemId;
   
       // Getters and setters
   }
   ```

5. **UserResponse**: Represents the response data for a user.

   ```java
   public class UserResponse {
       private Long id;
       private String username;
       private String email;
       private String role;
   
       // Getters and setters
   }
   ```

6. **FoodItemResponse**: Represents the response data for a food item.

   ```java
   public class FoodItemResponse {
       private Long id;
       private String name;
       private String description;
       private BigDecimal price;
       private String type;
   
       // Getters and setters
   }
   ```

7. **OrderResponse**: Represents the response data for an order.

   ```java
   public class OrderResponse {
       private Long id;
       private UserResponse user;
       private FoodItemResponse foodItem;
       private String status;
       private LocalDateTime orderDate;
   
       // Getters and setters
   }
   ```

These classes define the data structures used in the project for representing users, food items, orders, and related information.

To create the database tables based on this design, you can use a database migration tool like Flyway or Liquibase. These tools help manage database schema changes over time and can generate the tables based on your entity classes and design. Please let me know if you'd like specific instructions on setting up database migrations with one of these tools, or if you prefer a different approach.


## Project Summary

The Restaurant Management System is a Spring Boot-based application that provides functionality for managing users, food items, and orders. It includes role-based access control, allowing admins to manage users and add food items, while regular users can sign up, sign in, and place orders. Visitors can view the menu items. The project uses a MySQL database to store data and includes validation for email patterns and input fields. It offers RESTful API endpoints for user registration, authentication, order placement, and food menu retrieval.

For more details, refer to the source code and API documentation.

## License

This project is licensed under the [BSD 3-Clause License](LICENSE).

## Contact

For questions or feedback, please contact [Amit Ashok Swain](mailto:business.amitswain@gmail.com).

---
</p>
