# confident-spring-08-spring-data-jdbc
This repository is related to module 8 in Marco Behler's course "The confident Spring professional" https://www.marcobehler.com/ which I purchased in order to understand the fundamentals of Spring. The course starts with plain Java backend and introduces plain Spring features little by little, showcasing what Spring Boot hides under the hood. At the end of the course Spring Boot features are implemented.

## Learning goals  
Short module. Showcases how data access is made easier but often times requires understanding the underlying technology.  
- Replace spring-jdbc with Spring Data JDBC.  

## Getting Started

To run the application, you have two choices:
1. Run locally
2. Run in Docker

### Locally

1. Ensure all the dependencies are installed
2. Clone the repository  
3. Build the project using Maven: 
    ```sh
    mvn clean install
    ```
4. Run the application with: 
    ```sh
    java -jar target/confident-08-spring-data-jdbc-0.0.1-SNAPSHOT.jar
    ```

### Run in Docker
1. Build the image:
    ```shell
    docker build . -t confident-08:latest     
    ```
2. Run the image:
    ```shell
    docker run -it -p 8080:8080 confident-08:latest 
    ```
3. Open the api in http://localhost:8080
