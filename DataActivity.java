package com.example.mortgagecalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    public static final String DA = "DataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Log.w( DA, "Inside DataActivity:onCreate\n" );
        updateView();
    }
    protected void onStart( ) {
        super.onStart( );
        Log.w( DA, "Inside DataActivity:onStart\n" );
    }

    protected void onRestart( ) {
        super.onRestart( );
        Log.w( DA, "Inside DataActivity:onReStart\n" );
    }

    protected void onResume( ) {
        super.onResume( );
        Log.w( DA, "Inside DataActivity:onResume\n" );
    }

    protected void onPause( ) {
        super.onPause( );
        Log.w( DA, "Inside DataActivity:onPause\n" );
    }

    protected void onStop( ) {
        super.onStop( );
        Log.w( DA, "Inside DataActivity:onStop\n" );
    }

    protected void onDestroy( ) {
        super.onDestroy( );
        Log.w( DA, "Inside DataActivity:onDestroy\n" );
    }

    public void updateView() {
        Mortgage mortgage = MainActivity.mortgage;
        if(mortgage.getYears() == 10) {
            RadioButton rb10 = findViewById(R.id.ten);
            rb10.setChecked(true);
        }else if (mortgage.getYears() == 15) {
            RadioButton rb15 = findViewById(R.id.fifteen);
            rb15.setChecked(true);
        }else if (mortgage.getYears() == 20) {
                RadioButton rb20 = findViewById(R.id.twenty);
                rb20.setChecked(true);
        } else if (mortgage.getYears() == 30) {
        RadioButton rb30 = findViewById(R.id.thirty);
        rb30.setChecked(true);
    }

        EditText amountET = findViewById(R.id.data_amount);
        amountET.setText(mortgage.getAmount() + " ");
        EditText rateET = findViewById(R.id.data_rate);
        rateET.setText(mortgage.getRate() + " ");
        EditText downpaymentET = findViewById(R.id.data_downpayment);
        downpaymentET.setText(mortgage.getDownpayment() + " ");

    }

    public void updateMortgage(){
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton rb10 = findViewById(R.id.ten);
        RadioButton rb15 = findViewById(R.id.fifteen);
        RadioButton rb20 = findViewById(R.id.twenty);

        int years = 30;
        if (rb10.isChecked())
            years = 10;
        else if (rb15.isChecked())
            years = 15;
        else if (rb20.isChecked())
            years = 20;
        mortgage.setYears(years);

        EditText amountET = findViewById(R.id.data_amount);
        String amountString = amountET.getText().toString();
        double amount = Double.parseDouble(amountString);
        mortgage.setAmount(amount);

        EditText rateET = findViewById(R.id.data_rate);
        String rateString = rateET.getText().toString();
        double rate = Double.parseDouble(rateString);
        mortgage.setRate(rate);

        EditText downpaymentET = findViewById(R.id.data_downpayment);
        String downpaymentString = downpaymentET.getText().toString();
        double downpayment = Double.parseDouble(downpaymentString);
        mortgage.setDownpayment(downpayment);


    }

    public void goBack(View v) {
        updateMortgage();
        this.finish();

    }

}
