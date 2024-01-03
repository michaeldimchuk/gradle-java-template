package com.github.gradle.template.services.fruit;


import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "template.store")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface StoreSettings {
  String name();

  String currency();
}
