rootProject.name = "gradle-java-template"

include(":api")
include(":services")
include(":models")
include(":benchmarks")
include(":project-coverage")

pluginManagement {
    plugins {
        id("nebula.dependency-lock") version "12.7.1"
        id("io.freefair.lombok") version "8.7.1"
        id("io.quarkus") version "3.8.2"
    }
}

// All catalogs have to end with a "Libs" suffix, a requirement of Gradle 8.
// https://docs.gradle.org/8.0.2/userguide/platforms.html#sec:multiple
dependencyResolutionManagement {
    versionCatalogs {
        create("quarkusLibs") {
            version("openapi", "3.1")

            library("openapi", "org.eclipse.microprofile.openapi", "microprofile-openapi-api")
                .versionRef("openapi")
        }

        create("jakartaLibs") {
            version("inject", "2.0.1")

            library("inject", "jakarta.inject", "jakarta.inject-api")
                .versionRef("inject")
        }

        create("jacksonLibs") {
            version("jackson", "2.16.1")

            library("core", "com.fasterxml.jackson.core", "jackson-core").versionRef("jackson")
            library("databind", "com.fasterxml.jackson.core", "jackson-databind").versionRef("jackson")
            library("annotations", "com.fasterxml.jackson.core", "jackson-annotations").versionRef("jackson")
        }

        create("testLibs") {
            version("junit", "5.10.1")
            version("junit-launcher", "1.10.0")
            version("assertj", "3.24.2")
            version("mockito", "5.8.0")
            version("jmh", "1.37")

            library("jmh-core", "org.openjdk.jmh", "jmh-core").versionRef("jmh")
            library("jmh-processor", "org.openjdk.jmh", "jmh-generator-annprocess").versionRef("jmh")

            library("junit-launcher", "org.junit.platform", "junit-platform-launcher").versionRef("junit-launcher")
            library("junit-core", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("assertj-core", "org.assertj", "assertj-core").versionRef("assertj")
            library("mockito", "org.mockito", "mockito-core").versionRef("mockito")
        }

        create("loggingLibs") {
            version("slf4j", "2.0.6")
            version("jboss", "3.0.4.Final")
            version("jboss-slf4j", "2.0.0.Final")

            library("slf4j-api", "org.slf4j", "slf4j-api").versionRef("slf4j")
            library("jboss-slf4j", "org.jboss.slf4j", "slf4j-jboss-logmanager").versionRef("jboss-slf4j")
            library("jboss-logger", "org.jboss.logmanager", "jboss-logmanager").versionRef("jboss")
        }
    }
}
