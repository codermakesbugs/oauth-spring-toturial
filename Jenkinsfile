pipeline {
  agent any

  options {
    buildDiscarder(logRotator(daysToKeepStr: "14", numToKeepStr: "5"))
  }

  stages {
    stage("Check environment") {
      steps {
        sh "whoami"
        sh "printenv"
      }
    }
  }
}
