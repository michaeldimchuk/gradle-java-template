plugins {
    id("com.github.gradle.template.java-conventions")
    id("io.freefair.lombok")
    jacoco
}

dependencies {
    implementation(springLibs.inject)

    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
}

description = "api"
