# capstone-project-infinite-loop

A web application that allows users to discover, create, and manage social events.

# Happenings – Event Finder

## Elevator Pitch

Happenings is a full-stack web application that allows users to discover, create, and manage social events. Built using Java Servlets and deployed on Apache Tomcat, the project demonstrates backend web development concepts including routing, Maven-based builds, and database integration. It connects to a cloud-hosted MySQL database (Railway) using environment variables configured in the server. The system serves as a foundation for a larger event management platform that will include user accounts, event creation, and interactive social features.

---

## Repository

https://github.com/it-sd-capstone/capstone-project-infinite-loop

---

## Installation Instructions

### Prerequisites

Make sure the following are installed:

- Java JDK 17 or higher
- Apache Maven
- Apache Tomcat 10+
- Internet connection (required for Railway database access)

---

### Steps to Install

1. Clone the repository:

   ```
   git clone https://github.com/it-sd-capstone/capstone-project-infinite-loop.git
   cd capstone-project-infinite-loop
   ```

2. Build the project using Maven:

   ```
   mvn clean package
   ```

3. Locate the generated WAR file:

   ```
   target/happenings.war
   ```

4. Deploy the WAR file to Tomcat:
    - Copy it into:
      ```
      C:\Program Files\Apache Software Foundation\Tomcat 10\webapps
      ```

    - OR deploy using IntelliJ Tomcat Run Configuration.

5. Start Tomcat server.

---

## Testing Instructions

Make sure Tomcat is running before testing endpoints.

### 1. Backend Test

Open browser:

   ```
   http://localhost:8080/happenings/test
   ```
### Expected output:

   ```
   Happenings backend is working!
   ```
---

### 2. Database Test

Open browser:

```
http://localhost:8080/happenings/db-test
```
Expected outcomes:

- ✅ Database connection successful → system fully functional
- ❌ Access denied → incorrect credentials or permissions issue
- ❌ null:null error → missing environment variables in Tomcat

---

## Access / Running Instructions

After starting Tomcat:

### Main application endpoint:

```
http://localhost:8080/happenings/test
```

### Database test endpoint:
```
http://localhost:8080/happenings/db-test
```

---

## Environment Variable Setup (Required for Database)

In IntelliJ IDEA:

Run → Edit Configurations → Tomcat Server → Startup/Connection

Add the following environment variables:

- MYSQLHOST = shuttle.proxy.rlwy.net
- MYSQLPORT = 41554
- MYSQLDATABASE = railway
- MYSQLUSER = root
- MYSQLPASSWORD = FcbZBsceyzkySTsgCroWIaApNjhdmnpl

---

## Build & Run Summary

- Build: `mvn clean package`
- Deploy: Tomcat webapps or IntelliJ configuration
- Run: Start Tomcat server
- Access:
    - `/test` → backend verification
    - `/db-test` → database verification

---

## Release Notes (v0.0.0)

- Maven project initialized
- Servlet backend implemented
- Tomcat deployment configured
- `/test` endpoint added
- `/db-test` endpoint added for MySQL testing
- Railway MySQL integration configured via environment variables

---

## Important Notes

- Database connection requires correct Tomcat environment variables
- Do NOT hardcode credentials in source code
- Project uses a cloud-hosted MySQL database (Railway)
- Local testing depends on proper server configuration