package solutions.simpleschwartziantransform;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetList {

    private List<Widget> widgets;

    public WidgetList() {
        widgets = new ArrayList<>();
    }

    public void add(Widget widget) {
        widgets.add(widget);
    }

    public void sort() {
        widgets = widgets.stream()
                .map(widget -> new SchwartzianElement(widget, widget.getKey()))
                .sorted(Comparator.comparing(x -> x.key))
                .map(x -> x.widget).collect(Collectors.toList());
    }

    public Widget get(int index) {
        return widgets.get(index);
    }
}

// a simple struct for use in the Schwartzian transform
class SchwartzianElement {
    public final Widget widget;
    public final String key;

    public SchwartzianElement(Widget widget, String key) {

        this.widget = widget;
        this.key = key;
    }
}
