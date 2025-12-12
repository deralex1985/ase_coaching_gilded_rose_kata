package com.gildedrose

import spock.lang.Specification

/**
 * Spock unit tests.
 */
class GildedRoseSpec extends Specification {

    def "Once the sell by date has passed, Quality degrades twice as fast"() {
        given: "Basketball that has passed its sell by date"
        Item[] items = [new Item("Basketball", 0, 10)]
        GildedRose app = new GildedRose(items)

        when: "updating quality"
        app.updateQuality()

        then: "the quality decreases by two points"
        app.items[0].name == "Basketball"
        app.items[0].quality == 8
    }


    def "The Quality of an item is never negative"() {
        given: "Basketball has no quality anymore"
        Item[] items = [new Item("Basketball", 5, 0)]
        GildedRose app = new GildedRose(items);

        when: "updating quality"
        app.updateQuality()

        then: "the quality remains zero"
        app.items[0].name == "Basketball"
        app.items[0].quality == 0
    }

    def "The Quality of an item is never more than 50"() {
        given: "Aged Brie with very high quality"
        Item[] items = [new Item("Aged Brie", 5, 50)]
        GildedRose app = new GildedRose(items)

        when: "updating quality"
        app.updateQuality()

        then: "the quality remains zero"
        app.items[0].name == "Aged Brie"
        app.items[0].quality == 50
    }


    def "The Quality of an item is never more than 50"() {
        given: "Aged Brie with very high quality"
        Item[] items = [new Item("Aged Brie", 5, 50)]
        GildedRose app = new GildedRose(items)

        when: "updating quality"
        app.updateQuality()

        then: "the quality remains zero"
        app.items[0].name == "Aged Brie"
        app.items[0].quality == 50
    }


    //"Sulfuras":
    //never has to be sold
    //does not decreases in Quality


    def "Backstage passes increases in Quality the older it gets"() {
        given:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 12, 40)]
        GildedRose app = new GildedRose(items)

        when: "updating quality"
        app.updateQuality()

        then: "the quality increases"
        app.items[0].name == "Backstage passes to a TAFKAL80ETC concert"
        app.items[0].quality == 41
    }


    def "Concert Tickets have correct quality over time" () {
        given:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 12, 30)]
        GildedRose app = new GildedRose(items)

        when: "quality is updated over time"
        app.updateQuality()
        def qualityWhen11DaysAreLeft = app.items[0].quality
        updateNrOfDays(app, 4)
        def qualityWhen7DaysAreLeft = app.items[0].quality
        updateNrOfDays(app, 3)
        def qualityWhen4DaysAreLeft = app.items[0].quality
        updateNrOfDays(app, 5)
        def qualityAfterTheConcert = app.items[0].quality

        then: "the quality increases"
        qualityWhen11DaysAreLeft == 31
        qualityWhen7DaysAreLeft == 38
        qualityWhen4DaysAreLeft == 45
        qualityAfterTheConcert == 0
    }

    private void updateNrOfDays(GildedRose app, Integer days) {
        for (int day = 0; day < days; day++) {
            app.updateQuality()
        }
    }

}
