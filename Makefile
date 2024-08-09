# Typically this should be set in shell settings, but committed here
# just to serve as an example.
export ENCRYPTION_KEY = RERuZTVvYm5mSDFSU2VUZzcxeFNaZw

# Compiles the code.
build:
	./gradlew build

# Compiles the code and pushes the artifacts to the local maven repository.
install:
	./gradlew build publishToMavenLocal

# Runs tests without any coverage checks.
test:
	./gradlew test

lock:
	./gradlew generateLock saveLock

# Runs tests, enforces the 100% coverage requirement and creates an aggregated
# coverage report across all projects in this repository, which can be seen
# under project-coverage/build/reports/jacoco/testCodeCoverageReport/html/index.html.
verify:
	./gradlew test jacocoTestCoverageVerification testCodeCoverageReport

run:
	./gradlew quarkusDev
