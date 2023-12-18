# gradle-java-template

A template for a Gradle Java project with multiple modules, lombok and coverage checks.

Swagger docs are automatically generated and available at the `/q/swagger-ui` endpoint.

Health endpoints are available at `/q/health/live` and `/q/health/ready`.

With the help of `lombok.config`, all non-static fields are `private final` by default.
