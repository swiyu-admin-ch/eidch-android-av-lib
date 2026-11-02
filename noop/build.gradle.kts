import com.vanniktech.maven.publish.DeploymentValidation

plugins {
    alias(libs.plugins.avwrapper.android.library)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "ch.admin.foitt.avwrapper"
val version = System.getenv("MAVEN_CENTRAL_version") ?: "0.6.1"
val packageName = "AvWrapper"

android {
    namespace = "ch.admin.foitt.avwrapper"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

mavenPublishing {
    publishToMavenCentral(automaticRelease = false, validateDeployment = DeploymentValidation.NONE)
    signAllPublications()

    coordinates(
        group.toString(),
        packageName.lowercase(),
        version.toString()
    )

    pom {
        name = "AvWrapper no-op"
        description = "No-op implementation of the e-ID auto-verification library used in the swiyu Android wallet."
        inceptionYear = "2026"
        url = "https://github.com/swiyu-admin-ch/eidch-android-av-lib"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }
        developers {
            developer {
                id = "swiyu-admin-ch"
                name = "swiyu - the Swiss Trust Infrastructure ecosystem"
                url = "https://github.com/swiyu-admin-ch/eidch-android-av-lib"
            }
        }
        scm {
            url = "https://github.com/swiyu-admin-ch/eidch-android-av-lib"
        }
    }
}
