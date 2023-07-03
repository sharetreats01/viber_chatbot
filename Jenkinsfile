pipeline {
    agent any

    environment {
        registryUrl = 'dlwlgh9412'
        imageName = 'viber_chatbot'
        version = '0.1'
        credentialsId = 'dockerhub-id'
    }
    stages {
        stage("build jar") {
            steps {
                // 프로젝트 빌드
                sh './gradlew -Pprofile=dev build '
            }
        }

        stage ('build docker image') {
            steps {
                script {
                    dockerImage = docker.build("${registryUrl}/${imageName}:${version}", "--build-arg TARGET=${imageName}-${version} .")
                }
            }
        }

        stage ('tag docker image && push') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', credentialsId) {
                        docker.image("${registryUrl}/${imageName}:${version}").push()
                    }
                }
            }
        }

        stage('docker login') {
            steps {
                withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sshPublisher(publishers: [
                        sshPublisherDesc(configName: 'ubuntu-server', transfers: [
                            sshTransfer(cleanRemote: false, excludes: '', execCommand: "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '')
                        ])
                    ])
                }
            }
        }

        stage('docker pull') {
            steps {
                withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sshPublisher(publishers: [
                        sshPublisherDesc(configName: 'ubuntu-server', transfers: [
                            sshTransfer(cleanRemote: false, excludes: '', execCommand: "docker pull $registryUrl/$imageName:$version", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '')
                        ])
                    ])
                }
            }
        }

        stage('deploy') {
            steps {
                sshPublisher(publishers: [
                    sshPublisherDesc(configName: 'ubuntu-server', transfers: [
                        sshTransfer(cleanRemote: false, excludes: '', execCommand: "cd /home/ubuntu/viber_chatbot && sh dev.sh ${imageName} ${version}", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '')
                    ])
                ])
            }
        }
    }
}