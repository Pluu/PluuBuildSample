package com.pluu

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }
        }
    }
}