package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.techelevator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine Vend1000;
    private ChipItem chips;
    private BigDecimal itemPrice = new BigDecimal("3.05");
    private BigDecimal userBalance = new BigDecimal(0.00);
    private double uB = userBalance.doubleValue();

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

    @Test
    public void testGetA1() {
        Item theItem = Vend1000.getVendingMachineInventory().get("A1").peek();
      //assertEquals("Potato Crisps", theItem);
        Assert.assertTrue("Potato Crisps".equals(theItem.getItemName()));

    }

    @Test
    public void testGetA1Price() {
        Item theItem = Vend1000.getVendingMachineInventory().get("A1").peek();
       assertEquals(new BigDecimal("3.05"), Vend1000.getVendingMachineInventory().get("A1").peek().getItemPrice());

    }

    @Test
    public void testVendingMachineBalance() {
        assertEquals(new BigDecimal("10.00"), Vend1000.getUserBalance());

    }

    @Test
    public void testConsumeItems() throws NotInStockException, LackingFundsException {
        List<Item> currentBasket = new ArrayList<>();
        Purchase yourCart = new Purchase();
        Item boughtItem = Vend1000.buyVendingItem("A1");
        yourCart.addToCart(boughtItem);
        assertEquals("Crunch Crunch, Yum!\n", yourCart.emptyCart());

    }
    @Test
    public void testVendingMachinePurchase() {
        assertEquals("☺☺☺ Happy Snacking ☺☺☺\n" +
                "40 quarter(s), 0 dime(s), and 0 nickel(s) is your change.\n" +
                "Your balance is now $0.00", Vend1000.makeChange());
    }

    @Test
    public void testGetSound() {
        chips = new ChipItem("Name", new BigDecimal("0"));
        assertEquals("Crunch Crunch, Yum!", chips.itemSound());
    }

    @Test
    public void testDepletedSLot() {
        Vend1000.getVendingMachineInventory().get("A1").pop();
        assertEquals(4, Vend1000.getVendingMachineInventory().get("A1").size());
    }






}
