package com.github.gradle.template.services.health;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EnvironmentCheckTest {

  @Test
  void passedTest() {
    assertThat(new EnvironmentCheck(List.of("USER")).passed()).isTrue();
    assertThat(new EnvironmentCheck(List.of("KEK")).passed()).isFalse();
  }
}
