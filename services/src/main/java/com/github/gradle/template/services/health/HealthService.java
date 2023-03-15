package com.github.gradle.template.services.health;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class HealthService {

  List<Check> checks;

  public boolean check() {
    return checks.stream().allMatch(Check::passed);
  }
}
