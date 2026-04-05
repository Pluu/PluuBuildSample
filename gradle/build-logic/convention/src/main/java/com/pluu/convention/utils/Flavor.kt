package com.pluu.convention.utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureFlavor(commonExtension: CommonExtension) {
    commonExtension.apply {
        flavorDimensions.add("default")

        productFlavors {
            maybeCreate("develop")
            maybeCreate("develop_side").matchingFallbacks.add("develop")
            maybeCreate("production").matchingFallbacks.add("develop")
        }
    }
}