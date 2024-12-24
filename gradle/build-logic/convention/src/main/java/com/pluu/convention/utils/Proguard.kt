package com.pluu.convention.utils

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.consumerProguardFiles() {
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}