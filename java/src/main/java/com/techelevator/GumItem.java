package com.techelevator;

import java.math.BigDecimal;

public class GumItem extends Item{
//    public GumItem(String itemName, String itemType, BigDecimal itemPrice) {
//        super(itemName, itemType, itemPrice);
//    }

    public GumItem(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public String itemSound() {
        return "      Chew Chew, Yum!";
    }
}
