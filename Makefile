build:
    # Compiles the code.
	./gradlew build

install:
    # Compiles the code and pushes the artifacts to the local maven repository.
	./gradlew build publishToMavenLocal

test:
    # Runs tests without any coverage checks.
	./gradlew test

verify:
    # Runs tests, enforces the 100% coverage requirement and creates an aggregated
    # coverage report across all projects in this repository, which can be seen
    # under project-coverage/build/reports/jacoco/testCodeCoverageReport/html/index.html.
	./gradlew test jacocoTestCoverageVerification testCodeCoverageReport
