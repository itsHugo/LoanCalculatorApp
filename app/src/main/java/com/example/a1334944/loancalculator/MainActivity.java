package com.example.a1334944.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double loanAmount;
    private int numberOfYears;
    private double yearlyInterestRate;

    private EditText edit1, edit2, edit3;

    private TextView text1, text2, text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateLoan(View view) {
        findViewById(R.id.warning).setVisibility(View.INVISIBLE);

        edit1=(EditText) findViewById(R.id.input1);
        edit2=(EditText) findViewById(R.id.input2);
        edit3=(EditText) findViewById(R.id.input3);
        try {
            loanAmount = Double.parseDouble(edit1.getText().toString());
            numberOfYears = Integer.parseInt(edit2.getText().toString());
            yearlyInterestRate = Double.parseDouble(edit3.getText().toString());

            if(loanAmount < 0 || numberOfYears < 0 ||numberOfYears > 25 ||
                    yearlyInterestRate < 0 || yearlyInterestRate > 100)
                throw new Exception();

            text1 = (TextView) findViewById(R.id.result1);
            text2 = (TextView) findViewById(R.id.result2);
            text3 = (TextView) findViewById(R.id.result3);


            text1.setText(Double.toString(Math.round(getMonthlyPayment()*100.0)/100.0));
            text2.setText(Double.toString(Math.round(getTotalCostOfLoan()*100.0)/100.0));
            text3.setText(Double.toString(Math.round(getTotalInterestRate()*100.0)/100.0));
        } catch(Exception e) {
            findViewById(R.id.warning).setVisibility(View.VISIBLE);
        }


    }

    public void clearView(View view) {
        try {
            edit1.setText("");
            edit2.setText("");
            edit3.setText("");

            text1.setText("0");
            text2.setText("0");
            text3.setText("0");
        } catch(Exception e) {

        }
    }

    public void showHelp(View view) {
        Intent launchOtherScreen = new Intent(getApplicationContext(),
                Activity2.class);
        startActivity(launchOtherScreen);
    }

    public double getMonthlyPayment() {
        return getTotalCostOfLoan() / (numberOfYears * 12);
    }

    public double getTotalCostOfLoan() {

        double monthlyInterestRate = yearlyInterestRate / 100 / 12;
        int numberOfMonths = numberOfYears * 12;

        return (monthlyInterestRate * loanAmount)
                / (1 - Math.pow((1 + monthlyInterestRate),
                (-1 * numberOfMonths))) * numberOfMonths;
    }

    public double getTotalInterestRate() {
        return getTotalCostOfLoan() - loanAmount;
    }


}
