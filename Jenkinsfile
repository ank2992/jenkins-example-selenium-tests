pipeline {
  agent any
  stages {

    stage('SCM Checkout') {

      steps {
        script{
          repo="jenkins-example-selenium-tests"
        }
        sh 'echo in scm checkout'
        checkout scm: [$class: 'GitSCM',
        branches: [[name: '*/main']],
        userRemoteConfigs: [
          [url: 'git@github.com:ank2992/${repo}',
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
