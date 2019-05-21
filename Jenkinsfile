pipeline {
  agent any
  stages {
    stage('Commit') {
      steps {
         bash '''#!/bin/bash
                 gradlew test'''
      }
    }
  }
}
