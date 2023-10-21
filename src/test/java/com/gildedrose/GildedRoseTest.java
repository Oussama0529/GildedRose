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
  @DisplayName("Test tooString")
  void test_toString() {
    Item element = new Item("foo", 0, 0);    String tmp = element.toString();
    assertEquals(element.name + ", " + element.sellIn + ", " + element.quality, tmp, "the outputis not correct  ");
  }

 @Test
  @DisplayName("Test any product after one day quality degrade")
  void afterOneDayQualityDegrade() {
    Item element = new Item("ANY1", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(9, element.quality, "quality should be 9");
  }
  @Test
  @DisplayName("Test any product after one day sellin decrease")
  void afterOneDaySellinDecrease() {
    Item element = new Item("ANY2", 5, 10);
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
    Item element = new Item("ANY3", 5, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertTrue(element.quality <= 50,"Quality will never exceed 50");
  }

  @Test
  @DisplayName("After one day quality will never be less than ZERO")
  void afterOneDaySellinQualityNeverBeLessThanZERO() {
    Item element = new Item("ANY4", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(element.quality,0,"Quality should never be less than ZERO");
  }

  @Test
  @DisplayName(" The Quility of Sulfuras never change")
  void theQuilityOfSulfurasNeverChange() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -10, 80);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality,80,"The Quility of Sulfuras shouldn't change");
  }

  @Test
  @DisplayName("Quility of Backstage Passes to a TAFKAL80ETC concert Increase with 2 after sellin equal ten days")
  void quilityOfBackstagePassesIncreaseWithTwoAfterTenDays() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality,32);
  }

  @Test
  @DisplayName("Quility Of Backstage Passes Equal Increase With 3 After Sellin Equal Fives Days")
  void quilityOfBackstagePassesEqualIncreaseWithThreeAfterFivesDays() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
  assertEquals(element.quality,33);
  }

  @Test
  @DisplayName("Quility Of Backstage Passes Equal don't Increase With 3 After Sellin Equal Fives Days")
  void quilityOfBackstagePassesEqualDontIncreaseWithThreeAfterFivesDays() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert",7, 30);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
  assertEquals(element.quality, 32);

  }
  @Test
  @DisplayName("Once the expiration date has passed, the quality degrades twice as fast. ")
  void QualityDecreaseTwiceAfterExpiration() {
    Item element = new Item("ANY5", 0, 40);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality,38);
  }

  @Test
  @DisplayName("Once the expiration date has passed for Backstage the quality equal zero ")
  void qualityOfBackstageAfterLastDayEqualZero() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality,0);
  }

  @Test
  @DisplayName("Once the expiration date has passed for Aged Brie the quality increase by two")
  void onceExpirationDateHasPassedForAgedBrieQualityIncreaseByTwo() {
    Item element = new Item("Aged Brie", -5, 30);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality, 32);
    assertEquals(element.sellIn, -6);
  }
  @Test
  @DisplayName("in any case quality of Aged Brie will never be more than 50  ")
  void AgedBrieNeverBeMoreThanFifty() {
    Item element = new Item("Aged Brie", -5, 50);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality, 50);
    assertEquals(element.sellIn, -6);
  }

  @Test
  @DisplayName("in any case quality Sulfuras will never change, equals 80")
  void qualitySulfurasHandOfRagnaros() {
    Item element = new Item("Sulfuras, Hand of Ragnaros",7, 80);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality, 80);
  }
  @Test
  @DisplayName("Backstage passes to a TAFKAL80ETC concert increase by one ")
  void qualityBackstagepassestoaTAFKAL80ETCconcertIncreaseByOne() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality, 41);
  }

  @Test
  @DisplayName("Backstage passes to a TAFKAL80ETC concert IFQualityUnder50")
  void qualityBackstagepassestoaTAFKAL80ETCconcertIFQualityUnder0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element}); 
    app.updateQuality();
    assertEquals(element.quality, 50);
  }


  @Test 
  @DisplayName("Conjured sellin MORE THEN ZERO quality test")
  void ConjuredMORETHENZEROqualitytest() {
    Item element = new Item("Conjured Mana Cake", 10, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(22, element.quality);

  }

  @Test 
  @DisplayName("Conjured sellin LESS THEN ZERO quality test")
  void ConjuredLESSTHENZEROqualitytest() {
    Item element = new Item("Conjured Mana Cake", -10, 30);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(26, element.quality);

  }

  @Test 
  @DisplayName("Conjured sellin decrease ")
  void ConjuredSellinDecrease() {
    Item element = new Item("Conjured Mana Cake", 23, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(22, element.sellIn, "expected quality to be 4");

  }
} 
