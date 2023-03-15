plugins {
    `java-library`
    `maven-publish`
    jacoco
}

repositories {
    mavenLocal()

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }

    /*
    This is optional, any private or secondary repositories should be added here.

    maven = {
        url = uri("https://gitlab.com/api/v4/packages/maven")
    }
    */
}

java.sourceCompatibility = JavaVersion.VERSION_17

// The group id that'll be used to publish packages to Maven. This setting will be
// shared by all projects importing this plugin.
group = "com.github.gradle.template"

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }

    /*
    This is optional, any private or secondary repositories to publish to can be added here.
    Below is an example of a Gitlab project being used as a package repository.

    repositories {
        maven {
            url = uri("https://gitlab.com/api/v4/projects/123456789/packages/maven")
            name = "GitLab"
            credentials(HttpHeaderCredentials::class) {
                name = "Job-Token"
                value = System.getenv("CI_JOB_TOKEN")
            }
            authentication {
                create("header", HttpHeaderAuthentication::class)
            }
        }
    }
    */
}

tasks.test {
    useJUnitPlatform()

    finalizedBy(tasks.jacocoTestReport)
}

// This tasks generates a test coverage report.
tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

// This tasks adds a minimum requirement of 100% test coverage on every project.
// Only enforced if at least one test case exists as otherwise Jacoco won't run.
tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.test)

    violationRules {
        rule {
            limit {
                // A string is used to set the reported precision of the coverage
                // report, two 0's after the dot results in two decimal places of
                // precision in the coverage report, a message like:
                // "instructions covered ratio is 0.86, but expected minimum is 1.00"
                minimum = "1.00".toBigDecimal();
            }
        }
    }
}
