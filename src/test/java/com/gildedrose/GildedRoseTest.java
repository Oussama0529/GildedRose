package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }

 @Test
  @DisplayName("Test any product after one day quality degrade")
  void afterOneDayQualityDegrade() {
    Item element = new Item("ANY10", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(9, element.quality, "quality should be 9");
  }


}
