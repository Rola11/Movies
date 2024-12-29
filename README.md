# Movies Dashboard

## Project Description
Movies Dashboard is a web application that allows users to search for movies, view details, and manage movie data. The backend is built with Spring Boot and the frontend is built with Angular.

## Technologies Used
- Java
- Spring Boot
- Maven
- SQL
- Angular
- TypeScript


## Installation

### Backend
1. Clone the repository:
    ```bash
    git clone https://github.com/Rola11/Movies.git
    cd movies-dashboard
    ```

2. Configure the database:
    - Create a database named `movies_dashboard`.
    - Update the database configuration in `src/main/resources/application.properties`:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/movies_dashboard
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```

3. Build the project:
    ```bash
    mvn clean install
    ```

### Frontend
1. Navigate to the frontend directory:
    ```bash
    cd front-end
    ```

2. Install dependencies:
    ```bash
    npm install
    ```

## Running the Backend
1. Navigate to the backend directory:
    ```bash
    cd movies-dashboard
    ```

2. Run the application:
    ```bash
    mvn spring-boot:run
    ```

The backend server will start at `http://localhost:8080`.

## Running the Frontend
1. Navigate to the frontend directory:
    ```bash
    cd front-end
    ```

2. Start the Angular development server:
    ```bash
    ng serve
    ```

The frontend server will start at `http://localhost:4200`.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.