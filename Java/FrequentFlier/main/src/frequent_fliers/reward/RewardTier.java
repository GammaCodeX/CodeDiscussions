package frequent_fliers.reward;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

/**
 * The reward tiers for frequent fliers. Each tier have perks that apply
 * to any customer who satisfy all requirements of that tier
 */
public abstract class RewardTier implements SelfDescribing {

    public abstract String beverages();
    public abstract String boarding_group();

    public abstract int requiredMiles();
    public abstract int requiredSegments();
    public abstract int requiredDollars();

    @Override
    public void describeTo(Description description) {
        description.appendText("Tier with requirements: [")
                .appendText("Miles: ").appendValue(requiredMiles())
                .appendText(", ")
                .appendText("Segments: ").appendValue(requiredSegments())
                .appendText(", ")
                .appendText("Dollars: ").appendValue(requiredDollars())
                .appendText("]")
        ;
    }

}
