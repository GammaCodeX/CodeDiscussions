package frequent_fliers;

import frequent_fliers.customer.Customer;
import frequent_fliers.reward.RewardTier;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RuleTest {

    @Test
    public void TesCustomerSatisfiesAllMilestones() {
        Customer bob = newTestCustomer(1000,10,20);
        RewardTier testTier = newTestTier(1000,10,20);

        assertThat(bob,is(eligibleFor(testTier)));
    }


    private Matcher<Customer> eligibleFor(RewardTier tier) {
        return new TypeSafeMatcher<Customer>() {
            @Override
            protected boolean matchesSafely(Customer customer) {
                // example:
                // return customer.doesSatisfy(tier);
                return false; // Replace this with a call to your implementation.
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Customer to be eligible for: ").appendDescriptionOf(tier);
            }

            @Override
            public void describeMismatchSafely(Customer customer, Description description) {
                description.appendDescriptionOf(customer).appendText(" was not eligible");
            }
        };
    }

    private Customer newTestCustomer(int miles, int segments, int dollars) {
        return newTestCustomer(miles,segments,dollars,0);
    }

    private Customer newTestCustomer(int miles, int segments, int dollars, int partnerMiles) {
        Customer customer = new Customer();
        customer.milesFlown = miles;
        customer.segmentsFlown = segments;
        customer.dollarsSpent = dollars;
        customer.partnerMiles = partnerMiles;
        return customer;
    }

    private RewardTier newTestTier(int i, int i1, int i2) {

    }
}
