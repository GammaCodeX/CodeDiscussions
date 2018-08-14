
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import implementations.*;
import interfaces.AnswerFormatter;
import org.junit.Test;


public class ImplementationTests {

	@Test
	public void OriginalTest() {
		testImplementation(new Original());
	}
	
	@Test
	public void BobsTest() {
		testImplementation(new Bobs());
	}
	
	@Test
	public void conciseTest() {
		testImplementation(new Concice());
	}
	
	@Test
	public void shamelessTest() {
		testImplementation(new Shameless());
	}
	
	private void testImplementation(AnswerFormatter subject) {
		assertThat(subject.printGuessStatistics('c', 0), is(equalTo("There are no cs")));
		assertThat(subject.printGuessStatistics('d', 0), is(equalTo("There are no ds")));
		assertThat(subject.printGuessStatistics('k', 1), is(equalTo("There is 1 k")));
		assertThat(subject.printGuessStatistics('l', 3), is(equalTo("There are 3 ls")));
	}

}
