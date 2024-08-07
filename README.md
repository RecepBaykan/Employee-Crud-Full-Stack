# Employee Management Full Stack Application

This is a simple full-stack application for managing employees, built with Spring Boot for the backend and React with Vite for the frontend.

## Prerequisites

- **Java 11 or higher**
- **Maven**
- **Node.js**
- **npm**

## Backend Setup (Spring Boot)
1. Clone the repository:
    ```bash
    git clone https://github.com/RecepBaykan/Employee-Crud-Full-Stack.git
    ```

2. Navigate to the backend directory:
    ```bash
    cd Employee-Crud-Full-Stack/Springboot
    ```

3. Use Maven to install or update the project dependencies:
    ```bash
    mvn clean install
    ```

4. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```
   Alternatively, you can run the application from your IDE by running the `main` method in `ProjeApplication.java`.

## Frontend Setup (React with Vite)

1. Navigate to the frontend directory:
    ```bash
    cd Employee-Crud-Full-Stack/React
    ```

2. Install the npm packages:
    ```bash
    npm install
    ```

3. Start the React development server:
    ```bash
    npm run dev
    ```

## Usage

Once both the backend and frontend servers are running, you can access the application in your web browser at:
http://localhost:5173


## Additional Information

- Make sure you have the required versions of Java, Maven, Node.js, and npm installed.
- The Spring Boot backend uses an embedded H2 database for development purposes. For production, you should configure a different database.
- The React frontend is set up with Vite for faster build times and hot module replacement.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.
