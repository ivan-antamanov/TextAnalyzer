package TextAnalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iantaman on 24.09.2015.
 */
public class TextAnalyzerMethods {
    private static TextSummary textSummary;
    private static Pattern pattern;
    private static Matcher matcher;

    public static void consAndWow(String string) {
        int vowels = 0;
        int consonants = 0;

        string = string.toLowerCase();
        char[] symbolArray = string.toCharArray();

        for (Character c : symbolArray) {
            if (EnglishAlphabet.getLetterList().contains(c)) {

                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'y':
                        vowels++;
                        break;
                    default:
                        consonants++;
                        break;
                }
            }
        }
        textSummary = new TextSummary(vowels, consonants);
        System.out.println(textSummary);

    } //count numbers of consonant and vowels

    public static void numbersOfWords(String string) {
        int i = 0;
        pattern = Pattern.compile("[a-zA-Z0-9]*(?=[,\\s\\.()\";:!?/\\-\\|])");
        matcher = pattern.matcher(string);
        while (matcher.find()) {
            i++;
        }
        System.out.println(i);
    }

    public static void numberOfSentence(String string) {
        int i = 0;
        pattern = Pattern.compile("(?:([.!?][\\s]*[A-Z])|([.!?][\\s]*$))");
        matcher = pattern.matcher(string);

        while (matcher.find()) {
            i++;
        }
        System.out.println("There are: " + i + " Sentence(s)");

    }

    public static void findWord(String string, String find) {
        int i = 0;
        pattern = Pattern.compile(find);
        matcher = pattern.matcher(string);

        while (matcher.find()) {
            i++;
        }
        System.out.println(i);
    }

}



