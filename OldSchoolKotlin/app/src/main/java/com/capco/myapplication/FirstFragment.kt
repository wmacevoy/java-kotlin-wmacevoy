package com.capco.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.capco.myapplication.databinding.FragmentFirstBinding
import kotlin.math.pow

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // make getters to simplify the rest of working with the ui components of this fragment

    private val buttonFirst : Button get() = binding.buttonFirst
    private val calculateButton : Button get() = binding.calculateButton
    private val loanAmountEditText : EditText get() = binding.loanAmountEditText
    private val loanAmount : Double get() = loanAmountEditText.text.toString().toDoubleOrNull() ?: 0.0
    private val interestRateEditText : EditText get() = binding.loanAmountEditText
    private val interestRate : Double get() = interestRateEditText.text.toString().toDoubleOrNull() ?: 0.0
    private val loanTermEditText : EditText get() = binding.loanTermEditText
    private val loanTerm : Int get() = loanTermEditText.text.toString().toIntOrNull() ?: 0
    private val resultTextView : TextView get() = binding.resultTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        calculateButton.setOnClickListener { onClickCalculate() }
    }

    private fun onClickCalculate() {
        val monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, loanTerm)
        resultTextView.text =
            "Monthly Payment: $${String.format("%.2f", monthlyPayment)}"
    }

    private fun calculateMonthlyPayment(loanAmount: Double, interestRate: Double, loanTerm: Int): Double {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}