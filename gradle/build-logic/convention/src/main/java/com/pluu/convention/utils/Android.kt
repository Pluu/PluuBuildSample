package com.pluu.convention.utils

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.pluu.Const.ByteCodeJavaVersion
import org.gradle.api.Project

internal fun Project.configureAndroid(commonExtension: CommonExtension) {
    with(commonExtension) {
        compileSdk {
            version = release(37)
        }

        defaultConfig.apply {
            minSdk = 26

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        buildTypes.apply {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        compileOptions.apply {
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