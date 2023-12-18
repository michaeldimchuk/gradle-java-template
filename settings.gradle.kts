rootProject.name = "gradle-java-template"

include(":api")
include(":services")
include(":models")
include(":project-coverage")

pluginManagement {
    plugins {
        id("nebula.dependency-lock") version "12.7.1"
        id("io.freefair.lombok") version "8.4"
        id("org.springframework.boot") version "3.1.1"
    }
}

// All catalogs have to end with a "Libs" suffix, a requirement of Gradle 8.
// https://docs.gradle.org/8.0.2/userguide/platforms.html#sec:multiple
dependencyResolutionManagement {
    versionCatalogs {
        create("springLibs") {
            version("boot", "3.0.4")
            version("swagger", "2.0.4")

            library("boot-starter-web", "org.springframework.boot", "spring-boot-starter-web")
                .versionRef("boot")
            library("boot-starter-undertow", "org.springframework.boot", "spring-boot-starter-undertow")
                .versionRef("boot")
            library("boot-starter-test", "org.springframework.boot", "spring-boot-starter-test")
                .versionRef("boot")

            library("swagger-ui", "org.springdoc", "springdoc-openapi-starter-webmvc-ui")
                .versionRef("swagger")
            library("swagger-api", "org.springdoc", "springdoc-openapi-starter-webmvc-api")
                .versionRef("swagger")
        }

        create("jakartaLibs") {
            version("inject", "2.0.1")

            library("inject", "jakarta.inject", "jakarta.inject-api")
                .versionRef("inject")
        }

        create("swaggerLibs") {
            version("swagger-core", "2.2.8")

            library("annotations", "io.swagger.core.v3", "swagger-annotations-jakarta")
                .versionRef("swagger-core")
        }

        create("testLibs") {
            version("junit", "5.9.2")
            version("assertj", "3.23.1")

            library("junit-core", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("assertj-core", "org.assertj", "assertj-core").versionRef("assertj")
        }
    }
}
