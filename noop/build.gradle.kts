plugins {
    id("android-sdk")
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "ch.admin.foitt.avwrapper"
version = "0.3.0"
val packageName = "AvWrapper"

android {
    namespace = "ch.admin.foitt.avwrapper"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

publishing {
    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/swiyu-admin-ch/eidch-android-av-lib")
            credentials(PasswordCredentials::class) {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

mavenPublishing {
    coordinates(
        group.toString(),
        packageName.lowercase(),
        version.toString()
    )

    pom {
        name = "AvWrapper no-op"
        url = "https://github.com/swiyu-admin-ch/eidch-android-av-lib"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }

        scm {
            url = "https://github.com/swiyu-admin-ch/eidch-android-av-lib"
        }
    }
}
