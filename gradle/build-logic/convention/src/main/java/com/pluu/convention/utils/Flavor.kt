package com.pluu.convention.utils

import com.android.build.api.dsl.ApplicationProductFlavor
import org.gradle.api.Project

internal fun Project.configureFlavor(commonExtension: AGPCommonExtension) {
    commonExtension.apply {
        flavorDimensions.add("default")

        productFlavors {
            create("develop") {
                if (this is ApplicationProductFlavor) {
                    isDefault = true
                }
            }
            create("develop_side") {}
            create("production") {}
        }
    }
}