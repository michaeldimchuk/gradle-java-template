plugins {
    id("com.github.gradle.template.java-conventions")
    id("io.freefair.lombok")
    jacoco
}

dependencies {
    implementation(project(":services"))
    implementation(project(":models"))
    implementation(springLibs.boot.starter.web)
    implementation(springLibs.inject)

    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
    testImplementation(springLibs.boot.starter.test)
}

description = "api"
