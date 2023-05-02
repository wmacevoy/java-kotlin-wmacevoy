package com.capco.oldschooljava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.capco.oldschooljava.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private FragmentFirstBinding getBinding() {
        if (binding == null) {
            throw new NullPointerException("binding requested while null");
        }
        return binding;
    }

    // make getters to simplify the rest of working with the ui components of this fragment

    private Button getButtonFirst() { return getBinding().buttonFirst; }
    private Button getCalculateButton() { return getBinding().calculateButton; }
    private EditText getLoanAmountEditText() { return getBinding().loanAmountEditText; }
    private double getLoanAmount() { return Double.parseDouble(getLoanAmountEditText().getText().toString()); }
    private EditText getInterestRateEditText() { return getBinding().interestRateEditText; }
    private double getInterestRate() { return Double.parseDouble(getInterestRateEditText().getText().toString()); }
    private EditText getLoanTermEditText() { return getBinding().loanTermEditText; }
    private int getLoanTerm() { return Integer.parseInt(getLoanTermEditText().getText().toString()); }
    private TextView getResultTextView() { return getBinding().resultTextView; }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getButtonFirst().setOnClickListener((clickedView) -> {
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment);
        });

        getCalculateButton().setOnClickListener((clickedView) -> {
            onClickCalculate();
        });
    }

    private void onClickCalculate() {
        double monthlyPayment = calculateMonthlyPayment(getLoanAmount(), getInterestRate(), getLoanTerm());
        String resultText = "Monthly Payment: $" + String.format("%.2f", monthlyPayment);
        getResultTextView().setText(resultText);
    }

    private double calculateMonthlyPayment(double loanAmount, double interestRate, int loanTerm) {
        double monthlyInterestRate = (interestRate / 100.0) / 12.0;
        int numberOfPayments = loanTerm * 12;
        double monthlyPayment;
        if (monthlyInterestRate == 0.0) {
            monthlyPayment = loanAmount / numberOfPayments;
        } else {
            double interestRateFactor = Math.pow(1.0 + monthlyInterestRate,numberOfPayments);
            monthlyPayment = (loanAmount * monthlyInterestRate * interestRateFactor) / (interestRateFactor - 1);
        }
        return monthlyPayment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}