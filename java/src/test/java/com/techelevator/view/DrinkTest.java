package com.techelevator.view;

import com.techelevator.CandyItem;
import com.techelevator.DrinkItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkTest {

    private DrinkItem testDrink;
    private BigDecimal drinkPrice = new BigDecimal("1.25");

    @Before
    public void setup() {

        testDrink = new DrinkItem("Cola", drinkPrice );
    }

    @Test
    public void make_noise_correct () {
        Assert.assertTrue("Glug Glug, Yum!".equals(testDrink.itemSound()));
    }

    @Test
    public void get_name_returns_name() {
        Assert.assertEquals("Cola", testDrink.getItemName());
    }

    @Test
    public void get_price_returns_price () {
        Assert.assertEquals(drinkPrice, testDrink.getItemPrice());
    }
}
