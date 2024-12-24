plugins {
    alias(libs.plugins.pluu.android.library)
    alias(libs.plugins.pluu.android.test)
}

android {
    namespace = "com.pluu.test.core"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.goolge.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}