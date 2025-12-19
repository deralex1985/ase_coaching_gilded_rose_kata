package com.gildedrose;

import java.util.List;

import static com.gildedrose.ItemNames.*;

class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityForDefaultItem(item);
            updateSellInForDefaultItem(item);
            updateExpiredItems(item);
        }
    }

    private void updateQualityForDefaultItem(Item item) {
        if (item.name.equals(DEXTERITY_VEST.description)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
        if (item.name.equals(ELIXIR_OF_THE_MONGOOSE.description)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
        if (item.name.equals(CONJURED_MANA_CAKE.description)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
        if (item.name.equals(AGED_BRIE.description)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES.description)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

        }
        if (item.name.equals(BACKSTAGE_PASSES.description)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES.description)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

        }
        if (item.name.equals(SULFURAS.description)) {
            // tbd
        }
    }

    private void updateSellInForDefaultItem(Item item) {
        if (!item.name.equals(SULFURAS.description)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateExpiredItems(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE.description)) {
                if (!item.name.equals(BACKSTAGE_PASSES.description)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS.description)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
