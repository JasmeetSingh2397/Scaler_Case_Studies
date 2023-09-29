package Strategies;

import models.Meter;

public interface FeeCalculationStrategy {
    public int calculateFees(Meter meter);
}
