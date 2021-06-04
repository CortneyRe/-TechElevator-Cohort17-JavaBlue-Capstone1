package com.techelevator;

import java.math.BigDecimal;

public class CandyItem extends Item{
//    public CandyItem(String itemName, String itemType, BigDecimal itemPrice) {
//        super(itemName, itemType, itemPrice);
//    }

    public CandyItem(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public String itemSound() {
        return "Munch Munch, Yum!";
    }
}
