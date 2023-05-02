package com.capco.myapplication

import kotlin.math.pow

fun calculateMonthlyPayment(loanAmount: Double, interestRate: Double, loanTerm: Int): Double {
        val monthlyInterestRate : Double = (interestRate / 100) / 12
        val numberOfPayments : Int = loanTerm * 12

        // Calculate the monthly payment using the formula
        val monthlyPayment : Double = if (monthlyInterestRate == 0.0) {
            loanAmount / numberOfPayments
        } else {
            val interestRateFactor = (1.0 + monthlyInterestRate).pow(numberOfPayments);
            (loanAmount * monthlyInterestRate * interestRateFactor) / (interestRateFactor - 1)
        }

        return monthlyPayment
}