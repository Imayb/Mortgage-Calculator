package com.example.mortgagecalculator;

public class Mortgage {

    private double amount;
    private double downpayment;
    private double rate;
    private int years;

    public Mortgage( ) {
        setAmount(100000.00);
        setDownpayment(40000.00);
        setYears(15);
        setRate( 0.035 );
    }

    public void setAmount( double newAmount ) {
        if (newAmount >= 0)
            amount = newAmount;
    }

    public void setDownpayment( double newDownpayment ) {
        if (newDownpayment >= 0)
            downpayment = newDownpayment;
    }

    public void setYears( int newYears ) {
        if (newYears >= 0)
            years = newYears;
    }

    public void setRate( double newRate ) {
        if (newRate >= 0)
            rate = newRate;
    }

    public double getAmount( ) {
        return amount;
    }

    public double getDownpayment( ) {
        return downpayment;
    }

    public int getYears( ) {
        return years;
    }

    public double getRate( ) {
        return rate;
    }

    public double monthlyPayment( ) {
        double mRate = rate / 12;  // monthly interest rate
        double temp = Math.pow( 1/( 1 + mRate ), years * 12 );
        return amount * mRate / ( double ) ( 1 - temp );
    }

    public double totalPayment( ) {
        return ( monthlyPayment() * years * 12);
    }

}
