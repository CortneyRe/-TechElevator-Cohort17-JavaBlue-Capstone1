package com.techelevator.view;

import com.techelevator.GumItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest {

    private GumItem testGum;
    private BigDecimal gumPrice = new BigDecimal(".95");

    @Before
    public void setup () {
        testGum = new GumItem("Little League Chew", gumPrice);

    }

    @Test
    public void make_noise_correct () {
        Assert.assertTrue("Chew Chew, Yum!".equals(testGum.itemSound()));
    }

    @Test
    public void get_name_returns_name() {
        Assert.assertEquals("Little League Chew", testGum.getItemName());
    }

    @Test
    public void get_price_returns_price () {
        Assert.assertEquals(gumPrice, testGum.getItemPrice());
    }


}
