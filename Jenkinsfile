pipeline{
          agent any
           tools{
              maven 'maven'
                  }
            stages{
          
                stage('sonarqube deployment Stages'){
                      steps{
                          bat 'mvn clean compile' 
                                     }
}
                stage('compile Stages'){
                      steps{
                          bat 'sonar:sonar' 
                                     }
                               }
}
}
