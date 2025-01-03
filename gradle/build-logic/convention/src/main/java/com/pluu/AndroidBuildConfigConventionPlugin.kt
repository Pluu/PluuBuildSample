package com.pluu

import com.android.build.api.dsl.LibraryExtension
import com.pluu.convention.utils.configureFlavor
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
open class AndroidBuildConfigStubConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("pluu.android.library")
            }
        }
    }
}

@Suppress("unused")
class AndroidBuildConfigConventionPlugin : AndroidBuildConfigStubConventionPlugin() {
    override fun apply(target: Project) {
        super.apply(target)
        with(target) {
            extensions.configure<LibraryExtension> {
                sourceSets {
                    getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
                }
                configureFlavor(this)
            }
        }
    }
}

