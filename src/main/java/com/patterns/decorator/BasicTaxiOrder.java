package com.patterns.decorator;

import java.math.BigDecimal;

//delegat

public class BasicTaxiOrder implements TaxiOrder{

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(5.00);
    }

    @Override
    public String getDescription() {
        return "Drive a course";
    }
}
