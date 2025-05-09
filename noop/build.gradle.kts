plugins {
    id("android-sdk")
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "ch.admin.foitt.avwrapper"
version = "0.1.0"
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
            url = uri("https://maven.pkg.github.com/admin-ch-ssi/PERA_av-wrapper-public_android")
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
        url = "https://github.com/admin-ch-ssi/PERA_av-wrapper-public_android"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }

        scm {
            url = "https://github.com/admin-ch-ssi/PERA_av-wrapper-public_android"
        }
    }
}