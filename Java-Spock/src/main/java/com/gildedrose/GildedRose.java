package com.gildedrose;

import static com.gildedrose.ItemNames.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityForDefaultItem(i);
            updateSellInForDefaultItem(i);
            updateExpiredItems(i);
        }
    }

    private void updateQualityForDefaultItem(int i) {
        if (!items[i].name.equals(AGED_BRIE.description) && !items[i].name.equals(BACKSTAGE_PASSES.description)) {
            if (items[i].quality > 0) {
                if (!items[i].name.equals(SULFURAS.description)) {
                    items[i].quality = items[i].quality - 1;
                }
            }
        } else {
            if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;

                if (items[i].name.equals(BACKSTAGE_PASSES.description)) {
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }

                    if (items[i].sellIn < 6) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }
        }
    }

    private void updateSellInForDefaultItem(int i) {
        if (!items[i].name.equals(SULFURAS.description)) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    private void updateExpiredItems(int i) {
        if (items[i].sellIn < 0) {
            if (!items[i].name.equals(AGED_BRIE.description)) {
                if (!items[i].name.equals(BACKSTAGE_PASSES.description)) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals(SULFURAS.description)) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
            }
        }
    }
}
