def repo="jenkins-example-selenium-tests"
pipeline {
  agent any
  tools{
    maven 'maven 3.8.1'
    jdk 'openJDK11'
  }
  environment{
  JAVA_HOME= tool name:'openJDK11'
  MAVEN_HOME= tool name:'maven 3.8.1'
  
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
       sh"'${MAVEN_HOME}/bin/mvn' -Dmaven.test.failure.ignore clean package"
   
      }
    }
    stage('Connect with AWS') {
      steps {
      
       sh "echo **************Connect With AWS**************"
       
     withAWS(credentials: 'jen-aws-key', region: 'us-east-1') {
                    sh 'echo "hello Jenkins">hello.txt'
                    s3Upload acl: 'Private', bucket: 'test-upload-777', file: 'hello.txt'
                    s3Download bucket: 'devopslee', file: 'downloadedHello.txt', 
                    path: 'hello.txt'
                    sh 'cat downloadedHello.txt'
                }
   
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
