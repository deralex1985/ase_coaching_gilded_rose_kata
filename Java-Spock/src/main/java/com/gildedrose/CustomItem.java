package com.gildedrose;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomItem {
    private final Item item;
    private final UpdateBehaviour updateBehaviour;

    public void update(){
        updateBehaviour.update(item);
    }
}
