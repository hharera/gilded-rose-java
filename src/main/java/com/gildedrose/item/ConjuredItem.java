package com.gildedrose.item;

import com.gildedrose.Item;

public class ConjuredItem extends Item implements QualityUpdatable {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        decreaseQualityBy(2);
        decreaseSellIn();
        if (sellIn < 0)
            decreaseQualityBy(2);
    }
}
