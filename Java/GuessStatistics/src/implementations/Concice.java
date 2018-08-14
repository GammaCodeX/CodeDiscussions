package implementations;

import interfaces.AnswerFormatter;

public class Concice implements AnswerFormatter {

	@Override
	public String printGuessStatistics(char candidate, int count) {
		return "There "+
				(count==1 ? "is " : "are ") +
				(count==0 ? "no" : Integer.toString(count)) + 
				" "+candidate+(count==1 ? "":"s");
	}

}
