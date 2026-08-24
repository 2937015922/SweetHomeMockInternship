package com.eteks.sweethome3d.assignment;

import com.eteks.sweethome3d.model.Home;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/** A small test students can run before implementing any feature. */
class BuildSmokeTest {
  @Test
  void createsAHome() {
    assertNotNull(new Home());
  }
}
