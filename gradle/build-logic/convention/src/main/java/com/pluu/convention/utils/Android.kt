package com.pluu.convention.utils

import com.android.build.api.variant.AndroidComponentsExtension
import com.pluu.Const.ByteCodeJavaVersion
import org.gradle.api.Project

internal fun Project.configureAndroid(commonExtension: AGPCommonExtension) {
    commonExtension.apply {
        compileSdk = 35

        defaultConfig {
            minSdk = 24

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        testOptions {
            animationsDisabled = true
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
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