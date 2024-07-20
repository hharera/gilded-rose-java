package com.gildedrose.item;

import com.gildedrose.Item;

public class SulfurasItem extends Item {

    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}
