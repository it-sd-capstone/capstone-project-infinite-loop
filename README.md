# Happenings – The Event Finder
## Overview
Happenings is our capstone web application that helps users discover, create, and manage social events.
The backend is built using Java Spring Boot, Maven, MySQL, and it runs on an embedded Tomcat server.
It also provides REST-style endpoints that handle event-related features and data.

We have successfully deployed our application publicly on Render.

https://capstone-project-infinite-loop-f0nr.onrender.com/

### Installation Instructions (Local Development)
Make sure the following are installed
- Java 21+
- Maven 3.9+
- MySQL
- Git

---

### Setup Steps
1. Clone the repository
   ```
   git clone https://github.com/it-sd-capstone/capstone-project-infinite-loop.git
   cd capstone-project-infinite-loop
   ```

2. Configure Database (Optional for local testing)
   - If using the database locally:
      ```
      CREATE DATABASE happenings;
      ```
   - Note: The production database is hosted on Railway and is already configured in Render.

3. Environment Variables
   - Set the following environment variables for database connection:
     - DB_HOST
     - DB_PORT
     - DB_NAME
     - DB_USER
     - DB_PASSWORD

   - Where to set them:
      - Locally: IDE run configuration or system environment variables
      - On Render: Environment Variables tab

4. Build the project
   ```
   mvn clean package
   ```
   This will generate:
   ```
   target/happenings.jar
   ```

5. Run the application locally
   Option 1: Run with Maven
   ```
   mvn spring-boot:run
   ```

   Option 2: run the JAR directly
   ```
   java -jar target/happenings.jar
   ```

   Then open:
   http://localhost:8080/
   
---

## Testing
Right now we are doing manual testing, and we will add automated testing later.
### 1. Basic Server Test
Open:
http://localhost:8080/

Or on Render:
https://capstone-project-infinite-loop-f0nr.onrender.com/

Expected result:
- Happenings is running!

---

### 2. Database Connection Test
Open:
http://localhost:8080/db-test

Or on Render:
https://capstone-project-infinite-loop-f0nr.onrender.com/db-test

Expected result:
- Database connection successful!

If the database is not connected, you will see:
- Database connection FAILED: <error message>

This endpoint confirms that:
- Spring Boot is connected to MySQL
- JDBC connection is working
- Environment variables are correctly set on Render
---

### 3. Events API Test
Open:
http://localhost:8080/api/events

Or on Render:
https://capstone-project-infinite-loop-f0nr.onrender.com/api/events

Expected result:
- JSON list of events
---

### Render Deployment
The application is deployed on Render as a Dockerized Spring Boot service.

### Build Process
- Maven builds project
- Spring Boot packages JAR
- Docker image is created and deployed
- Render runs the application automatically
```
java -jar happenings.jar
```
