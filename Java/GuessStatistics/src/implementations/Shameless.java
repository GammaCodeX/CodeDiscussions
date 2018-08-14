package implementations;

import interfaces.AnswerFormatter;

public class Shameless implements AnswerFormatter {

	@Override
	public String printGuessStatistics(char candidate, int count) {
		if (count == 0) {
			return "There are no " + candidate + "s";
		}
		if (count == 1) {
			return "There is 1 " + candidate;
		}
		return "There are " + count + " " + candidate + "s"; 
	}

}
