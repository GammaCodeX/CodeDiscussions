package international;

public abstract class GuessMessage {

    /**
     * @param candidate The letter that was guessed
     * @param count The number of occurrences of the guess letter
     * @return A human readable message string for a guess
     */
    public abstract String forGuess(char candidate, int count);

    /**
     * @return the quantity to use when there are no candidates
     */
    protected abstract String quantityNone();

    /**
     * @param limit the max number of candidates the program will count
     * @return the quantity to use when there are too many candidates
     */
    protected abstract String quantityMany(int limit);

    String quantity(int count) {
        if (count == 0) return quantityNone();
        if (count > 1000) return quantityMany(1000);
        return Integer.toString(count);
    }



}

class EnglishGuessMessage extends GuessMessage {
	public String forGuess(char candidate, int count) {
		return "There " + verb(count) + " " +  quantity(count) + " " + candidate + pluralSuffix(count);
	}

	private String pluralSuffix(int count) {
	    if (count== 1) return "";
	    return "s";
    }

    private String verb(int count) {
	    if (count == 1) return "is";
	    return "are";
    }

    @Override
    protected String quantityNone() {
	    return "no";
    }

    @Override
    protected String quantityMany(int limit) {
	    return "over "+limit;
    }
}

class DanishGuessMessage extends GuessMessage {
	public String forGuess(char candidate, int count) {
		return "Der er " + quantity(count) + " " + candidate + pluralSuffix(count);
	}
	
	private String pluralSuffix(int count) {
		if (count == 1) return "";
		return "'er";
	}

	@Override
    protected String quantityNone() {
	    return "ingen";
    }

    @Override
    protected String quantityMany(int limit) {
        return "over "+limit;
    }
}

