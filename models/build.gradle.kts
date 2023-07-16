plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
    jacoco
}

dependencies {
    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
}

description = "api"
