package com.example.a1334944.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private LoanCalculator loanCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Get main layout
        LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout1);

        //Create textView
        TextView title = new TextView(this);
        title.setText(getString(R.string.app_title));
        //Add textView to primary layout
        ll.addView(title);

        //Create layout for loanAmount
        LinearLayout userInputLayout1 = new LinearLayout(this);
        userInputLayout1.setOrientation(LinearLayout.HORIZONTAL);

        //Create textView
        TextView loanAmountTextView = new TextView(this);
        loanAmountTextView.setText(getString(R.string.loanAmount));
        //Create EditText
        EditText loanAmountEditText = new EditText(this);
        loanAmountEditText.setHint(getString(R.string.hint1));

        userInputLayout1.addView(loanAmountTextView);
        userInputLayout1.addView(loanAmountEditText);

        //add to main layout
        ll.addView(userInputLayout1);

        //Create layout for years
        LinearLayout userInputLayout2 = new LinearLayout(this);
        userInputLayout1.setOrientation(LinearLayout.HORIZONTAL);

        //Create textView
        TextView yearsTextView = new TextView(this);
        loanAmountTextView.setText(getString(R.string.termOfLoan));
        //Create EditText
        EditText yearsEditText = new EditText(this);
        loanAmountEditText.setHint(getString(R.string.hint2));

        userInputLayout2.addView(yearsTextView);
        userInputLayout2.addView(yearsEditText);

        //add to main layout
        ll.addView(userInputLayout2);

        //Create layout for years
        LinearLayout userInputLayout3 = new LinearLayout(this);
        userInputLayout1.setOrientation(LinearLayout.HORIZONTAL);

        //Create textView
        TextView interestTextView = new TextView(this);
        interestTextView.setText(getString(R.string.yearlyRate));
        //Create EditText
        EditText interEditText = new EditText(this);
        loanAmountEditText.setHint(getString(R.string.hint3));

        userInputLayout3.addView(interestTextView);
        userInputLayout3.addView(interestEditText);

        //add to main layout
        ll.addView(userInputLayout2);





    }
}
