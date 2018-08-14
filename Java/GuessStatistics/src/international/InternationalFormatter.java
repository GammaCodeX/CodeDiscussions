package international;

import java.util.Locale;

import interfaces.AnswerFormatter;

public class InternationalFormatter implements AnswerFormatter {
	
	private GuessMessage message;
	
	// Notice how InternationalFormatter now is just a factory
	public InternationalFormatter(Locale locale) {
		if(locale.equals(Locale.forLanguageTag("en-UK"))) {
			message = new EnglishGuessMessage();
		} else if(locale.equals(Locale.forLanguageTag("da-DK"))) {
			message = new DanishGuessMessage();
		}
	}

	@Override
	public String printGuessStatistics(char candidate, int count) {
		return message.forGuess(candidate, count);
	}

}
