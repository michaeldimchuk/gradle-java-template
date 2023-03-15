package com.github.gradle.template.api.application;

import org.junit.jupiter.api.Test;

class StartupTest {
  @Test
  void mainTest() {
    // This is here to please the coverage gods and ensure that the server can
    // launch successfully, typically not necessary.
    TemplateApplication.main(new String[] {});
  }
}
