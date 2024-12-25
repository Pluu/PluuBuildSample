package com.pluu.convention.utils

import org.gradle.api.Project

internal fun Project.configureFlavor(commonExtension: AGPCommonExtension) {
    commonExtension.apply {
        flavorDimensions.add("default")

        productFlavors {
            maybeCreate("develop")
            maybeCreate("develop_side").matchingFallbacks.add("develop")
            maybeCreate("production").matchingFallbacks.add("develop")
        }
    }
}