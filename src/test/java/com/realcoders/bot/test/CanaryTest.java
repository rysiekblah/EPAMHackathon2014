package com.realcoders.bot.test;

import com.realcoders.bot.Canary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomek on 4/26/14.
 */
public class CanaryTest {

    @Test
    public void testGet5() {
        Canary canary = new Canary();
        assertEquals(5, canary.get5());
    }

    @Test
    public void testTrueIsTrue() {
        assertEquals(true, true);

    }

}
