package com.techelevator.view;

import java.math.BigDecimal;

public class DrinkItem extends Item{
//    public DrinkItem(String itemName, String itemType, BigDecimal itemPrice) {
//        super(itemName, itemType, itemPrice);
//    }

    public DrinkItem(String itemName, BigDecimal itemPrice) {
        super();
    }

    @Override
    public String itemSound() {
        return "Glug Glug, Yum!";
    }
}
