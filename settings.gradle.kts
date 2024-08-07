
rootProject.name = "kotlintraining"

pluginManagement {
    repositories {
        maven(url = "https://nexus.nrtn.dev/repository/maven-public")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        maven(url = "https://nexus.nrtn.dev/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
