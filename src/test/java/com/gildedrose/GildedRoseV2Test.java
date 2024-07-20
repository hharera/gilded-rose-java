package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseV2Test {

    // Smoke Test
    @Test
    @DisplayName("Default Item: Decreases quality by 1 when sellIn is positive")
    void defaultItemDecreasesQualityByOneWhenSellInIsPositive() {
        // given, arrange
        String name = "Default Item";
        int quality = 2;
        Item item = new Item(name, 1, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality - 1, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Default Item: Does not change quality when quality is zero or negative")
    void defaultItemDoesNotChangeQualityWhenQualityIsZeroOrNegative() {
        // given, arrange
        String name = "Default Item";
        int quality = 0;
        Item item = new Item(name, 1, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Default Item: Decreases sellIn by 1")
    void defaultItemDecreasesSellInByOne() {
        // given, arrange
        String name = "Default Item";
        int quality = 2;
        int sellIn = 2;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(sellIn - 1, gildedRoseV2.items[0].sellIn);
    }

    // Smoke Test
    @Test
    @DisplayName("Default Item: Decreases quality by 2 (min 0) when sellIn is negative")
    void defaultItemDecreasesQualityByTwoWhenSellInIsNegative() {
        // given, arrange
        String name = "Default item";
        int quality = 1;
        int sellIn = -1;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(max(quality - 2, 0), gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Aged Brie: Does not increase quality past 50")
    void agedBrieDoesNotIncreaseQualityPastFifty() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 50;
        int sellIn = -1;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Aged Brie: Increases quality by 2 when sellIn is negative (max 50)")
    void agedBrieIncreasesQualityByTwoWhenSellInIsNegative() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 4;
        int sellIn = -1;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(min(quality + 2, 50), gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Aged Brie: Increases quality by 1 when sellIn is positive")
    void agedBrieIncreasesQualityByOneWhenSellInIsPositive() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 4;
        int sellIn = 40;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality + 1, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Aged Brie: Decreases sellIn by 1")
    void agedBrieDecreasesSellInByOne() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 4;
        int sellIn = 40;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(sellIn - 1, gildedRoseV2.items[0].sellIn);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Quality becomes zero when sellIn is negative")
    void backstagePassesQualityBecomesZeroWhenSellInIsNegative() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 3;
        int sellIn = 0;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(0, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Increases quality by 3 when sellIn is 5 or less")
    void backstagePassesIncreasesQualityByThreeWhenSellInIsFiveOrLess() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 4;
        int sellIn = 5;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality + 3, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Increases quality by 2 when sellIn is 6 to 10")
    void backstagePassesIncreasesQualityByTwoWhenSellInIsSixToTen() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 4;
        int sellIn = 6;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality + 2, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Increases quality by 1 when sellIn is greater than 10")
    void backstagePassesIncreasesQualityByOneWhenSellInIsGreaterThanTen() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 4;
        int sellIn = 11;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality + 1, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Does not increase quality past 50 when (sellIn > 0)")
    void backstagePassesDoesNotIncreaseQualityPastFiftyWhenSellInGreaterThanZero() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 50;
        int sellIn = 7;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Increases quality by 3 when sellIn is 5 or less (max 50)")
    void backstagePassesIncreasesQualityByThreeWhenSellInIsFiveOrLessUpToMaxQuality() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 49;
        int sellIn = 3;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(min(quality + 3, 50), gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Backstage Passes: Increases quality by 2 when sellIn is 6 to 10 (max 50)")
    void backstagePassesIncreasesQualityByTwoWhenSellInIsSixToTenUpToMaxQuality() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 40;
        int sellIn = 7;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality + 2, gildedRoseV2.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("Sulfuras: Quality and sellIn do not change")
    void sulfurasQualityAndSellInDoNotChange() {
        // given, arrange
        String name = "Sulfuras, Hand of Ragnaros";
        int quality = 4;
        int sellIn = 6;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRoseV2 gildedRoseV2 = new GildedRoseV2(items);
        gildedRoseV2.updateQuality();

        // then, assert
        assertEquals(quality, gildedRoseV2.items[0].quality);
        assertEquals(sellIn, gildedRoseV2.items[0].sellIn);
    }
}
