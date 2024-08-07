
var mockkVersion = findProperty("mockkVersion")!!

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "2.0.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:${mockkVersion}")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}