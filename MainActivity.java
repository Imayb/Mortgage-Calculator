package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public static final String MA = "MainActivity";

    public final DecimalFormat MONEY = new DecimalFormat("$###0.00");
    public final DecimalFormat DF = new DecimalFormat("$##.00%");
    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        Log.w( MA, "Inside MainActivity:onCreate\n" );
        setContentView(R.layout.activity_main);
    }


    public void goBack( View v ) {
        this.finish( );
    }

    protected void onStart( ) {
        super.onStart( );
        Log.w( MA, "Inside MainActivity:onStart\n" );
        updateView();
    }

    protected void onRestart( ) {
        super.onRestart( );
        Log.w( MA, "Inside MainActivity:onReStart\n" );
    }

    protected void onResume( ) {
        super.onResume( );
        Log.w( MA, "Inside MainActivity:onResume\n" );
    }

    protected void onPause( ) {
        super.onPause( );
        Log.w( MA, "Inside MainActivity:onPause\n" );
    }

    protected void onStop( ) {
        super.onStop( );
        Log.w( MA, "Inside MainActivity:onStop\n" );
    }

    protected void onDestroy( ) {
        super.onDestroy( );
        Log.w( MA, "Inside MainActivity:onDestroy\n" );
    }

    public void updateView(){
        TextView amountTV = findViewById(R.id.amount);
        amountTV.setText(MONEY.format(mortgage.getAmount()));

        TextView downpaymentTV = findViewById(R.id.downpayment);
        downpaymentTV.setText(MONEY.format(mortgage.getDownpayment()));

        TextView yearTV = findViewById(R.id.years);
        yearTV.setText(MONEY.format(mortgage.getYears()));

        TextView rateTV = findViewById(R.id.rate);
        rateTV.setText(MONEY.format(mortgage.getRate()));

        TextView monthlyTV = findViewById(R.id.payment);
        monthlyTV.setText(MONEY.format(mortgage.monthlyPayment()));

        TextView totalTV = findViewById(R.id.total);
        totalTV.setText(MONEY.format(mortgage.totalPayment()));

    }

    public void modifyData(View v){
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);

    }
}