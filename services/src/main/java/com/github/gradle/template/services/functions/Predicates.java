package com.github.gradle.template.services.functions;

import lombok.experimental.UtilityClass;

import java.util.function.Predicate;

@UtilityClass
public class Predicates {

  public static <T> Predicate<T> or(Predicate<T> first, Predicate<T> second) {
    return first.or(second);
  }
}
