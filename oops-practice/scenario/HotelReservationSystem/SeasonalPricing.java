package HotelReservationSystem;

public class SeasonalPricing implements PricingStrategy {

    private double multiplier;

    public SeasonalPricing(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double calculate(double basePrice) {
        return basePrice * multiplier;
    }
}
