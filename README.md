# Blood Sample Management API

## Overview

The **Blood Sample Management API** is a RESTful API built using Java and Spring Boot to manage blood sample records efficiently. This API facilitates the storage, retrieval, and management of blood samples for healthcare and research institutions.

## Features

- CRUD operations for blood samples
- Secure authentication and authorization
- Blood sample tracking and status updates
- Integration with a database for persistent storage
- RESTful API endpoints

## Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MySQL / PostgreSQL (configurable)
- **Security**: Spring Security (JWT Authentication)
- **Build Tool**: Maven

## Installation

### Prerequisites

Ensure you have the following installed:

- Java 17+
- Maven
- MySQL/PostgreSQL

### Steps

1. Clone the repository:
   ```sh
   git clone https://github.com/bhautikpatel9/Blood-Sample-Management-API.git
   cd Blood-Sample-Management-API
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blood_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. Access the API at `http://localhost:8080`

## API Endpoints

| Method | Endpoint        | Description                            |
| ------ | --------------- | -------------------------------------- |
| GET    | `/samples`      | Retrieve all blood samples             |
| GET    | `/samples/{id}` | Get details of a specific blood sample |
| POST   | `/samples`      | Add a new blood sample                 |
| PUT    | `/samples/{id}` | Update an existing blood sample        |
| DELETE | `/samples/{id}` | Delete a blood sample                  |

## Security

- Uses JWT-based authentication.
- Users must be authenticated to perform operations.

## Contributing

1. Fork the repository
2. Create a new branch (`feature/your-feature`)
3. Commit your changes
4. Push the branch and create a pull request


## Contact

For any queries or contributions, reach out to [Bhautik Sidhdhapara](https://github.com/bhautikpatel9).
