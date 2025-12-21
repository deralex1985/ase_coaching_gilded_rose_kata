package com.gildedrose;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class GildedRose {
    private final List<Item> items;
    private final List<CustomItem> customItems;

    public void updateQuality() {
        for (CustomItem customItem : customItems) {
            customItem.update();
        }
    }

}
