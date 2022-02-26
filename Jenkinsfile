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
       sh "echo **************IN INITIALIZE**************"
       sh''' 
       echo "PATH=${PATH}"
       echo "M2_HOME=${M2_HOME}"
       '''
      }
    }

    stage('SCM Checkout') {

      steps {
     
        sh "echo **************IN CHECKOUT FROM ${repo}**************"

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
       sh "echo **************IN BUILD**************"
       sh"mvn clean package"
      }
    }

    stage('Run Tests') {
      steps {
        sh "echo **************IN TESTS**************"
        sh 'echo running MVN tests'
        sh './mvnw clean test'
      }
    }
  }
}
