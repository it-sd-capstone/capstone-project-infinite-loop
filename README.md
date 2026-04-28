# Happenings – The Event Finder
## Overview
Happenings is our capstone web application that helps users discover, create, and manage social events.
Backend is built with Java Servlets and Maven, deployed on Apache Tomcat, and is connected to a MySQL database.
Our Application supports event-related endpoints and database connectivity, with plans for user accounts and full event management features.

---

### Link to our Official site
You can access the deployed version here:
```
https://capstone-project-infinite-loop-production.up.railway.app/
```
Note:
- Some features may still be in development
- Backend test endpoints may not be publicly exposed

### Installation Instructions
Make sure the following are installed
- Java JDK 17 or higher
- Apache Maven
- Apache Tomcat 10+
- MySQL Server (required for database functionality)
- MySQL Workbench (used for database setup and importing the schema)
---

### Setup Steps
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
    - Import schema:
        - Go to Server → Data Import
        - Select Import from Self-Contained File
        - Choose the .sql file in the /db folder
        - Select schema: happenings
        - Click Start Import

   Expected result:
    - Database is created

3. Configure environment variables
    - Set the following in your Tomcat configuration:
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

5. Deploy the WAR file to Tomcat
    - Option A: Manual deployment
        - Copy it into happenings.war
        - Paste into Tomcat/webapps/
        - Start Tomcat server

    - Option B: IntelliJ deployment (recommended)
        - Add artifact: happenings:war exploded
        - Run Tomcat from IntelliJ
        - Access:
      ```
      http://localhost:8080/happenings_war_exploded/test
      ```
   Note:
    - The URL differs because IntelliJ deploys the app using the artifact name (happenings_war_exploded).

6. Run the application
    - After deploying and starting Tomcat, open one of the following URLs depending on your setup:
    - If you used manual deployment (WAR file in /webapps):
   ```
   http://localhost:8080/happenings/test
   ```
    - If you used IntelliJ deployment (war exploded):
   ```
   http://localhost:8080/happenings_war_exploded/test
   ```
   Expected result:
    - Happenings backend is working!

   Note:
    - If you see a 404 error, double-check:
        - the application name in your Tomcat deployment
        - whether Tomcat is running
        - which deployment option you used
---

## Testing
This project currently uses manual endpoint testing.

### Test 1: Backend Endpoint
Steps:
1. Start Tomcat server
2. Open
   Option A:
```
http://localhost:8080/happenings/test
```
Option B:
```
http://localhost:8080/happenings_war_exploded/test
```
Expected result:
- Happenings backend is working!
---

### Test 2: Database Connection
Steps:
1. Ensure MySQL server is running
2. Confirm environment variables are set in Tomcat
3. Open
   Option A:
```
http://localhost:8080/happenings/test
```
Option B:
```
http://localhost:8080/happenings_war_exploded/test
```
Expected result:
- Success → database connected
- Error → configuration issue