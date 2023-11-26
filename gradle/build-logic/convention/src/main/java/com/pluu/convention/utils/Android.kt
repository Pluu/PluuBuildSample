package com.pluu.convention.utils

import com.pluu.ByteCodeJavaVersion
import org.gradle.api.Project

internal fun Project.configureAndroid(commonExtension: AGPCommonExtension) {
    commonExtension.apply {
        compileSdk = 34

        defaultConfig {
            minSdk = 24

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = ByteCodeJavaVersion
            targetCompatibility = ByteCodeJavaVersion
        }
    }
}