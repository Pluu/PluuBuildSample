package com.pluu

import com.android.build.api.dsl.ApplicationExtension
import com.pluu.convention.utils.configureAndroid
import com.pluu.convention.utils.configureFlavor
import com.pluu.convention.utils.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroid(this)
                defaultConfig.targetSdk = 35
                configureKotlin()
                configureFlavor(this)
            }
        }
    }
}