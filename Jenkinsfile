pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("building jar ") {
            steps { 
                script {
                    echo "building jar"
                    sh 'mvn package'
                }
            }
        }
        stage("building image ") {
            steps { 
                script {
                     echo "building the image"
                     withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t lucky983/demo-app:jma-2.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push lucky983/demo-app:jma-2.0'
                   
                    }               
                }
            }
        }
        stage("Deploying image ") {
            steps { 
                script {
                    echo "Deploying"
                }
            }
        }
    }
}


        
