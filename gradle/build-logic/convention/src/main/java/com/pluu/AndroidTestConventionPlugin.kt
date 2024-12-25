package com.pluu

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.pluu.convention.utils.disableUnnecessaryAndroidTests
import com.pluu.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import java.io.File

@Suppress("unused")
class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }

            // Case 1.
            extensions.getByType(CommonExtension::class.java).apply {
                sourceSets {
                    getByName("debug") {
                        assets.srcDirs(
                            File(rootDir, "testing/assets")
                        )
                    }
                }
            }

            extensions.findByType(LibraryAndroidComponentsExtension::class.java)?.let {
                with(it) {
                    disableUnnecessaryAndroidTests(target)
                }
            }

            dependencies {
                // Case 2. 모듈 기준
//                "debugImplementation"(project(":testing:assets_manual"))

                "testImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-arch-core").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-rules").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-core").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-runner").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-ext-junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-espresso").get())
                "androidTestImplementation"(libs.findLibrary("androidx-test-espresso-web").get())
            }
        }
    }
}