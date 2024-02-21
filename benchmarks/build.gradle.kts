plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
}

dependencies {
    implementation(testLibs.jmh.core)
    annotationProcessor(testLibs.jmh.processor)

    testImplementation(testLibs.junit.launcher)
    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
    testImplementation(jacksonLibs.databind)
    testImplementation(jacksonLibs.annotations)
}

description = "benchmarks"
