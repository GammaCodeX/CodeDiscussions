package solutions.simpleschwartziantransform;

public class Widget {
    private String id;

    public Widget(String id) {
        this.id = id;
    }

    public String getKey() {
        return someExpensiveOperation(id);
    }

    private String someExpensiveOperation(String key) {
        try {
            Thread.sleep(1);
        } catch (Exception e) { /* Nothing */ }
        return key;
    }
}
