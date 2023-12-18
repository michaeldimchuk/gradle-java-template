package com.github.gradle.template.services.fruit;

import com.github.gradle.template.models.rest.Fruit;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Singleton
public class FruitService {

  public List<Fruit> getCatalog() {
    log.info("Retrieving a list of fruit");
    return List.of(
        new Fruit("Apple", new BigDecimal("0.99"), 42),
        new Fruit("Orange", new BigDecimal("0.45"), 55),
        new Fruit("Apricot", new BigDecimal("0.66"), 12)
    );
  }
}
