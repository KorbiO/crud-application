pipeline {
	agent any
	tools {
    maven 'maven-3'
    jdk 'java'
  }
  
	stages {
		stage('SCM Checkout'){
			steps{
        	git credentialsId: 'gitPwd', url: 'https://github.com/KorbiO/crud-application'
        		}
    }
		stage('Compile') {
			steps {
			withMaven(maven : 'maven-3'){
				
				bat './mvnw clean compile'
				bat './mvnw package -DskipTests'
				
			}	
				  }
		}
		stage('Build Docker Image'){
			steps{
        		bat 'docker build -t omarkorbi/crud-application:latest .'
        		}
    }
    stage('Push Docker Image'){
     	steps{
	        bat 'docker login -u omarkorbi -p gotktpas123'
	  		bat 'docker tag crud-application:latest omarkorbi/crud-application '
	  		bat 'docker push omarkorbi/crud-application'
	  		}
    }
     stage('Run Kubernetes'){
    	steps{
    		
    		bat 'kubectl --kubeconfig ./config apply -f k8s/mongo-config.yaml'
    		bat 'kubectl --kubeconfig ./config apply -f k8s/mongo-secret.yaml'
    		bat 'kubectl --kubeconfig ./config apply -f k8s/mongo-deployment.yaml'
   	   		bat 'kubectl --kubeconfig ./config apply -f k8s/dep.yaml'
   	   		}
    }
     
    
		
	}
}