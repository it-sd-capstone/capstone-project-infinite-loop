# capstone-project-infinite-loop
A web application that allows users to discover, create, and manage social events. 

Happenings – Event Finder
Elevator Pitch

Happenings is a full-stack web application that allows users to discover, create, and manage social events. The application is built using Java Servlets and deployed on Apache Tomcat. It currently focuses on validating backend functionality, including servlet routing, Maven builds, and server deployment. Future updates will expand the system into a complete event management platform with database integration, user accounts, and interactive event features.
Installation Instructions

To set up and run this project locally, install the following:

    Java JDK 17 or higher
    Apache Maven
    Apache Tomcat 10 or compatible version

Steps:

    Clone the repository:

    git clone https://github.com/kvang40cvtc/happenings.git
    cd happenings

    Build the project using Maven:

    mvn clean package

    Locate the generated WAR file:

    target/happenings.war

    Deploy the WAR file to Tomcat:

    Copy it into:

    C:\Program Files\Apache Software Foundation\Tomcat 10\webapps

    OR deploy using IntelliJ Tomcat run configuration

    Start the Tomcat server.

Testing Instructions

To verify the backend is working correctly:

    Ensure Tomcat is running and the application is deployed.

    Open a web browser.

    Navigate to:

    http://localhost:8080/happenings/test

Expected output:

Happenings backend is working!

If this message appears, it confirms that:

    Java Servlets are functioning correctly
    The application builds successfully with Maven
    The project deploys and runs on Tomcat

Running / Access Instructions

Once the server is running, access the application at:

http://localhost:8080/happenings/test

This endpoint is used to confirm that the backend is successfully deployed and responding. Future versions of the application will include additional endpoints for event browsing, creation, and user interaction.
Release Notes

Version v0.0.0 includes:

    Initial Maven project setup
    Basic servlet implementation (/test endpoint)
    Successful deployment to Apache Tomcat
    Validation of full backend stack integration

Notes

    No database setup is required for this version.
    This project is intended to validate backend integration and deployment.
    The application can be built and run entirely through Maven and Tomcat without requiring additional tools beyond an IDE..

