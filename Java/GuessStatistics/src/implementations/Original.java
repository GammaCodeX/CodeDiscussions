package implementations;

import interfaces.AnswerFormatter;

/*
 * Welcome to the next Java Code Discussion Challenge.
 * In this challenge we debate some better solutions to this snippet of code
 * Original snippet is from page 28 of Clean Code by "Uncle" Robert C. Martin (slightly modified)
 */

public class Original implements AnswerFormatter{

	@Override
	public String printGuessStatistics(char candidate, int count) {
		String number;
		String verb;
		String pluralModifier;
		if (count == 0) {
			number = "no";
			verb = "are";
			pluralModifier = "s";
		} else if (count == 1) {
			number = "1";
			verb = "is";
			pluralModifier = "";
		} else {
			number = Integer.toString(count);
			verb = "are";
			pluralModifier = "s";
		}
		return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);	
	}
}
