package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.QualityUpdatable;

public class BackstagePassesItem extends Item implements QualityUpdatable {

    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        increaseQuality();

        if (sellIn < 11)
            increaseQuality();
        if (sellIn < 6)
            increaseQuality();

        decreaseSellIn();
        if (sellIn < 0) {
            quality = 0;
        }
    }
}
