package com.techelevator.view;


import java.math.BigDecimal;

 abstract class Item {


        private String itemName;
        //private String itemType;
        private BigDecimal itemPrice;


    public Item(String itemName, String itemType, BigDecimal itemPrice) {
            this.itemName = itemName;
            //this.itemType = itemType;
            this.itemPrice = itemPrice;


    }

     public Item() {

     }

     public void setItemName(String itemName) {
         this.itemName = itemName;
     }

//     public void setItemType(String itemType) {
//         this.itemType = itemType;
//     }

     public void setItemPrice(BigDecimal itemPrice) {
         this.itemPrice = itemPrice;
     }

     public String getItemName() {
            return itemName;
        }

//        public String getItemType() {
//            return itemType;
//        }

        public abstract String itemSound();

    //public String consume() {
        //return itemSound();

    public BigDecimal getItemPrice() {
            return itemPrice;
        }
}
