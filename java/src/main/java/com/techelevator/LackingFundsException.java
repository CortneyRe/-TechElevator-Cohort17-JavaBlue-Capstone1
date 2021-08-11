package com.techelevator;

    public class LackingFundsException extends Exception {


        String message = "";
            public LackingFundsException(String message) {
                this.message = message;
            }
            public String getMessage() {
                return message;
            }
        }

