package com.gildedrose;

public enum ItemNames {
    DEXTERITY_VEST("+5 Dexterity Vest"),
    AGED_BRIE("Aged Brie"),
    ELIXIR_OF_THE_MONGOOSE("Elixir of the Mongoose"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED_MANA_CAKE("Conjured Mana Cake");

    public final String description;

    private ItemNames(String description){
        this.description=description;
    }

}
