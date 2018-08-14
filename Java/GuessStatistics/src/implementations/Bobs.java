package implementations;

import interfaces.AnswerFormatter;

class GuessStatisticsMessage {
	private String number, verb, pluralModifier;
	
	public String make(char candidate, int count) {
		createPluralDependentMessageParts(count);
		return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
	}
	
	private void createPluralDependentMessageParts(int count) {
		if (count == 0) {
			thereAreNoLetters();
		} else if (count == 1) {
			thereIsOneLetter();
		} else {
			thereAreManyLetters(count);
		}
	}
	
	private void thereAreManyLetters(int count) {
		number = Integer.toString(count);
		verb = "are";
		pluralModifier = "s";
	}
	
	private void thereIsOneLetter() {
		number = "1";
		verb = "is";
		pluralModifier = "";
	}
	
	private void thereAreNoLetters() {
		number = "no";
		verb = "are";
		pluralModifier = "s";
	}
}

/* 
 * Bobs answer uses new classes and renamed methods.
 * The boilerplate code below is just to make the tests run, and is not part of the answer,
 * it does serve to show how the answer is USED in a program though, and might be worth a read
 * Expect all classes above to be public and in their own file
 */
public class Bobs implements AnswerFormatter {
	
	@Override
	public String printGuessStatistics(char candidate, int count) {	
		GuessStatisticsMessage maker = new GuessStatisticsMessage();
		return maker.make(candidate, count);
	}
}


