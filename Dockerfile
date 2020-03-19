FROM openjdk:11
WORKDIR /var/lib/jenkins/workspace/pipeline_/target
COPY assinante-1.0.0.jar infra/
WORKDIR ./infra
RUN chmod 777 assinante-1.0.0.jar
EXPOSE 9090
CMD [ "java", "-jar", "-Dserver.port=9090", "assinante-1.0.0.jar" ]

