## Vorgehen
 - Anforderungen verstehen: Gilded Rose Requirements lesen
 - Bestehenden Test fixen
 - Alle Tests hinzufügen die es braucht un die Anforderungen abzusichern
 - Beginn des eigentlichen Refactorings. 
   - Tiny steps
   - Parallel Changes machen
   - Similarities finden

## Anforderungen
- Selling goods
- Goods deprecated in Qulaity as we get closer to "sell by date"


- Inventory system:
  - stores Items with properties: 
    - "Quality" -> the price, cannot be negative 
    - "SellIn" -> days left to sell the item
    - "Name"
  - items functionality:
    - Quality is a function of SellIn, degrades twice as usual after SellIn
    - Items have a fucntion where we can check if it can be sold 
  - Values are updated every day
  - Various Items implement the Quality over Time function differently, but always in relation to a default
  
    
  **Class Item is not to be touched!**
 