#!/bin/bash

set -e
set -o pipefail

cd /Users/kynan/.jenkins/workspace/AndroidBuildTest/Drinkable_app
./gradlew assembleAndroidTest
./gradlew testDebugUnitTest

