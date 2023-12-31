plugins {
    `kotlin-dsl`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "pluu.android.application"
            implementationClass = "com.pluu.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "pluu.android.library"
            implementationClass = "com.pluu.AndroidLibraryConventionPlugin"
        }
        register("sharedBuildConfig") {
            id = "pluu.android.buildConfig"
            implementationClass = "com.pluu.AndroidBuildConfigConventionPlugin"
        }
        register("sharedBuildConfigStub") {
            id = "pluu.android.buildConfigStub"
            implementationClass = "com.pluu.AndroidBuildConfigStubConventionPlugin"
        }
    }
}
