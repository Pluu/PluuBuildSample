package com.pluu.convention.utils

import com.android.build.api.variant.AndroidComponentsExtension
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

    extensions.getByType(AndroidComponentsExtension::class.java).apply {
        beforeVariants(selector().all()) { variant ->
            when (variant.flavorName) {
                "" -> variant.enable = true
                "develop",
                "develop_side" -> variant.enable = variant.buildType == "debug"

                else -> variant.enable = variant.buildType == "release"
            }
        }
    }
}