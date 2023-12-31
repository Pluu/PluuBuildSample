package com.pluu

import com.android.build.api.dsl.LibraryExtension
import com.pluu.convention.utils.compileOnly
import com.pluu.convention.utils.configureAndroid
import com.pluu.convention.utils.configureKotlin
import com.pluu.convention.utils.project
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

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
            }

            dependencies {
                compileOnly(project(path =":shared:buildConfig-stub"))
            }
        }
    }
}