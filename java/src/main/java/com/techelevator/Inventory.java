package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Inventory {

    // read thru CSV file to generate base inventory
    // create a map and stack (first in first out) to generate ordered list of inventory
    // call on inventory for vending machine class


    private static Map<String, Stack<Item>> theInventory = new TreeMap<>();


    public Map inventoryInput ()  {
        //each property of an item in CSV inventory is separated by a "|"
        // separate each line by seeing wherever a "|" is, turn that into an array of strings with a loop
        //line.split to separate each property of each line (slot, name, type, price
        // add inventory to each subclass by checking if line starts with "A", "B", "C", "D"

        File inputCSV = new File("vendingmachine.csv");
        int count = 0;
        try (Scanner inventory = new Scanner(inputCSV)) {

            while (inventory.hasNextLine()) {
                String line = inventory.nextLine();
                String[] splitArray = line.split("\\|");
                count++;
                Stack<Item> inventoryStack = new Stack<>();

                if (splitArray[0].contains("A")) {
                    for (int i = 0; i < 5; i++) {
                        inventoryStack.push(new ChipItem(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                } else if (splitArray[0].contains("B")) {
                    for (int i = 0; i < 5; i++) {
                        inventoryStack.push(new CandyItem(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                } else if (splitArray[0].contains("C")) {
                    for (int i = 0; i < 5; i++) {
                        inventoryStack.push(new DrinkItem(splitArray[1], new BigDecimal(splitArray[2])));
                    }

                } else if (splitArray[0].contains("D")) {
                    for (int i = 0; i < 5; i++) {
                        inventoryStack.push(new GumItem(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                }
                theInventory.put(splitArray[0], inventoryStack);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return theInventory;
    }

    public static Map<String, Stack<Item>> getTheInventory() {
        return theInventory;
    }

    public static void setTheInventory(Map<String, Stack<Item>> theInventory) {
        Inventory.theInventory = theInventory;
    }

}


