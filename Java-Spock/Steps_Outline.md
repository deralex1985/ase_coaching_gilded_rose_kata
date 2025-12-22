## Refactoring Steps Outline

### Annahme
- Testfixture ist angepasst, so dass die Anforderungen abgedeckt sind
- Setup funktioniert rein technisch
- Lombok ist eingebaut:  
  - implementation("org.projectlombok:lombok:1.18.42")
  - annotationProcessor 'org.projectlombok:lombok:1.18.42'



### Tiny Steps
1. Constants extrahieren
2. Liste statt Array benutzen for clarity
3. Replace else with if in AgedBrie Section
4. Konsolidere if: Ein if für AgedBrie, BackstagePass, Sulraf && qulaity > 0
5. Logik explizit machen für jedes Item
6. Obsolete Function SellInUpdate löschen
7. Gleiches erkennen, defaultUpdateFucntion einführen
8. Special Case für Backstage Pasa aus updateExpiredItem entfernen und nur in Backstage Pass reinpacken
9. Logik für Backsage Pass aus Agd Brie entferen
10. Regel für AgeBrie die nie durchlaufen wird löschen: if (item.sellIn < 0 && item.quality < 50)

### Introduction of CustomItem / WrappedItem
- Wrapper Item mit zwei Feldern einführen: 
  - Feld Interface UpdateBehaviour 
  - Feld Item
  - toString von Item übernehmen als Override
- UpdateBehaviour Interface einführen
- Neue Klassen erstellen welches das Update Verhalten/ Interface implementieren, dazu z.B. für Default Update Implementierung kopieren
- Parallel Change machen
- Package Structure verbessern
  - model
    - WrappedItem
    - Item
  - update
    - /api
      - Interface
    - /strategies
      - AgedBrieUpdateBehaviour
      - BackstagePassUpdateBehaviour
      - 

