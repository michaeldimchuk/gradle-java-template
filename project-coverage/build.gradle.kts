plugins {
    id("com.github.gradle.template.java-conventions")
    id("jacoco-report-aggregation")
    jacoco
}

// These should include all modules defined within this project, coverage
// will only be gathered and merged on projects listed here.
dependencies {
    jacocoAggregation(project(":api"))
    jacocoAggregation(project(":services"))
    jacocoAggregation(project(":models"))
}

description = "project-coverage"
