pipeline {
    agent any

    parameters {
        choice(name: 'ENV', choices: ['test', 'uat', 'staging'], description: 'Choose environment')
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Choose browser')
        choice(name: 'SUITE', choices: ['sanity', 'regression'], description: 'Choose TestNG suite XML')
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'git@github.com:suchita5297/TestSelenium.git', branch: 'main'
            }
        }

        stage('Run Tests') {
            steps {
                sh """
                    mvn clean test \
                    -P${params.ENV} \
                    -Dbrowser=${params.BROWSER} \
                    -DsuiteXmlFile=testng/${params.SUITE}.xml
                """
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
} 