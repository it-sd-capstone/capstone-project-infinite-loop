# Happenings – The Event Finder
## Overview
Happenings is our capstone web app that helps users discover, create, and manage social events.
The backend is built with Java Spring Boot, Maven, MySQL, running on an embedded Tomcat server.
The frontend uses HTML templates and static resources, fully connected to our REST APIs.
All pages, forms, and dynamic data are now served through Spring controllers, making the app fully functional and compatible with Render deployment.

Check out the live app:
https://capstone-project-infinite-loop-f0nr.onrender.com/

### Requirements (Local Development)
Before running the app locally, make sure you have:
- Java 21+
- Maven 3.9+
- MySQL
- Git

---

### Setup Instructions
1. Clone the repository
   ```
   git clone https://github.com/it-sd-capstone/capstone-project-infinite-loop.git
   cd capstone-project-infinite-loop
   ```

2. Database Setup (Optional for local testing)
      ```
      CREATE DATABASE happenings;
      ```
   - The production database is hosted on Railway and is already configured in Render.

3. Environment Variables
   - Set the following for database connection:
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
   This creates:
   ```
   target/happenings.jar
   ```

5. Run the application locally
   Option 1: With Maven
   ```
   mvn spring-boot:run
   ```

   Option 2: With the JAR
   ```
   java -jar target/happenings.jar
   ```

   Then open:
   ```
   http://localhost:8080/
   ```
---

## Testing
Right now we are doing manual testing, and we will add automated testing later.
### 1. Server Test
Open the app locally:
   ```
   http://localhost:8080/
   ```

Or on Render:
https://capstone-project-infinite-loop-f0nr.onrender.com/

Expected result:
- The homepage loads, and navigation links work: Dashboard, All Events, My Events, Saved, Profile.

---

### 2. Database Connection Test
Open locally:
```
http://localhost:8080/api/db-test
```

Or on Render:
https://capstone-project-infinite-loop-f0nr.onrender.com/api/db-test

Expected result:
- Database connection successful!

This confirms that Spring Boot is connected to MySQL, JDBC is working, and environment variables are correct.

---

### 3. Events API Test
Open locally:
```
http://localhost:8080/api/events
```

Or on Render:
https://capstone-project-infinite-loop-f0nr.onrender.com/api/events

Expected result:
- Returns a JSON list of events from the database.
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
