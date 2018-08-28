package frequent_fliers.customer;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

/**
 * The customer class represents our recorded data about each customer.
 * For simplicity it is just a struct, but you can imagine it being a full blown object with behaviour
 */
public class Customer implements SelfDescribing {

    public String name;

    public int milesFlown;
    public int partnerMiles;
    public int dollarsSpent;
    public int segmentsFlown;

    @Override
    public void describeTo(Description description) {
        description.appendText("Customer with milestones: [")
                .appendText("Miles flown: ").appendValue(milesFlown)
                .appendText(", ")
                .appendText("Partner miles: ").appendValue(partnerMiles)
                .appendText(", ")
                .appendText("Segments flown: ").appendValue(segmentsFlown)
                .appendText(", ")
                .appendText("Dollars spent: ").appendValue(dollarsSpent)
        ;
    }
}
