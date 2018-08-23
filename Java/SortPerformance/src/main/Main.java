import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Widget> widgets = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            widgets.add(new Widget(Integer.toString(i)));
        }

        Comparator<Widget> comparator = new WidgetComparator();

        Instant start = Instant.now();
        widgets.sort(comparator);
        Instant end = Instant.now();

        System.out.println("Sort took " + Duration.between(start, end).toMillis() + "ms");
    }

    public static class Widget {
        private String id;
        public Widget(String id) { this.id = id; }

        public String getKey() {
            return someExpensiveOperation(id);
        }

        private String someExpensiveOperation(String key) {
            try { Thread.sleep(1); } catch (Exception e) { /* Nothing */ }
            return key;
        }
    }

    public static class WidgetComparator implements Comparator<Widget> {
        @Override
        public int compare(Widget widgetA, Widget widgetB) {
            return widgetA.getKey().compareTo(widgetB.getKey());
        }
    }
}
