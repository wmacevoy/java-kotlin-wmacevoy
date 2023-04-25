package com.capco.oldschooljava;

import static org.junit.Assert.*;

import org.junit.Test;

public class BigBankTest {

    @Test
    public void testToString() {
        BigBank bigBank = new BigBank();
        assertEquals(bigBank.toString(), "");
    }
}