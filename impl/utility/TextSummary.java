package main.java.TextAnalyzer.impl.utility;

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
        StringBuilder toStringBuilder = new StringBuilder();

        toStringBuilder.append("numbers of consonants: ");
        if (consonants == null) {
            toStringBuilder.append("has not entered" + "\n");
        } else {
            toStringBuilder.append(consonants + "\n");

        }
        toStringBuilder.append("numbers of vowels: ");
        if (vowels == null) {
            toStringBuilder.append("has not entered" + "\n");
        } else {
            toStringBuilder.append(vowels + "\n");
        }

        return toStringBuilder.toString();
    }

}