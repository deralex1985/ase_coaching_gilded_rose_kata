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
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals(DEXTERITY_VEST.description)) {
            defaultUpdate(item);
        }

        if (item.name.equals(ELIXIR_OF_THE_MONGOOSE.description)) {
            defaultUpdate(item);
        }

        if (item.name.equals(CONJURED_MANA_CAKE.description)) {
            defaultUpdate(item);
        }

        if (item.name.equals(AGED_BRIE.description)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0 && item.quality < 50) {
                    item.quality = item.quality + 1;
            }
        }

        if (item.name.equals(BACKSTAGE_PASSES.description)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }

        if (item.name.equals(SULFURAS.description)) {
            // tbd
        }
    }

    private static void defaultUpdate(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}
