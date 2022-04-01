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
  DOCKERHUB_CREDENTIALS=credentials('docker-hub-connect')
  
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
       //sh"'${MAVEN_HOME}/bin/mvn' wrapper:wrapper"
       sh"'${MAVEN_HOME}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      // sh "docker run -i rambo29/sample-jenkins-demo:latest"
   
      }
    }
     stage('build docker Image') {
      steps {
       sh "echo **************BUILD DOCKER IMAGE**************"
       script{
       docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-connect') {
      // docker.build('rambo29/sample-jenkins-demo:latest').push('latest')
        //sh"docker-compose build"
        //sh ""
       }
       }
      }
    }
   
    stage('Connect with AWS') {
      steps {
      
       sh "echo **************Connect With AWS**************"
       
       
     withAWS(credentials: 'jen-aws-key', region: 'eu-west-1') {
                    sh 'echo "hello Jenkins">hello.txt'
                    
                    s3Upload acl: 'Private', 
                    bucket: 'test-upload-77', 
                    file: 'hello.txt'
                   }
                    
                }
   
      }
    
    stage('CloudFormation') {
      steps {
      
       sh "echo **************create cloudformation**************"
       
       
     withAWS(credentials: 'jen-aws-key', region: 'eu-west-1') {
                    
                   s3Upload(file:'cf_EC2_D_DC.yaml',
                   bucket:'test-upload-77', 
                   path:'cftemplates/')
                     
                   s3Upload(file:'docker-compose.yaml',
                   bucket:'test-upload-77', 
                   path:'docker-compose/')
                    
                    cfnUpdate(stack:'my-test-stack',
                    url:'https://test-upload-77.s3.eu-west-1.amazonaws.com/cftemplates/cf_EC2_D_DC.yaml',
                    params:['SubnetID=subnet-219e7858'])
                    
                   // sh "echo deleting test-upload-777 bucket.... "
                   // s3Delete(bucket:'test-upload-777', path:'path/to/target/')
                    
                    
                }
   
      }
    }
   /*stage('Delete Cloud Formation') {
      steps {
        sh "echo **************DELETE CF**************"
        withAWS(credentials: 'jen-aws-key', region: 'eu-west-1') {
        cfnDelete(stack:'my-test-stack')
        }
      }
    }*/

   /* stage('Run Tests') {
      steps {
        sh "echo **************IN TESTS**************"
        sh 'echo running MVN tests'
        sh './mvnw clean test'
      }
    }*/
  }
}
