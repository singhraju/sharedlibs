def login(String credentialsId = 'docker-secret') {
    withCredentials([string(credentialsId: credentialsId, variable: 'DOCKER_TOKEN')]) {
        bat "echo %DOCKER_TOKEN% | docker login -u singhraju --password-stdin"
    }
}

def build(String imageName, String context = '.') {
    bat "docker build -t ${imageName} ${context}"
}

def push(String imageName) {
    bat "docker push ${imageName}"
}
