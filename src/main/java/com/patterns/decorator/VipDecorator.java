package com.patterns.decorator;

import java.math.BigDecimal;

public class VipDecorator extends AbstractTaxiOrderDecorator{
    protected VipDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " variant VIP";
    }
}
