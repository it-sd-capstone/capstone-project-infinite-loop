# Use official Tomcat image with Java 21 support
FROM tomcat:10.1-jdk21

# Remove default apps from Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your built WAR file into Tomcat as ROOT app
COPY target/happenings.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]