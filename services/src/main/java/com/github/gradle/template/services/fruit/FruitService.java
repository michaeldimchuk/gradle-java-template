package com.github.gradle.template.services.fruit;

import com.github.gradle.template.models.rest.Fruit;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class FruitService {

  StoreSettings storeSettings;

  public List<Fruit> getCatalog() {
    log.info("Retrieving a list of fruit");
    return List.of(
        new Fruit(storeSettings.name(), storeSettings.currency(), "Apple", new BigDecimal("0.99"), 42),
        new Fruit(storeSettings.name(), storeSettings.currency(), "Orange", new BigDecimal("0.45"), 55),
        new Fruit(storeSettings.name(), storeSettings.currency(), "Apricot", new BigDecimal("0.66"), 12)
    );
  }
}
