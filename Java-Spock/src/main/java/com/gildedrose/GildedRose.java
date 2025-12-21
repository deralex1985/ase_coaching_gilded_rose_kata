package com.gildedrose;

import com.gildedrose.model.CustomItem;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class GildedRose {
    private final List<CustomItem> customItems;

    public void updateQuality() {
        for (CustomItem customItem : customItems) {
            customItem.update();
        }
    }

}
