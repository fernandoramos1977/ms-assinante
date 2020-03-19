pipeline {
    agent any
    tools {
        maven 'maven-3.6.3'
        jdk 'jdk-11'
    }
    stages {
        stage('Build') {
            steps {
               sh 'mvn clean test install'
        }
        }
        stage('Deploy') {
            steps {
               sh "docker-compose up --build"
            }
        }
    }
}