plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
    id("io.quarkus")
    jacoco
}

val quarkusVersion = "3.4.1"

dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:${quarkusVersion}"))
    implementation("io.quarkus", "quarkus-core")
    implementation("io.smallrye.config", "smallrye-config-core")
    implementation(project(":models"))
    implementation(jakartaLibs.inject)


    implementation(loggingLibs.slf4j.api)
    runtimeOnly(loggingLibs.jboss.slf4j)
    runtimeOnly(loggingLibs.jboss.logger)

    testImplementation("io.quarkus", "quarkus-junit5")
    testImplementation("io.quarkus", "quarkus-arc")
    testImplementation("io.quarkus", "quarkus-config-yaml")
    testImplementation(testLibs.junit.launcher)
    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
}

description = "api"
