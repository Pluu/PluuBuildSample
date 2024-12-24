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
            id = libs.plugins.pluu.android.application.get().pluginId
            implementationClass = "com.pluu.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.pluu.android.library.get().pluginId
            implementationClass = "com.pluu.AndroidLibraryConventionPlugin"
        }
        register("androidTest") {
            id = libs.plugins.pluu.android.test.get().pluginId
            implementationClass = "com.pluu.AndroidTestConventionPlugin"
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
