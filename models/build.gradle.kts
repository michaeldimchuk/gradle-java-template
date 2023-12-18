plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
    jacoco
}

dependencies {
    implementation(quarkusLibs.openapi)

    testImplementation(testLibs.junit.launcher)
    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
    testImplementation(jacksonLibs.databind)
    testImplementation(jacksonLibs.annotations)
}

description = "models"
