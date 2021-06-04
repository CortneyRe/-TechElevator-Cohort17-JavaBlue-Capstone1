package com.techelevator.view;

import java.io.FileNotFoundException;
import java.lang.invoke.LambdaConversionException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {
    //
    private BigDecimal userBalance = new BigDecimal("0.00");
    private Map<String, Stack<Item>> vendingMachineInventory;


    public VendingMachine() throws FileNotFoundException {
        Inventory builtInventory = new Inventory();
        vendingMachineInventory = builtInventory.inventoryInput();

    }

    //
    public Item buyVendingItem(String slotName) throws NotInStockException, LackingFundsException {
        Item item = null;

        if(vendingMachineInventory.get(slotName).size() > 0) {
            if (userBalance.compareTo(vendingMachineInventory.get(slotName).peek().getItemPrice()) >= 0) {
                this.userBalance = userBalance.subtract(vendingMachineInventory.get(slotName).peek().getItemPrice());
                Item boughtItem  =vendingMachineInventory.get(slotName).pop();
                return boughtItem;
            }else {
                throw new LackingFundsException("Please add more funds to purchase items");
            }
        }else {
            throw new NotInStockException("This item is not in stock");
        }
    }


    //
    public void addMoreFunds(BigDecimal userSubmittedFunds) {
        this.userBalance = userBalance.add(userSubmittedFunds);
    }

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public Map<String, Stack<Item>> getVendingMachineInventory() {
        return vendingMachineInventory;
    }

    public String makeChange() {
        int pennyCounter = 0;
        int nickelCounter = 0;
        int dimeCounter = 0;
        int quarterCounter = 0;
        String expectedChangeToUser = "";


    }
}
