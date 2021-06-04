package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Purchase {
    private List<Item> cart = new ArrayList<>();

    public void addToCart ( Item boughtItem) {
        cart.add(boughtItem);
    }

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
