package com.gildedrose;

import lombok.AllArgsConstructor;

import java.util.List;

import static com.gildedrose.ItemNames.*;

@AllArgsConstructor
class GildedRose {
    private final List<Item> items;
    private final List<CustomItem> customItems;
    private final BackstagePassUpdateBehaviour updateBehaviourBackstagePass= new BackstagePassUpdateBehaviour();
    private final AgedBrieUpdateBehaviour agedBrieUpdateBehaviour = new AgedBrieUpdateBehaviour();
    private final DefaultUpdateBehaviour defaultUpdateBehaviour = new DefaultUpdateBehaviour();
    private final SulfrasUpdateBehaviour sulfrasUpdateBehaviour = new SulfrasUpdateBehaviour();

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }
    public void updateQuality2() {
        for (CustomItem customItem : customItems) {
            customItem.update();
        }
    }


    private void updateItem(Item item) {
        if (item.name.equals(DEXTERITY_VEST.description)) {
            defaultUpdateBehaviour.update(item);
        }

        if (item.name.equals(ELIXIR_OF_THE_MONGOOSE.description)) {
            defaultUpdateBehaviour.update(item);
        }

        if (item.name.equals(CONJURED_MANA_CAKE.description)) {
            defaultUpdateBehaviour.update(item);
        }

        if (item.name.equals(AGED_BRIE.description)) {
            agedBrieUpdateBehaviour.update(item);
        }

        if (item.name.equals(BACKSTAGE_PASSES.description)) {
            updateBehaviourBackstagePass.update(item);
        }

        if (item.name.equals(SULFURAS.description)) {
            sulfrasUpdateBehaviour.update(item);
            // tbd
        }
    }

    public void updateBackstagePass(Item item) {
        updateBehaviourBackstagePass.update(item);
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
