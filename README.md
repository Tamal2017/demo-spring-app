## Spring Security tutorial using JWT Authentication & Postgres DB

## How to test

- Intall PostgresSQL or run a PostgresSQL on your local machine
- Create a database named *test* with username=postgres & password=admin (you can change this in application.properties ans set what ever you want)
- Insert a user in your database in the table *myuser* and used [bcrypt - online](https://bcrypt-generator.com/) to encrypt the password
- Use that user juste created before to *login* (by using the /login endpoint ) and obtain a JWT as response 
- Use that JWT as *Bearer Token* to hit other secure endpoints  
  - Students
    - *GET /students*
    - *POST /students*
    - *DELETE /student/{id}*
  - Users
    - *GET /users*
    - *POST /register*
    - *POST /login*
- You can also test secure endpoints by using *Basic Auth* with username & password
- You can also and add other users by using Post /register endpoint and use them to test other endpoints.