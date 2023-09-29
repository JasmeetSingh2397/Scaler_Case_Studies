package Strategies;

import models.Meter;

public class NormalCarFeeCalculation implements FeeCalculationStrategy{

    @Override
    public int calculateFees(Meter meter) {
        return 50;
    }
}
