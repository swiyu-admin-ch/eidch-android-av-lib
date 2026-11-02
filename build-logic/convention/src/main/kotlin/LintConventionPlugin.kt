import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import project.convention.logic.property

class LintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.withId("com.android.library") {
                configureLint(target)
            }
        }
    }

    private fun configureLint(target: Project) {
        val androidExtension = target.extensions.getByType(CommonExtension::class.java)
        with(androidExtension.lint) {
            lintConfig = target.file("${target.rootDir}/config/lint/custom-lint.xml")
            quiet = false
            abortOnError = target.property("abortOnLintError", "true") == "true"

            // Warnings
            ignoreWarnings = false
            checkAllWarnings = true
            warningsAsErrors = false

            // If true, running lint on a module will also run it on all the
            // modules it depends on, so lint only has to be invoked once.
            checkDependencies = true

            // Report formats and output paths.
            absolutePaths = false
            xmlReport = true
            htmlReport = true
        }
    }
}