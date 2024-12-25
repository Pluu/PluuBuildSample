package com.pluu

import com.android.build.api.dsl.LibraryExtension
import com.pluu.convention.utils.configureAndroid
import com.pluu.convention.utils.configureKotlin
import com.pluu.convention.utils.consumerProguardFiles
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureAndroid(this)
                configureKotlin()
                consumerProguardFiles()

                testOptions {
                    targetSdk = 35
                }
            }
        }
    }
}