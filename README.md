## Spring Security 6.4 with Spring Boot 3.4, JWT Authentication using Postgres DB tutorial

## How to test

- Intall PostgresSQL or run a PostgresSQL container on your local machine
- Create a database named *test* with username=postgres & password=admin (you can change this in application.properties and set whatever you want)
- Create a table named *users*
  ```sql
    DROP TABLE IF EXISTS users;
    CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(64),
    password VARCHAR(512)
    );
    ```    
- Use the user (username & password) juste created before  to *login* (by using the /login endpoint ) and obtain a JWT as response 
- Use that JWT as *Bearer Token* to hit other secure endpoints  
  - Students
    - *GET /students*
    - *POST /students*
    - *DELETE /student/{id}*
  - Users
    - *GET /users*
    - *POST /register*
    - *POST /login*
- You can also *Basic Auth* with username & password to hit other secured endpoints
- You can also and add other users by using Post /register endpoint and use them to test other endpoints.