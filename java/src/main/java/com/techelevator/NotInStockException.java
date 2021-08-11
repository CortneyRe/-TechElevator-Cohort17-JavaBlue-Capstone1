package com.techelevator;

    public class NotInStockException extends Exception {


        String message = "";
            public NotInStockException(String message) {
                this.message = message;
            }
            public String getMessage() {
                return message;
            }
    }

