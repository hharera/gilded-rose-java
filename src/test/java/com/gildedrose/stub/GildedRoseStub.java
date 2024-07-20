package com.gildedrose.stub;

import com.gildedrose.item.AgedBrieItem;
import com.gildedrose.GildedRoseV1;
import com.gildedrose.Item;

public class GildedRoseStub {

    public static GildedRoseV1 create(String name, int quality, int sellIn) {
        return new GildedRoseV1(new Item[] { new AgedBrieItem(name, sellIn, quality) });
    }
}
