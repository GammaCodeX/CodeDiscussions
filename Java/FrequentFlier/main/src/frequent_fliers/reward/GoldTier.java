package frequent_fliers.reward;

public class GoldTier extends RewardTier {
    @Override
    public String beverages() {
        return "free champagne";
    }

    @Override
    public String boarding_group() {
        return "teleport directly into your seat";
    }

    @Override
    public int requiredMiles() {
        return 75_000;
    }

    @Override
    public int requiredSegments() {
        return 100;
    }

    @Override
    public int requiredDollars() {
        return 10_000;
    }
}
