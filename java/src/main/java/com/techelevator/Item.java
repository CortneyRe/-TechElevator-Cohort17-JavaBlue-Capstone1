package com.techelevator;


import java.math.BigDecimal;

 abstract class Item {

    //
    private String itemName;
    private BigDecimal itemPrice;
     //private String itemType;


     //
    public Item(String itemName, BigDecimal itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        //this.itemType = itemType;
    }


    //
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
