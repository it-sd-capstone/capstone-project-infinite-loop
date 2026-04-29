# Happenings – The Event Finder
## Overview
Happenings is our capstone web application that helps users discover, create, and manage social events. 
The backend is built using Java Spring Boot, Maven, MySQL, and it runs on an embedded server. 
It also provides REST-style endpoints that handle event-related features and data. 
We have successfully deployed our application publicly on Render.

### Installation Instructions (Local Development)
Make sure the following are installed
- Java 21+
- Spring Boot 3.3.2
- Maven 3.9+
- MySQL Server
- Git
- Embedded Tomcat (via Spring Boot)
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
    - Import the database schema from the `/db` folder using MySQL Workbench:
       - Go to Server → Data Import
       - Select "Import from Self-Contained File"
       - Choose the `.sql` file in `/db`
       - Select the `happenings` schema
       - Click Start Import

3. Environment Variables
    - Set the following environment variables for database connection:
      - MYSQLHOST – database host (e.g. localhost or cloud DB host)
      - MYSQLPORT – database port (default: 3306)
      - MYSQLDATABASE – database name (happenings)
      - MYSQLUSER – database username
      - MYSQLPASSWORD – database password
      
    - Where to set them:
      - Locally: IDE run configuration or system environment variables
      - On Render: Enviroment tab in the service dashboard

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
   ```
   http://localhost:8080/
   ```
---

## Testing
### 1. Basic Server Test
Open:
```
http://localhost:8080/
```
Expected result:
```
Happenings is running!
```
---

### 2. Error Handling Test
Open a non-existent route:
```
http://localhost:8080/invalid-route
```
Expected result:
- HTTP 404 response
---

### 3. Events API Test
Open:
```
http://localhost:8080/api/events
```
Expected result:
- JSON list of events
---

### Render Deployment 
The application is deployed on Render as a Spring Boot JAR service.

### Build Process
- Maven builds the project
- Spring Boot packages into executable JAR
- Render runs:
```
java -jar happenings.jar
```
Live URL
https://capstone-project-infinite-loop-f0nr.onrender.com/
