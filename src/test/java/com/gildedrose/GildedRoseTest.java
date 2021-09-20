package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }


  // Test for the Brie

  @Test 
  @DisplayName("Test of the Brie quality update per day")
  void testBrieQuality() {
    Item element = new Item("Aged Brie", 20, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(5));
  }

  @Test 
  @DisplayName("Test of the Max Brie quality (50)")
  void testBrieQualityMax() {
    Item element = new Item("Aged Brie", 10, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }


  //Test for the concert

  @Test 
  @DisplayName("Test of the concert quality per day > 10")
  void testConcertQuality() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
  }

  @Test 
  @DisplayName("Test of the concert quality per day < 10 but > 5")
  void testConcertQualityUnder10() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(7));
  }

  @Test 
  @DisplayName("Test of the concert quality per day < 5")
  void testConcertQualityUnder5() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(8));
  }

  @Test 
  @DisplayName("Test of the concert quality when the concert's done")
  void testConcertQualityFinished() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test 
  @DisplayName("Test of the max concert quality (50)")
  void testConcertQualityMax() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  // Test for Sulfura

  @Test 
  @DisplayName("Test of Sulfura's quality per day")
  void testSulfuraQuality() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(80));
  }

  // There isn't any code defining the maximum for Sulfura's quality but the text says 80, this cannot be verified
  @Test 
  @DisplayName("Test of Sulfura's quality max")
  void testSulfuraQualityMax() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(80));
  }


  // Other items

  @Test 
  @DisplayName("Test of a random item's quality per day")
  void testItemQuality() {
    Item element = new Item("+5 Dexterity Vest", 10, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(19));
  }
}
