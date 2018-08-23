package solutions.simpleschwartziantransform;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        WidgetList widgets = new WidgetList();
        for(int i=0; i<1000; i++) {
            widgets.add(new Widget(Integer.toString(i)));
        }

        Instant start = Instant.now();
        widgets.sort();
        Instant end = Instant.now();

        System.out.println("Sort took " + Duration.between(start, end).toMillis() + "ms");
    }
}
