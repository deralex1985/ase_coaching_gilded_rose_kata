package com.gildedrose;

import com.gildedrose.model.CustomItem;
import com.gildedrose.model.Item;
import com.gildedrose.update.strategies.AgedBrieUpdateBehaviour;
import com.gildedrose.update.strategies.BackstagePassUpdateBehaviour;
import com.gildedrose.update.strategies.DefaultUpdateBehaviour;
import com.gildedrose.update.strategies.SulfrasUpdateBehaviour;

import java.util.ArrayList;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

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

        GildedRose app = new GildedRose(customItems);

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
