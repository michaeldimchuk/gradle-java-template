package com.github.gradle.template.services.fruit;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@RequiredArgsConstructor(onConstructor_ = @Inject)
class FruitServiceTest {

  FruitService fruitService;

  @Test
  void getCatalogTest() {
    final var fruit = fruitService.getCatalog();
    assertThat(fruit).hasSize(3);
  }
}
