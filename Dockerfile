#FROM maven:3.8.3-openjdk-17 AS build
#COPY pom.xml /
#COPY src /src
#RUN mvn -f /pom.xml clean package -DskipTests
#FROM openjdk:17-jdk-alpine
#ENV JAVA_OPTS ""
#COPY --from=build /target/exercise-app.jar /usr/app/exercise-app.jar
#EXPOSE 8080
#CMD exec java $JAVA_OPTS -jar /usr/app/exercise-app.jar $0 $@

# Build stage
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean test package

# Package stage
FROM openjdk:17-jdk-alpine
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]