package TextAnalyzer;

/**
 * Created by iantaman on 06.10.2015.
 */
public class TextSummary {
    private final Integer vowels;
    private final Integer consonants;

    public TextSummary(Integer consonants, Integer vowels) {
        this.consonants = consonants;
        this.vowels = vowels;

    }

    public Integer getConsonants() {
        return consonants;
    }

    public Integer getVowels() {
        return vowels;
    }

    @Override
    public String toString() {
        return "numbers of consonants:" + consonants + "\n" +
                "numbers of vowels:" + vowels;
    }
}