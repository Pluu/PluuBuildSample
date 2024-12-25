package com.pluu

import com.pluu.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }

            dependencies {
                "testImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-arch-core").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-rules").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-runner").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-ext-junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-espresso").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-espresso-web").get())
            }
        }
    }
}