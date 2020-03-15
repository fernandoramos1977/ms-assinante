FROM openjdk:11
WORKDIR /target
COPY assinante-1.0.0.jar src/
EXPOSE 9090
WORKDIR src
RUN chmod 777 assinante-1.0.0.jar
CMD [ "java", "-jar", "-Dserver.port=9090", "assinante-1.0.0.jar" ]
# ENTRYPOINT ["java","-jar","-Dserver.port=9090","assinante-1.0.0.jar"]