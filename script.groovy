def buildJar() {
    echo "Building The application"
    sh 'mvn package'
}

def buildImage() {
    echo "Building The docker Image"
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t lucky983/mvn-app:1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push lucky983/mvn-app:1'
    }
}

def deployApp() {
    echo "Deploying the App"
}

return this
