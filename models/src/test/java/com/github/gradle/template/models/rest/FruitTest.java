package com.github.gradle.template.models.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class FruitTest {

  ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void serializationTest() throws Exception {
    final var stream = getClass().getClassLoader().getResourceAsStream("fruit.json");
    assertThat(stream).isNotNull();

    final var fruit = objectMapper.readValue(stream, Fruit.class);
    assertThat(fruit).isNotNull();
    assertThat(fruit.name()).isEqualTo("Apple");
    assertThat(fruit.price()).isEqualTo(new BigDecimal("24.33"));
    assertThat(fruit.count()).isEqualTo(103);
  }
}
