# Compiles the code.
build:
	./gradlew build

# Compiles the code and pushes the artifacts to the local maven repository.
install:
	./gradlew build publishToMavenLocal

# Runs tests without any coverage checks.
test:
	./gradlew test

# Runs tests, enforces the 100% coverage requirement and creates an aggregated
# coverage report across all projects in this repository, which can be seen
# under project-coverage/build/reports/jacoco/testCodeCoverageReport/html/index.html.
verify:
	./gradlew test jacocoTestCoverageVerification testCodeCoverageReport
