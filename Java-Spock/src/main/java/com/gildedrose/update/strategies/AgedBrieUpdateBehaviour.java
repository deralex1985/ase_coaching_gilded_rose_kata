package com.gildedrose.update.strategies;

import com.gildedrose.model.Item;
import com.gildedrose.update.api.UpdateBehaviour;

public class AgedBrieUpdateBehaviour implements UpdateBehaviour {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}