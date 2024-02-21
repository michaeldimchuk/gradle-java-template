plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
}

dependencies {
    implementation(testLibs.jmh.core)
    annotationProcessor(testLibs.jmh.processor)
}

description = "benchmarks"
