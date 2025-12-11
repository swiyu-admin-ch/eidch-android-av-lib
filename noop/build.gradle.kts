plugins {
    id("android-sdk")
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "ch.admin.foitt.avwrapper"
version = "0.5.0"
val packageName = "AvWrapper"

android {
    namespace = "ch.admin.foitt.avwrapper"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

mavenPublishing {
    coordinates(
        group.toString(),
        packageName.lowercase(),
        version.toString()
    )

    pom {
        name = "AvWrapper no-op"
        description = "This project contains a library required for building the swiyu Android wallet. It is a no-op implementation of the library used during the e-ID request flow."
        inceptionYear = "2025"
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
                url = "https://github.com/swiyu-admin-ch"
            }
        }
        scm {
            url = "https://github.com/swiyu-admin-ch/eidch-android-av-lib"
            connection = "scm:git:git://github.com/swiyu-admin-ch/eidch-android-av-lib.git"
            developerConnection = "scm:git:ssh://git@github.com/swiyu-admin-ch/eidch-android-av-lib.git.git"
        }
    }
}
