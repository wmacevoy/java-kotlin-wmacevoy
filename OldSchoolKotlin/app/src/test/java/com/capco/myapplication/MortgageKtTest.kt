package com.capco.myapplication

import org.junit.Test
import kotlin.math.abs

class MortgageKtTest {

    @Test
    fun calculateMonthlyPayment() {
        var loanAmount = 240000.0;
        var loanTerm = 30;
        var interestRate = 7.25;
        var expectedPayment = 1637;

        var resultPayment = com.capco.myapplication.calculateMonthlyPayment(loanAmount,interestRate,loanTerm)

        assert(abs(expectedPayment-resultPayment) < 1.00 );
    }
}