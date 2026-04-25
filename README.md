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

Set up Tomcat/mySQL
    Open Tomcat Configuration

    Go to Run → Edit Configurations

    Select your Tomcat Server configuration

    Open the Startup/Connection Tab

    Click the Startup/Connection tab

    Add Environment Variables
        
        Use the Environment Variables section to add the following key/value pairs:
        Name	Value
        MYSQLDATABASE	railway
        MYSQLHOST	shuttle.proxy.rlwy.net
        MYSQLPASSWORD	FcbZBsceyzkySTsgCroWIaApNjhdmnpl
        MYSQLPORT	41554
        MYSQLUSER	root

        These values are required for the application to attempt a connection to the Railway-hosted MySQL instance.

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



How to Run the Database Test

    Start Tomcat from IntelliJ.

    Make sure the project is deployed under the context path:
    
    Code
    
    /happenings
    
        Open your browser and navigate to:
    
    Code
    
    http://localhost:8080/happenings/db-test
    
    What You Should See
    
    The servlet prints the environment variables it receives and then attempts a live JDBC connection.
    
    A successful connection will display:
    Code
    
    Database connection successful!
    
    If the connection fails, the servlet will show:
    
        The values of the environment variables Tomcat received
    
        The full exception message from MySQL
    
        Any authentication or networking errors returned by Railway
    
    This endpoint is intended for debugging only and should not be used in production.

Version v0.0.0 includes:

    Initial Maven project setup
    Basic servlet implementation (/test endpoint)
    Successful deployment to Apache Tomcat
    Validation of full backend stack integration

Notes

    No database setup is required for this version.
    This project is intended to validate backend integration and deployment.
    The application can be built and run entirely through Maven and Tomcat without requiring additional tools beyond an IDE..

