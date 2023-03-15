package com.github.gradle.template.api.config;

import com.github.gradle.template.api.controllers.HealthController;
import com.github.gradle.template.services.health.Check;
import com.github.gradle.template.services.health.EnvironmentCheck;
import com.github.gradle.template.services.health.HealthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HealthConfig {

  @Bean
  List<Check> healthChecks() {
    return List.of(new EnvironmentCheck(List.of("USER")));
  }

  @Bean
  HealthService healthService() {
    return new HealthService(healthChecks());
  }


  @Bean
  HealthController healthController() {
    return new HealthController(healthService());
  }
}
