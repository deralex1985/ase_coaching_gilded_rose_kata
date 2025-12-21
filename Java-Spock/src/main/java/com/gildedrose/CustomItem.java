package com.gildedrose;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomItem {
    private Item item;
    private final UpdateBehaviour updateBehaviour;

    public void update(){
        updateBehaviour.update(item);
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
