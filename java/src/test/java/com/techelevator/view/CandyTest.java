package com.techelevator.view;

import com.techelevator.CandyItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class CandyTest {

    private CandyItem testCandy;
    private BigDecimal candyPrice = new BigDecimal("1.80");

    @Before
    public void setup() {

        testCandy = new CandyItem("Moonpie", candyPrice );
    }

    @Test
    public void make_noise_correct () {
        Assert.assertTrue("Munch Munch, Yum!".equals(testCandy.itemSound()));
    }

    @Test
    public void get_name_returns_name() {
        Assert.assertEquals("Moonpie", testCandy.getItemName());
    }

    @Test
    public void get_price_returns_price () {
        Assert.assertEquals(candyPrice, testCandy.getItemPrice());
    }
}
