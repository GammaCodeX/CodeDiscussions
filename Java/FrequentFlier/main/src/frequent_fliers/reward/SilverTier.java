package frequent_fliers.reward;

public class SilverTier extends RewardTier {
    @Override
    public String beverages() {
        return "free tequilla";
    }

    @Override
    public String boarding_group() {
        return "super priority";
    }

    @Override
    public int requiredMiles() {
        return 50_000;
    }

    @Override
    public int requiredSegments() {
        return 60;
    }

    @Override
    public int requiredDollars() {
        return 6_000;
    }
}
