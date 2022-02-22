pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
      steps {
        sh 'echo checking driver connections'
        sh '/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --version                                                                            
Google Chrome 59.0.3071.104 '
        sh 'firefox --version'
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
