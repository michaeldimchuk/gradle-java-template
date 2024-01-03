package com.github.gradle.template.api.controllers;

import com.github.gradle.template.models.rest.Fruit;
import com.github.gradle.template.services.fruit.FruitService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FruitControllerTest {

  FruitService fruitService = mock(FruitService.class);

  FruitController fruitController = new FruitController(fruitService);

  @Test
  void getCatalogTest() {
    final var fruit = List.of(new Fruit("Cool store", "CAD", "Apple", BigDecimal.ONE, 42));
    when(fruitService.getCatalog()).thenReturn(fruit);

    assertThat(fruitController.getCatalog()).isEqualTo(fruit);
  }
}
