package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // Smoke Test
    @Test
    @DisplayName("given default item not any of [Backstage passes, Aged Brie, Sulfuras] and quality is greater than zero, the quality should be decreased by 1")
    void given_default_item_and_quality_greater_than_zero_then_quality_should_be_decreased_by_one() {
        // given, arrange
        String name = "Default Item";
        int quality = 2;
        Item item = new Item(name, 1, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality - 1, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("given default item not any of [Backstage passes, Aged Brie, Sulfuras] and quality is less than or equals zero, the quality should not be changed")
    void given_default_item_and_quality_less_than_zero_then_quality_should_not_be_changed() {
        // given, arrange
        String name = "Default Item";
        int quality = 0;
        Item item = new Item(name, 1, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("given default item not any of [Backstage passes, Aged Brie, Sulfuras] the sellIn should be decreased by 1")
    void given_default_item_should_decrease_the_sellIn_by_1() {
        // given, arrange
        String name = "Default Item";
        int quality = 2;
        int sellIn = 2;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(sellIn - 1, gildedRose.items[0].sellIn);
    }

    // Smoke Test
    @Test
    @DisplayName("Given Default item and the sellIn less than zero, and quality is greater than zero, the quality should be decreased by 2 at min 0")
    void given_names_not_in_low_quality_names_and_quality_greater_than_zero_should_decrease_by_2() {
        // given, arrange
        String name = "Default item";
        int quality = 1;
        Item item = new Item(name, -1, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(max(quality - 2, 0), gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("given 'Aged Brie item and the quality greater than 49, the quality should not changed")
    void test_update_quality_given_Aged_Brie_item_and_quality_greater_than_49_should_increase_the_quality() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 50;
        int sellIn = -1;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("give 'Aged Brie item and its sellIn less than zero and the quality less than 50, the quality should be increased by 2 at max 50")
    void test_update_quality_given_Aged_Brie_item_and_sellIn_less_than_zero_and_quality_less_than_50_should_increase_the_quality() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 4;
        int sellIn = -1;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(min(quality + 2, 50), gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When the item name equals 'Aged Brie', with sellIn greater than -1 and the quality less than 50, the quality should be increased by 1")
    void test_update_quality_given_name_Aged_Brie_and_quality_less_than_50_should_increase_the_quality() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 4;
        int sellIn = 40;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality + 1, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When the item name equals 'Aged Brie', the sellIn should be decreased by 1")
    void test_update_quality_given_name_Aged_Brie_and_should_increase_the_quality() {
        // given, arrange
        String name = "Aged Brie";
        int quality = 4;
        int sellIn = 40;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(sellIn - 1, gildedRose.items[0].sellIn);
    }

    // Smoke Test
    @Test
    @DisplayName("Given Backstage passes item and sellIn less than zero, the quality should be zero")
    void test_update_quality_given_sellIn_zero_and_name_equals_Backstage_passes_to_a_TAFKAL80ETC_concert() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item item = new Item(name, -1, 3);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(0, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When Backstage passes item and quality less than 50 and sellIn less than 6 should increase the quality by 3")
    void test_update_quality_given_Backstage_passes_item_and_quality_less_than_50_and_sellIn_less_than_should_increase_the_quality() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 4;
        int sellIn = 5;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality + 3, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When Backstage passes item and quality less than 50 and sellIn less than 11 and greater than 5 should increase the quality by 2")
    void test_update_quality_given_Backstage_passes_item_and_quality_less_than_50_and_sellIn_less_than11_should_increase_the_quality() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 4;
        int sellIn = 6;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality + 2, gildedRose.items[0].quality);
    }
    // Smoke Test
    @Test
    @DisplayName("When Backstage passes item and quality less than 50 and sellIn greater than 10 the quality should be increased by 1")
    void test_update_quality_given_Backstage_passes_item_and_quality_less_than_50_and_sellIn_greater_than_10_the_quality_should_be_increased_by_1() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 4;
        int sellIn = 11;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality + 1, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When Backstage passes item and quality greater than 49, sellIn greater than 5 and " +
                    "sellIn less than 11 should not increase the quality")
    void test_update_quality_given_Backstage_passes_item_and_quality_greater_than_50_and_sellIn_less_than11_and_sellInn_greater_than_5_should_not_increase_the_quality() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 50;
        int sellIn = 7;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When Backstage passes item and quality less than 50, sellIn less than 6 " +
                    "then, the quality should be decreased by 3")
    void test_update_quality_given_Backstage_passes_item_and_quality_less_than_50_and_sellIn_less_than11_and_sellInn_greater_than_5_should_not_increase_the_quality() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 40;
        int sellIn = 3;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality + 3, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When Backstage passes item and quality less than 50, sellIn greater than 5 and " +
                    "sellIn less than 11 should not increase the quality")
    void test_update_quality_given_Backstage_passes_item_and_quality_less_than_50_and_sellIn_less_than_11_and__greater_than_5_should_increase_the_quality_by_2() {
        // given, arrange
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int quality = 40;
        int sellIn = 7;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality + 2, gildedRose.items[0].quality);
    }

    // Smoke Test
    @Test
    @DisplayName("When Sulfuras item, the quality should not be changed")
    void test_update_quality_given_Sulfuras_item_and_quality_less_than_quality_should_not_be_changed() {
        // given, arrange
        String name = "Sulfuras, Hand of Ragnaros";
        int quality = 4;
        int sellIn = 6;
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[] { item };

        // when, act
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // then, assert
        assertEquals(quality, gildedRose.items[0].quality);
    }
}
