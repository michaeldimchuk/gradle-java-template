package com.github.gradle.template.services.health;

import com.github.gradle.template.services.functions.Predicates;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class EnvironmentCheck implements Check {

  List<String> variables;

  @Override
  public boolean passed() {
    return variables.stream()
        .map(System::getenv)
        .noneMatch(Predicates.or(Objects::isNull, String::isEmpty));
  }
}
