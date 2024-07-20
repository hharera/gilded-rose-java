package com.gildedrose;

public interface QualityUpdatable {

    void decreaseQuality();

    void decreaseSellIn();

    int getSellIn();

    default void updateQuality() {
        decreaseQuality();

        decreaseSellIn();
        if (getSellIn() < 0)
            decreaseQuality();
    }
}
