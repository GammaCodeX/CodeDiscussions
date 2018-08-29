package frequent_fliers;

import frequent_fliers.customer.Customer;
import frequent_fliers.reward.RewardTier;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RuleTest {

    @Test
    public void customerIsEligibleIfFlownEnoughSegments() {
        Customer bob = newTestCustomer(0, 10, 0);
        RewardTier testTier = newTestTier(1000, 10, 0);

        assertThat(bob, is(eligibleFor(testTier)));
    }

    @Test
    public void customerIsEligibleIfFlownEnoughMiles() {
        Customer bob = newTestCustomer(1000, 0, 0);
        RewardTier testTier = newTestTier(1000, 10, 0);

        assertThat(bob, is(eligibleFor(testTier)));
    }

    @Test
    public void customerIsNotEligibleIfNotEnoughDollarsSpent() {
        Customer bob = newTestCustomer(1000, 10, 5);
        RewardTier testTier = newTestTier(1000, 10, 20);

        assertThat(bob, is(not(eligibleFor(testTier))));
    }

    @Test
    public void partnerMilesCountTowardsMilesMilestone() {
        Customer bob = newTestCustomer(500, 0, 0, 500);
        RewardTier testTier = newTestTier(1000, 10, 0);

        assertThat(bob, is(eligibleFor(testTier)));
    }

    @Test
    public void partnerMilesAreCappedAt10_000() {
        Customer bob = newTestCustomer(0, 0, 0, 12_000);
        RewardTier testTier = newTestTier(10_001, 10, 0);

        assertThat(bob, is(not(eligibleFor(testTier))));
    }

    @Test
    public void milesWithOurCompanyAreNotCapped() {
        Customer bob = newTestCustomer(20_000, 0, 0, 12_000);
        RewardTier testTier = newTestTier(30_000, 10, 0);

        assertThat(bob, (eligibleFor(testTier)));
    }

    private Matcher<Customer> eligibleFor(RewardTier tier) {
        return new TypeSafeMatcher<Customer>() {
            @Override
            protected boolean matchesSafely(Customer customer) {
                // example:
                // return customer.isEligibleFor(tier);
                return false; // Replace this with a call to your implementation.
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("eligible for: ")
                        .appendText("Tier with requirements: [")
                        .appendText("Miles: ").appendValue(tier.requiredMiles())
                        .appendText(", ")
                        .appendText("Segments: ").appendValue(tier.requiredSegments())
                        .appendText(", ")
                        .appendText("Dollars: ").appendValue(tier.requiredDollars())
                        .appendText("]")
                ;
            }

            @Override
            public void describeMismatchSafely(Customer customer, Description description) {
                description
                        .appendText("was Customer with milestones: [")
                        .appendText("Miles flown: ").appendValue(customer.milesFlown)
                        .appendText(", ")
                        .appendText("Partner miles: ").appendValue(customer.partnerMiles)
                        .appendText(", ")
                        .appendText("Segments flown: ").appendValue(customer.segmentsFlown)
                        .appendText(", ")
                        .appendText("Dollars spent: ").appendValue(customer.dollarsSpent)
                        .appendText("] ")
                ;
                // Sadly the not() matcher has a defect where it doesn't delegate describeMismatch
                // https://github.com/hamcrest/JavaHamcrest/issues/165
                // So some error messages may not be prettified by hamcrest :(
            }
        };
    }

    private Customer newTestCustomer(int miles, int segments, int dollars) {
        return newTestCustomer(miles, segments, dollars, 0);
    }

    private Customer newTestCustomer(int miles, int segments, int dollars, int partnerMiles) {
        Customer customer = new Customer();
        customer.milesFlown = miles;
        customer.segmentsFlown = segments;
        customer.dollarsSpent = dollars;
        customer.partnerMiles = partnerMiles;
        return customer;
    }

    private RewardTier newTestTier(int requiredMiles, int requiredSegments, int requiredDollars) {
        RewardTier tier = mock(RewardTier.class);
        when(tier.requiredMiles()).thenReturn(requiredMiles);
        when(tier.requiredSegments()).thenReturn(requiredSegments);
        when(tier.requiredDollars()).thenReturn(requiredDollars);
        return tier;
    }
}

