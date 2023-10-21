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
  @Test
  @DisplayName("Test any product after one day sellin decrease")
  void afterOneDaySellinDecrease() {
    Item element = new Item("ANY1", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(element.sellIn, 4,"Sellin should be 4");
  }
  @Test
  @DisplayName("Test Aged Brie product after one day quality increase")
  void afterOneDayAgedBrieQualityIncrease() {
    Item element = new Item("Aged Brie", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(element.quality, 11,"Quality should be 11");
  }
  
  @Test
  @DisplayName("Test Backstage passes to a TAFKAL80ETC concert product after last day goes to zero")
  void afterLastDayBackstagePassesToaTAFKAL80ETCconcertGoesToZero() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality, 0, "quality goes to 0");
  }

  @Test
  @DisplayName("The quality of any product will never exceed 50")
  void theQualityOfAnyProductWillNeverExceedFifty() {
    Item element = new Item("ANY2", 5, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertTrue(element.quality <= 50,"Quality will never exceed 50");
  }
}
