package com.techelevator;

import java.math.BigDecimal;

public class ChipItem extends Item{
    //public ChipItem(String itemName, String itemType, BigDecimal itemPrice) {
        //super(itemName, itemType, itemPrice);
    //}

    public ChipItem(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
    }

    @Override

    //use extra spaces to align on final sale output
    public String itemSound() {

        return "      Crunch Crunch, Yum!";
    }


}
