package com.techelevator;

import java.math.BigDecimal;

public class DrinkItem extends Item{
//    public DrinkItem(String itemName, String itemType, BigDecimal itemPrice) {
//        super(itemName, itemType, itemPrice);
//    }

    public DrinkItem(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
    }

    @Override

    //use extra spaces to align on final sale output
    public String itemSound() {
        return "      Glug Glug, Yum!";
    }
}
