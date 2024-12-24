plugins {
    alias(libs.plugins.pluu.android.application)
    alias(libs.plugins.pluu.android.test)
}

android {
    namespace = "com.pluu.buildsample"

    defaultConfig {
        applicationId = "com.pluu.buildsample"
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(projects.feature.mylibrary)
    implementation(projects.feature.anylibrary)
    implementation(projects.shared.buildConfig)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.goolge.material)
    implementation(libs.androidx.constraintlayout)
}