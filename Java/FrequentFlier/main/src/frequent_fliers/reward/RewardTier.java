package frequent_fliers.reward;

/**
 * The reward tiers for frequent fliers. Each tier have perks that apply
 * to any customer who satisfy all requirements of that tier
 */
public abstract class RewardTier {

    public abstract String beverages();
    public abstract String boarding_group();

    public abstract int requiredMiles();
    public abstract int requiredSegments();
    public abstract int requiredDollars();
}
