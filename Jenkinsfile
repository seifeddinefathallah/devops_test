pipeline{

	agent any
     
     /*environment {
        dockerhub=credentials('dockerhub')
	}
       */
	stages {
	    
                stage ('Git') {
            steps {
                
                //git 'https://github.com/mhassini/timesheet-devops.git'
                git branch: 'seifeddine-fathallah', 
                url: 'https://github.com/seifeddinefathallah/devops_test.git'
                 
		        
            }
        }
        stage ('Maven Clean') {
            steps {

                sh 'mvn clean'
            }
        }
        stage ('Maven Compile') {
            steps {

                sh 'mvn compile'
            }
        }
          stage ('Maven Build') {
            steps {

                sh 'mvn clean install -Dskip.test=true'
            }
        }
      stage ('Maven Test Sonar') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=jenkins'
            }

        }
         stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar-instance') {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=jenkins'
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
       /* stage("Quality gate") {
            steps {
                withSonarQubeEnv('sonar-instance') {
               waitForQualityGate abortPipeline: true
                } 
                
            }
        }*/
      
        /*stage ('Maven Test JUnit') {
            steps {
                echo 'mvn test'
            }
        }*/
        stage("convert the code to package"){
            steps{
                sh "mvn clean package"
                echo 'convert the files to war file'
            }
        }
        stage("testing the code"){
            steps{
                sh "mvn test"
                echo 'No Errors'
            }
            post{
                always{
                    junit '**/target/surefire-reports/TEST-*.xml'
                    }
                } 
               
        }
        stage('Jacoco Static Analysis') {
            steps{
             jacoco()
            }
        }
        stage ('Maven Deploy Nexus') {
            steps {
                sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
            }
        }
        stage('Docker Build') {

			steps {
				sh 'docker build -t seifeddine7/spring-app:latest .'
			}
		}

		stage('DockerHub Login') {

			steps {

				sh 'docker login -u seifeddine7 -p 181Jmt2141'
			}
		}

		stage('Docker Push') {

			steps {
			    sh 'docker login -u seifeddine7 -p 181Jmt2141'
				sh 'docker push seifeddine7/spring-app:latest'
			}
		post {
		   always {
			 sh 'docker logout'
	       }
	    }
		}
		stage('Docker-Compose Up') {

			steps {
				 sh 'docker-compose up '
			}
		}
		stage('Docker-Compose logs') {

			steps {
				sh 'docker-compose logs'
			}
		}
		stage('Docker-Compose Down') {

			steps {
				sh 'docker-compose down'
			}
		}
	}
    post {

                        success {
                            mail to: "seifeddine.fathallah@esprit.tn",
                            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n, More info at: ${env.BUILD_URL}",
                            from: 'seifeddine.fathallah@esprit.tn',
                            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
                        }
                        failure{
                            mail to: "seifeddine.fathallah@esprit.tn",
                            subject: "Jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                            from: 'seifeddine.fathallah@esprit.tn',
                            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                        }
                         changed{
                            mail to: "seifeddine.fathallah@esprit.tn",
                            subject: "Jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                            from: 'seifeddine.fathallah@esprit.tn',
                            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                        }
        }
	
      
}