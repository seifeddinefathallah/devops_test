pipeline {
    environment { 
          registry = "rayenkharbeche/devops" 
          registryCredential = 'dockerHub' 
          dockerImage = 'devops' 
        }
    
    agent any

    stages {
        stage('Getting the project from GIT') {
            steps {
               echo 'Pulling..';
                git branch: 'rayen-tpachat',
                url: 'https://github.com/seifeddinefathallah/devops_test.git';
            }
        }
        
      stage('Cleaning the project') {
             
            steps {
                echo 'cleaning project ...'
                sh 'mvn clean'
            }
        }
      
        stage('MVN Compile') {
             
            steps {
                echo "MVN Compile"
                sh 'mvn compile'
            }
        }
        stage('MVN TEST') {
             
            steps {
                echo 'Test'
                sh 'mvn test'
            }
            
            post{
                always{
                    junit '**/target/surefire-reports/TEST-*.xml'
                    }
                } 
        }
        
       stage('Nexus'){
             steps{
                 echo "nexus"
                 sh'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpachat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.55:8081/repository/deploymentRepo/ -Dfile=target/tpachat-1.0.jar '
             }
         }
          stage(' Sonarqube') {
             
            steps {
                echo "Sonarqube"
              
                    sh "  mvn sonar:sonar \
                   -Dsonar.projectKey=devops \
                   -Dsonar.host.url=http://192.168.1.55:9000 \
                   -Dsonar.login=92957ad1a8621101c3e87e894130b5fe46435598"
            }
           } 
            
          stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar-instance') {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                }
            }
        }
        /* stage("Quality Gate"){
            options {
                 timeout(time: 1, unit: 'HOURS') 
                 }
            steps {
                 script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                          error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
        }*/
     
        stage('Login') {

			steps {

				sh 'docker login -u rayenkharbeche -p dockerhub'
			}
		}
	
        stage('Build image Docker') {
            steps{
                   echo"Build Docker"
                  
                   sh 'docker build -t rayenkharbeche/devops .'
                 }
         }
         
         
         stage(' Dockerpush') {
            steps{
                   echo"Docker push "
                  
                   sh 'docker push rayenkharbeche/devops '
                 }
         } 
         
     
       
        stage('docker compose') {
            steps{
                   echo"docker compose"
                
                
                  sh 'docker-compose up '
                 }
         }
     /*  stage('Send Mail Ok') { 
            steps { 
                echo "Ok" 
            } 
        }*/
         

}
/* post {
        always {
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }  
*/
}