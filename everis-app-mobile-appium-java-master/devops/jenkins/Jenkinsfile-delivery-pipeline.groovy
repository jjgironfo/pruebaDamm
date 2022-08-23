pipeline {
    // agent {label 'jkagentwin01'} //nombre de servidor
    agent any
    tools {
        maven 'maven'
        jdk 'JAVA'
    }
    stages {
        stage('Preparation') {
            steps {
                println('*** CHECK OUT CODE FROM GIT REPO ***')
                checkout scm
                println('*** CHECK OUT CODE FROM GIT REPO COMPLETED ***')
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    try {
                        println('*** TRIGGER BUILD & TEST ***')
                        println('Ejecutando comand mvn')
                        sh "mvn clean verify -Denvironment=${params.AMBIENTE} -Dcucumber.filter.tags=\"${params.TAGS}\""
                        //bat "mvn clean verify -Denvironment=${params.AMBIENTE} -Dcucumber.filter.tags=\"${params.TAGS}\""

                    } finally {
                        step([
                                $class               : 'CucumberReportPublisher',
                                failedFeaturesNumber : 0,
                                failedScenariosNumber: 0,
                                failedStepsNumber    : 0,
                                fileExcludePattern   : '',
                                fileIncludePattern   : '**/*cucumber.json',
                                //jsonReportDirectory  : "${env.WORKSPACE}/build",
                                jsonReportDirectory  : "target/build",
                                parallelTesting      : true,
                                pendingStepsNumber   : 0,
                                skippedStepsNumber   : 0,
                                trendsLimit          : 0,
                                undefinedStepsNumber : 0
                        ])
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                echo 'One way or another, I have finished'
                deleteDir()
            }
        }
        success {
            echo 'I succeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
    }
}