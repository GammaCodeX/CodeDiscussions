package frequent_fliers.reward;

public class BronzeTier extends RewardTier {
    @Override
    public String beverages() {
        return "free beer";
    }

    @Override
    public String boarding_group() {
        return "priority";
    }

    @Override
    public int requiredMiles() {
        return 25_000;
    }

    @Override
    public int requiredSegments() {
        return 30;
    }

    @Override
    public int requiredDollars() {
        return 3_000;
    }
}
