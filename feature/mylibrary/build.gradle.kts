plugins {
    alias(libs.plugins.pluu.android.library)
    alias(libs.plugins.pluu.android.test)
}

android {
    namespace = "com.pluu.feature.mylibrary"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    compileOnly(projects.shared.buildConfigStub)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.goolge.material)
    implementation(libs.androidx.constraintlayout)
}