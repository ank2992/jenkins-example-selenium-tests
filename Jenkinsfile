pipeline {
  agent any
  stages {
    stage('SCM Checkout') {
      steps {
        sh 'echo in scm checkout'
        checkout scm: [$class: 'GitSCM', 
        branches: [[name: '*/main']], 
        userRemoteConfigs: [
          [url: 'git@github.com:ank2992/jenkins-example-selenium-tests',
          ,credentialsId:'connect-rambo-git']
          ]]
        
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
