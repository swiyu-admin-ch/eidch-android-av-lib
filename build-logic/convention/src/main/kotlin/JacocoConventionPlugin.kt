import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport
import project.convention.logic.version

private val coverageExcludes = setOf(
    "**/R.class",
    "**/R$*.class",
    "**/*\$ViewInjector*.*",
    "**/*\$ViewBinder*.*",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Factory*",
    "**/*_MembersInjector*",
    "**/*Module*",
    "**/*Component*",
    "**android**",
    "**/BR.class",
    // Hilt
    "**/dagger**/**",
    "**/hilt**/**",
)

class JacocoConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("jacoco")

            extensions.configure<JacocoPluginExtension> {
                toolVersion = version("jacoco")
            }

            afterEvaluate {
                val android = extensions.getByType(LibraryExtension::class.java)
                val buildTypes = android.buildTypes.map { type -> type.name }
                var productFlavors = android.productFlavors.map { flavor -> flavor.name }

                if (productFlavors.isEmpty()) {
                    productFlavors = productFlavors + ""
                }

                productFlavors.forEach { flavorName ->
                    buildTypes.forEach { buildTypeName ->

                        val sourceName: String = if (flavorName.isEmpty()) {
                            buildTypeName
                        } else {
                            "$flavorName${buildTypeName.replaceFirstChar(Char::titlecase)}"
                        }

                        val testTaskName = "test${sourceName.replaceFirstChar(Char::titlecase)}UnitTest"

                        registerCodeCoverageTask(
                            testTaskName = testTaskName,
                            sourceName = sourceName,
                            flavorName = flavorName,
                            buildTypeName = buildTypeName
                        )
                    }
                }
            }
        }
    }

    private fun Project.registerCodeCoverageTask(
        testTaskName: String,
        sourceName: String,
        flavorName: String,
        buildTypeName: String
    ) {
        tasks.register<JacocoReport>("${testTaskName}Coverage") {
            dependsOn(testTaskName)
            group = "Reporting"
            description = "Generate Jacoco coverage reports on the $sourceName build."

            val javaDirectories = fileTree(
                layout.buildDirectory.dir("intermediates/javac/$sourceName")
            ) { exclude(coverageExcludes) }

            val kotlinDirectories = fileTree(
                layout.buildDirectory.dir("tmp/kotlin-classes/$sourceName")
            ) { exclude(coverageExcludes) }

            val coverageSrcDirectories = listOf(
                "src/main/java",
                "src/$flavorName/java",
                "src/$buildTypeName/java",
                "src/main/kotlin",
                "src/$flavorName/kotlin",
                "src/$buildTypeName/kotlin"
            )

            classDirectories.setFrom(files(javaDirectories, kotlinDirectories))
            additionalClassDirs.setFrom(files(coverageSrcDirectories))
            sourceDirectories.setFrom(files(coverageSrcDirectories))
            executionData.setFrom(
                files(layout.buildDirectory.dir("jacoco/$testTaskName.exec"))
            )

            reports {
                xml.required.set(true)
                html.required.set(true)
            }
        }
    }
}