// Define methods for Docker-related tasks

def login(String credentialsId = '391e5063-438b-4b7b-b98a-e46b7211ea3e') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
    }
}

def build(String imageName, String context) {
    sh "docker build -t ${imageName} ${context}"
}

def push(String imageName) {
    sh "docker push ${imageName}"
}
