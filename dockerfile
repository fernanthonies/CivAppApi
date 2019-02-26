FROM openjdk:8-jdk-alpine
ENV STEAM_API_KEY=EEE219C67E9635ED67092862807F0BF8
EXPOSE 8080
ADD /build/libs/api-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java", "-jar", "api.jar"]