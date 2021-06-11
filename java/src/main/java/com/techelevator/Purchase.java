package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    //
    private List<Item> cart = new ArrayList<>();


    //
    public void addToCart (Item boughtItem) {

        cart.add(boughtItem);
    }


    //
    public String emptyCart () {
        String itemSound = "";
        if (!cart.isEmpty ()) {
            for( Item edible : cart ) {
                itemSound = itemSound.concat(edible.dispensing() + "\n");
            }
        }
        return itemSound;
    }

}
