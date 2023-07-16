plugins {
    id("com.github.gradle.template.java-conventions")
    id("nebula.dependency-lock")
    id("io.freefair.lombok")
    id("org.springframework.boot")
    jacoco
}

dependencies {
    implementation(project(":services"))
    implementation(project(":models"))
    implementation(springLibs.boot.starter.web) {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation(springLibs.boot.starter.undertow)
    implementation(jakartaLibs.inject)
    implementation(springLibs.swagger.ui)
    implementation(springLibs.swagger.api)

    testImplementation(testLibs.junit.core)
    testImplementation(testLibs.assertj.core)
    testImplementation(springLibs.boot.starter.test)
}

description = "api"
