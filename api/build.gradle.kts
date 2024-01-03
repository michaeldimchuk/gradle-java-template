plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
    id("io.quarkus")
    jacoco
}

val quarkusVersion = "3.4.3"


dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:${quarkusVersion}"))
    implementation(project(":services"))
    implementation(project(":models"))

    implementation("io.quarkus", "quarkus-resteasy-reactive")
    implementation("io.quarkus", "quarkus-reactive-routes")
    implementation("io.quarkus", "quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus", "quarkus-arc")
    implementation("io.quarkus", "quarkus-smallrye-openapi")
    implementation("io.quarkus", "quarkus-smallrye-health")
    implementation("io.quarkus", "quarkus-config-yaml")
    implementation("io.smallrye.config", "smallrye-config-core")
    implementation("io.smallrye.config", "smallrye-config-crypto")
    implementation(jakartaLibs.inject)

    testImplementation("io.quarkus", "quarkus-junit5")
    testImplementation("io.rest-assured", "rest-assured")
    testImplementation(testLibs.junit.launcher)
    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
    testImplementation(testLibs.mockito)
}

description = "api"
