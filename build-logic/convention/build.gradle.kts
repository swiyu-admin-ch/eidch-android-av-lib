plugins {
    `kotlin-dsl`
}

group = "ch.admin.foitt.avwrapper.buildlogic"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = libs.plugins.avwrapper.android.library.get().pluginId
            implementationClass = "AndroidLibraryPlugin"
        }
        register("detektConventionPlugin") {
            id = libs.plugins.avwrapper.android.detekt.get().pluginId
            implementationClass = "DetektConventionPlugin"
        }
        register("lintConventionPlugin") {
            id = libs.plugins.avwrapper.android.lint.get().pluginId
            implementationClass = "LintConventionPlugin"
        }
        register("jacocoConventionPlugin") {
            id = libs.plugins.avwrapper.android.jacoco.get().pluginId
            implementationClass = "JacocoConventionPlugin"
        }
    }
}