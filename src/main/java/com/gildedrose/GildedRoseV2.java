package com.gildedrose;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * This version of the class is after refactoring the class
 */
public class GildedRoseV2 {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES =
                    "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRoseV2(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals(AGED_BRIE))
            updateAgedBrieQuality(item);
        else if (item.name.equals(BACKSTAGE_PASSES))
            updateBackstageQuality(item);
        else if (!item.name.equals(SULFURAS)) {
            updateDefaultItemQuality(item);
        }
    }

    private void updateDefaultItemQuality(Item item) {
        decreaseQuality(item);

        decreaseSellIn(item);
        if (item.sellIn < 0)
            decreaseQuality(item);
    }

    private void updateAgedBrieQuality(Item item) {
        increaseQuality(item);

        decreaseSellIn(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstageQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11)
            increaseQuality(item);
        if (item.sellIn < 6)
            increaseQuality(item);

        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item) {
        item.quality = min(item.quality + 1, 50);
    }

    private void decreaseQuality(Item item) {
        item.quality = max(item.quality - 1, 0);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
