pipeline {
  agent {
    docker {
      image 'griefed/baseimage-ubuntu-jdk17-kotlin:1.0.13'
      args '--network="host"'
    }
  }
  environment {
    TEST = 'test'
  }
  options {
    ansiColor('xterm')
  }
  stages {
    stage('Run tests') {
      parallel {
        stage('Unit tests') {
          steps {
            sh './gradlew test'
          }
        }
        stage('Integration tests') {
          steps {
            sh './gradlew integrationtest'
          }
        }
      }
    }
  }
  post {
    always {
      cleanWs()
    }
  }
}