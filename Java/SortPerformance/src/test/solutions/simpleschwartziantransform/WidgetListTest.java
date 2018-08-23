package solutions.simpleschwartziantransform;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class WidgetListTest {

    // Notice that the mocks used here make the test fast and decoupled from
    // the implementation of widget (as long as the API doesnt change)

    @Test
    public void itAllowsAddAndGetLikeAList() {
        WidgetList widgets = new WidgetList();
        widgets.add(newMockWidget("7"));
        widgets.add(newMockWidget("11"));

        assertThat(widgets.get(0),hasKey("7"));
        assertThat(widgets.get(1),hasKey("11"));
    }

    @Test
    public void itSortsWidgetsAccordingToId() {
        WidgetList widgets = new WidgetList();
        widgets.add(newMockWidget("5"));
        widgets.add(newMockWidget("7"));
        widgets.add(newMockWidget("4"));

        widgets.sort();

        assertThat(widgets,areInOrder("4","5","7"));
    }

    @Test
    public void itCallsGetKeyNoMoreThanOncePerWidget() {
        WidgetList widgets = new WidgetList();
        final int[] keyGets = new int[]{0}; //Its in an array because if I made the int itself final I cant increment it

        for (int i = 0; i < 200; i++) {
            final String key = i%7+" "+i;   //the first part is to make sure sort is not trivial
            Widget mock = mock(Widget.class);
            when(mock.getKey()).then((Answer<String>) invocation -> {
                keyGets[0]++;
                return key;
            });
            widgets.add(mock);
        }

        widgets.sort();

        assertThat(keyGets[0], is(lessThanOrEqualTo(200)));
    }

    private Matcher<WidgetList> areInOrder(final String... keys) {
        return new TypeSafeMatcher<WidgetList>() {
            @Override
            protected boolean matchesSafely(WidgetList item) {
                for (int i=0; i<keys.length; i++) {
                    if(!item.get(i).getKey().equals(keys[i])) return false;
                }
                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Widgets should be: ");
                for (String key : keys) {
                    description.appendValue(key);
                    description.appendText(", ");
                }
            }

            @Override
            public void describeMismatchSafely(WidgetList item, Description description) {
                description.appendText(" was: ");
                for (int i=0; i<keys.length; i++) {
                    description.appendValue(item.get(i).getKey());
                    description.appendText(", ");
                }
            }

        };
    }

    private Matcher<Widget> hasKey(String expectedKey) {
        return new TypeSafeMatcher<Widget>() {
            @Override
            protected boolean matchesSafely(Widget item) {
               return item.getKey().equals(expectedKey);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Widget should have key: ").appendValue(expectedKey);
            }

            @Override
            public void describeMismatchSafely(Widget item, Description description) {
                description.appendText(" was: ").appendValue(item.getKey());
            }
        };
    }

    private Widget newMockWidget(String key) {
        Widget widget = mock(Widget.class);
        when(widget.getKey()).thenReturn(key);
        return widget;
    }

}
