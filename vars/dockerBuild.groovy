// vars/dockerBuild.groovy
def login(String credentialsId = 'docker-credentials') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh 'docker login -u singhraju -p $DOCKER_PASS'
    }
}

def build(String imageName, String context = '.') {
    sh "docker build -t ${imageName} ${context}"
}

def push(String imageName) {
    sh "docker push ${imageName}"
}
