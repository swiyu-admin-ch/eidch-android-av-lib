plugins {
    id("org.jetbrains.kotlin.android")
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    autoCorrect = false
    config.setFrom(rootProject.file("config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
    parallel = true
    basePath = rootDir.absolutePath
    source.setFrom(
        files(
            "src/main/",
        )
    )
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.8")
}
