#!/bin/bash

set -e
set -o pipefail

cd /Users/kynan/.jenkins/workspace/AndroidBuildTest/Drinkable_app
export JAVA_HOME=`/usr/libexec/java_home`
export ANDROID_HOME=/Users/kynan/Library/Android/sdk
./gradlew assembleAndroidTest
./gradlew testDebugUnitTest
./gradlew assembleDebug