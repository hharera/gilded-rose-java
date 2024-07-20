package com.gildedrose;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void increaseQuality() {
        quality = min(quality + 1, 50);
    }

    public void decreaseQuality() {
        quality = max(quality - 1, 0);
    }

    public void decreaseQualityBy(int value) {
        quality = max(quality - value, 0);
    }

    public void decreaseSellIn() {
        sellIn -= 1;
    }

    public int getSellIn() {
        return sellIn;
    }
}
