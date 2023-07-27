# Use a lightweight base image for Java
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory inside the container
WORKDIR /app
RUN pwd
RUN ls
# Copy the Spring Boot application JAR into the container
COPY ServiceRegistry/target/ServiceRegistry-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application is running on (change the port accordingly)
EXPOSE 8761

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
