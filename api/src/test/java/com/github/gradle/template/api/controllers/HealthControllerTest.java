package com.github.gradle.template.api.controllers;

import com.github.gradle.template.models.rest.HealthStatus;
import com.github.gradle.template.services.health.EnvironmentCheck;
import com.github.gradle.template.services.health.HealthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HealthControllerTest {
  private static Stream<Scenario> getCheckHealthScenarios() {
    return Stream.of(
        new Scenario("USER", HealthStatus.OK),
        new Scenario("KEK", HealthStatus.FAILED)
    );
  }

  @ParameterizedTest
  @MethodSource("getCheckHealthScenarios")
  void checkHealthTest(Scenario scenario) {
    var healthService = new HealthService(List.of(new EnvironmentCheck(List.of(scenario.environmentVariable()))));
    var controller = new HealthController(healthService);
    assertThat(controller.checkHealth().getStatus()).isEqualTo(scenario.expectedStatus());
  }

  private record Scenario(String environmentVariable, HealthStatus expectedStatus) {}
}
