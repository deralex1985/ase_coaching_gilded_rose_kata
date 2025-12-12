## Vorgehen
 - Anforderungen verstehen: Gilded Rose Requirements lesen
 - Bestehendes Verhalten absichern durch Test welche das TexttestFixture nutzt 
 - Bestehenden Test scheint nur als Schablone für Itmes zu gelten. Kann sein das das Setup auf Grund der Struktur kein Sinn macht.
 - Alle Tests hinzufügen die es braucht un die Anforderungen abzusichern
 - Beginn des eigentlichen Refactorings. 
   - Tiny steps
   - Parallel Changes machen
   - Similarities finden

## Anforderungen
- Selling goods
- Goods deprecated in Quality as we get closer to "sell by date"

### Inventory system:
  - stores Items with properties: 
    - "Quality" -> the price, cannot be negative 
    - "SellIn" -> days left to sell the item
    - "Name"
  - items functionality:
    - Quality is a function of SellIn, degrades twice as usual after SellIn
    - Items have a fucntion where we can check if it can be sold 
  - Values are updated every day
  - Various Items implement the Quality over Time function differently, but always in relation to a default

### Details on quality over Time for different items
- Default product:
  - Once the sell by date has passed, Quality degrades twice as fast 
  - The Quality of an item is never negative
  - The Quality of an item is never more than 50
- "Aged Brie":
  -  increases in Quality the older it gets
- "Sulfuras":
  - never has to be sold
  - does not decreases in Quality
- "Backstage passes":
  - increases in Quality the older it gets (just like Brie)
  - Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
  - Quality drops to 0 after the concert
- "Conjured Items":
  - degrade in Quality twice as fast as normal items
  
    
  **Class Item is not to be touched!**
 