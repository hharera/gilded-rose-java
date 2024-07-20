package com.gildedrose;

public class GildedRoseV3 {

    Item[] items;

    public GildedRoseV3(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item instanceof QualityUpdatable)
                ((QualityUpdatable) item).updateQuality();
        }
    }
}
