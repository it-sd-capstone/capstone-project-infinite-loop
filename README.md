# Happenings – Event Finder
## Overview
Happenings is a Java servlet web application for discovering, creating, and managing social events. It runs on Apache Tomcat and is built using Maven. The project includes basic servlet routing and connects to a MySQL database using environment variables configured in the server. Both local and Railway-hosted databases were used during development.  The current version is a working skeleton of the system. Backend and database features are still being developed and tested. Future work includes user accounts, event creation, and additional functionality.

---

### Requirements
Make sure the following are installed:
- Java JDK 17 or higher
- Apache Maven
- Apache Tomcat 10+
- MySQL Server (required for database functionality)
- MySQL Workbench (used for database setup and importing the schema)
---

### Steps to Install
1. Clone the repository
   ```
   git clone https://github.com/it-sd-capstone/capstone-project-infinite-loop.git
   cd capstone-project-infinite-loop
   ```
   
2. Create the database  
   - Open MySQL Workbench and connect to your local MySQL server.  
   - Run:
      ```
      CREATE DATABASE happenings;
      ```  
   - Then import the SQL file:
     - Go to Server → Data Import 
     - Select Import from Self-Contained File 
     - Choose the .sql file in the /db folder 
     - Select schema: happenings 
     - Click Start Import  
     
   Expected result:
    - Database is created
    - Tables are visible in MySQL Workbench 
     
3. Set environment variables
   - In IntelliJ Tomcat configuration:
     - MYSQLHOST 
     - MYSQLPORT 
     - MYSQLDATABASE 
     - MYSQLUSER 
     - MYSQLPASSWORD
   - These must match your local or cloud MySQL setup.
   
   Expected result:
   - Application can connect to the database at runtime 
     
4. Build the project
   ```
   mvn clean package
   ```
   Expected result:
   ```
   target/happenings.war is created
   ```
      
5. Deploy the WAR file to Tomcat:
   - Option A: Manual deployment 
     - Copy it into happenings.war
     - Paste into Tomcat/webapps/
     - Start Tomcat server

   - Option B: IntelliJ deployment (recommended)
     - Add artifact: happenings:war exploded 
     - Run Tomcat from IntelliJ
         
6. Run the application 
   - Open:
   ```
   http://localhost:8080/happenings/test
   ```
   Expected result:
   - Happenings backend is working!
---

## Testing
### Test 1: Backend Endpoint
Steps:
1. Start Tomcat server
2. Open in browser:
```
http://localhost:8080/happenings/test
```
Expected result:
- Happenings backend is working!
---

### Test 2: Database Connection
Steps:
1. Ensure MySQL server is running
2. Confirm environment variables are set in Tomcat
3. Open in browser
```
http://localhost:8080/happenings/db-test
```
Expected result:
- Database connection successful → system is working correctly
- Error message → check credentials or environment variables