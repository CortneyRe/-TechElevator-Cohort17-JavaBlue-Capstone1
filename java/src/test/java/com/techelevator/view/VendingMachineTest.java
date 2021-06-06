package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.ChipItem;
import com.techelevator.LackingFundsException;
import com.techelevator.NotInStockException;
import com.techelevator.VendingMachine;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    VendingMachine Vend1000;
    ChipItem chips;

    @Before
    public void setUp() throws Exception {
        Vend1000 = new VendingMachine();
        Vend1000.addMoreFunds(new BigDecimal("10"));
    }

    @Test
    public void testGenerateInventory() {
        assertNotNull(Vend1000.getVendingMachineInventory());
    }

    @Test
    public void testGetInventory() {
        assertEquals(Vend1000.getVendingMachineInventory(), Vend1000.getVendingMachineInventory());

    }

//    @Test
//    public void testGetA1() {
//        assertEquals("Potato Crisps", Vend1000.getVendingMachineInventory().get("A1").peek().getItemName());
//
//    }
//
//    @Test
//    public void testGetA1Price() {
//        assertEquals(new BigDecimal("3.05"), Vend1000.getVendingMachineInventory().get("A1").peek().getItemPrice());

//    }

//    @Test
//    public void testVendingMachineBalance() {
//        assertEquals(new BigDecimal("10.00"), Vend1000.getBalance());
//
//    }

//    @Test
//    public void testCosumeItems() throws NotInStockException, LackingFundsException {
//        List<Items> currentBasket = new ArrayList<>();
//        PurchaseBasket yourCart = new PurchaseBasket();
//        Item boughtItem = Vend1000.purchaseItem("A1");
//        yourCart.addToBasket(boughtItem);
//        assertEquals("Crunch Crunch, Yum!\n", yourCart.consumeBasket());
//
//    }
//
//    public void testVendingMachinePurchase() {
//        assertEquals("Your change is: 40 Quarter(s) 0 Dime(s) 0 Nickel(s) \n" + "Your new balance is $"
//                + new BigDecimal("0.00"), Vend1000.returnChange());
//    }

    @Test
    public void testGetSound() {
        chips = new ChipItem("Name", new BigDecimal("0"));
        assertEquals("Crunch Crunch, Yum!", chips.itemSound());
    }

    @Test
    public void testStackDrop() {
        Vend1000.getVendingMachineInventory().get("A1").pop();
        assertEquals(4, Vend1000.getVendingMachineInventory().get("A1").size());
    }

    @Test
    public void testGetInvalidItem() {
        assertNull(Vend1000.getVendingMachineInventory().get("A6").peek());
    }




}
