package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.QualityUpdatable;

public class DefaultItem extends Item implements QualityUpdatable {

    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}
