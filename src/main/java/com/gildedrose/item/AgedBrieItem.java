package com.gildedrose.item;

import com.gildedrose.Item;

import static java.lang.Integer.min;

public class AgedBrieItem extends Item implements QualityUpdatable {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        quality = min(quality + 1, 50);
        sellIn--;
        if (sellIn < 0) {
            quality = min(quality + 1, 50);
        }
    }
}
