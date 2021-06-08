package com.techelevator;


import java.math.BigDecimal;

 public abstract class Item {

    // abstract class, create subclasses for each vending machine item that extend item
     //assign sound in each subclass instead of in main item class


    private String itemName;
    private BigDecimal itemPrice;



     //
    public Item(String itemName, BigDecimal itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;

    }
    public Item(){

    }



   // @Override //to delete if not used
    public String toString() {
        return itemName + " >>> " + itemPrice;
    }

    public String getItemName() {
     return itemName;
 }

    public void setItemName(String itemName) {
         this.itemName = itemName;
     }

    public BigDecimal getItemPrice() {
            return itemPrice;
        }

    public void setItemPrice(BigDecimal itemPrice) {
         this.itemPrice = itemPrice;
     }

    public abstract String itemSound();

    public String dispensing() {
         return itemSound();
     }

//     public void setItemType(String itemType) {
//         this.itemType = itemType;
//     }

//        public String getItemType() {
//            return itemType;
//        }

}
