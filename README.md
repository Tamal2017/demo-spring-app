## Spring Security 6.4 with Spring Boot 3.4, JWT Authentication using Postgres DB tutorial

## How to test

- Intall PostgresSQL or run a PostgresSQL container on your local machine
- Create a database named *test* with username=postgres & password=admin (you can change this in application.properties ans set what ever you want)
- Create a table named *myuser* and insert your first user, use [bcrypt - online](https://bcrypt-generator.com/) to encrypt your user password
- Use that user (username & password) juste created before  to *login* (by using the /login endpoint ) and obtain a JWT as response 
- Use that JWT as *Bearer Token* to hit other secure endpoints  
  - Students
    - *GET /students*
    - *POST /students*
    - *DELETE /student/{id}*
  - Users
    - *GET /users*
    - *POST /register*
    - *POST /login*
- You can also test other secure endpoints by using *Basic Auth* with username & password of a user present in your db
- You can also and add other users by using Post /register endpoint and use them to test other endpoints.