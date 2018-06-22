#!/usr/bin/env groovy
pipeline {
    agent {
        label 'androidTest'
    }
    // environment {
    //     PWC_SLACK_TOKEN = credentials('pwc-jenkins-slack')

    // }
    
    stages {
        stage('Tests') {
            steps {
                sh 'cd /Users/kynan/.jenkins/workspace/AndroidBuildTest/Drinkable_app'
                // sh 'export JAVA_HOME=`/usr/libexec/java_home`'
                // sh 'export ANDROID_HOME=/Users/kynan/Library/Android/sdk'
                sh 'sh androidBuild.sh'
                // sh 'cd /Users/kynan/.jenkins/workspace/AndroidBuildTest/Drinkable_app'
                // sh './gradlew assembleAndroidTest'
                // sh './gradlew testDebugUnitTest'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew assembleDebug'

            }
        }

        // stage('AdHoc'){
        //     steps {
        //         sh 'zip -rj PwcCompliance/build/PwcCompliance.app.dSYM.zip PwcCompliance/build/PwcCompliance.xcarchive/dSYMs/PwcCompliance.app.dSYM' 
        //         sh 'zip -r PwcCompliance/build/PwcCompliance.xcarchive.zip PwcCompliance/build/PwcCompliance.xcarchive'
        //     }
        // }

        // stage('Archive') {
        //     steps {
        //         archive 'PwcCompliance/build/PwcCompliance.app.dSYM.zip'
        //         archive 'PwcCompliance/build/PwcCompliance.xcarchive.zip'
        //         archive 'PwcCompliance/build/PwcCompliance.ipa'
        //     }

        // }

        // stage('Clean') {
        //     steps {
        //         cleanWs()
        //     }
        // }
    }

    // post {
    //     success {
    //         slackSend baseUrl: 'https://bemohq.slack.com/services/hooks/jenkins-ci/', channel: '#pwc', color: '#007F00', message: "Success ${env.JOB_NAME} ${env.BUILD_ID} (<${env.JENKINS_URL}/job/PwcCompliance/${env.BUILD_ID}|Open>)", tokenCredentialId: '$PWC_SLACK_TOKEN'
    //     }

    //     failure {
    //         slackSend baseUrl: 'https://bemohq.slack.com/services/hooks/jenkins-ci/', channel: '#pwc', color: '#E63247', message: "******:fire:FAILURE:fire:****** ${env.JOB_NAME} ${env.BUILD_ID} (<${env.JENKINS_URL}/job/PwcCompliance/${env.BUILD_ID}|Open>)", tokenCredentialId: '$PWC_SLACK_TOKEN'
    //     }
    // }
}


