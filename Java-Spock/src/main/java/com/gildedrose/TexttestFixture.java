package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 3, 12)); //
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7)); //
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80)); //
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45));
        // this conjured item does not work properly yet
        items.add(new Item("Conjured Mana Cake", 3, 6));



        List<CustomItem> customItems = new ArrayList<>();
        customItems.add(new CustomItem(new Item("+5 Dexterity Vest", 3, 12) , new DefaultUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Aged Brie", 2, 0), new AgedBrieUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Elixir of the Mongoose", 5, 7) , new DefaultUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) , new SulfrasUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80), new SulfrasUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), new BackstagePassUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30), new BackstagePassUpdateBehaviour()));
        customItems.add(new CustomItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45), new BackstagePassUpdateBehaviour()));
        // this conjured item does not work properly yet
        customItems.add(new CustomItem(new Item("Conjured Mana Cake", 3, 6), new DefaultUpdateBehaviour()));

        GildedRose app = new GildedRose(items, customItems);

        int days = 10;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (CustomItem item : customItems) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
