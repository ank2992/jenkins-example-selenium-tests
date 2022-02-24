def repo="jenkins-example-selenium-tests"
pipeline {
  agent any
  tools{
    maven 'maven 3.8.1'
    jdk 'openJDK11'
  }
  stages {
    stage('Initialize') {
      
      steps {
       sh''' 
       echo "PATH=${PATH}"
       echo "M2_HOME=${M2_HOME}"
       '''
      }
    }

    stage('SCM Checkout') {

      steps {
        
        sh "echo in scm checkout from ${repo}"
        sh "echo in scm checkout from ${repo}"

        checkout scm: [$class: 'GitSCM',
        branches: [[name: '*/main']],
        userRemoteConfigs: [
          [url: "git@github.com:ank2992/${repo}",
          ,credentialsId:'connect-rambo-git']
          ]]

      }
    }
    stage('build') {
      steps {
       sh"mvn clean install"
      }
    }

    stage('Verify browsers are installed') {
      steps {
        sh 'echo checking driver connections' 
      }
    }
    stage('Run Tests') {
      steps {
        sh 'echo running MVN tests'
        sh './mvnw clean test'
      }
    }
  }
}
