package com.github.gradle.template.services.health;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HealthServiceTest {

  @Test
  void checkTest() {
    List<Check> passingChecks = List.of(new EnvironmentCheck(List.of("USER")));
    List<Check> failingChecks = List.of(new EnvironmentCheck(List.of("USER", "KEK")));
    assertThat(new HealthService(passingChecks).check()).isTrue();
    assertThat(new HealthService(failingChecks).check()).isFalse();
  }
}
