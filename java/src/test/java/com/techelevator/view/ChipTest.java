package com.techelevator.view;


import com.techelevator.ChipItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipTest {

        private ChipItem testChip;
        private BigDecimal chipPrice = new BigDecimal("1.50");

    @Before
        public void setup() {

        testChip = new ChipItem("Potato Crisps", chipPrice );
        }

        @Test
        public void make_noise_correct () {
            Assert.assertTrue("Crunch Crunch, Yum!".equals(testChip.itemSound()));
        }

        @Test
        public void get_name_returns_name() {
            Assert.assertEquals("Potato Crisps", testChip.getItemName());
        }

        @Test
        public void get_price_returns_price () {
            Assert.assertEquals(chipPrice, testChip.getItemPrice());
        }
    }

