// vars/dockerBuild.groovy
def login(String credentialsId = 'docker-secret') {
    withCredentials([string(credentialsId: credentialsId, variable: 'DOCKER_TOKEN')]) {
        // For Docker Hub or similar registries
        sh "echo $DOCKER_TOKEN | docker login -u singhraju --password-stdin"
    }
}

def build(String imageName, String context = '.') {
    sh "docker build -t ${imageName} ${context}"
}

def push(String imageName) {
    sh "docker push ${imageName}"
}
