def repo="jenkins-example-selenium-tests"
pipeline {
  agent any
  tools{
    maven 'maven 3.8.1'
    jdk 'openJDK11'
  }
  environment{
  JAVA_HOME= tool name:"${JAVA_HOME}"
  MAVEN_HOME= tool name:"${MAVEN_HOME}"
  
  }
  stages {
    stage('Initialize') {

      steps {
       sh "echo **************IN INITIALIZE**************"
       sh''' 
       echo "PATH=${PATH}"
       echo "M2_HOME=${M2_HOME}"
       echo "JAVA_HOME=${JAVA_HOME}"
       echo "MAVEN_HOME=${MAVEN_HOME}"
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
       sh"'${MAVEN_HOME}/bin/mvn' clean"
   
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
