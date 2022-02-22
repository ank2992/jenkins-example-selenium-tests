pipeline {
  agent any
  stages {
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
