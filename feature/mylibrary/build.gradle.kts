plugins {
    alias(libs.plugins.pluu.android.library)
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}