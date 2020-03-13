FROM openjdk:11
WORKDIR /target
COPY assinante-1.0.0.jar src/
EXPOSE 8080
WORKDIR src
RUN chmod 777 assinante-1.0.0.jar
ENTRYPOINT ["java","-jar","assinante-1.0.0.jar"]