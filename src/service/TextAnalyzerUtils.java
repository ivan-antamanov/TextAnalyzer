package TextAnalyzer.Application.service;

import TextAnalyzer.Application.utility.EnglishAlphabet;
import TextAnalyzer.Application.utility.TextSummary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iantaman on 24.09.2015.
 */
public class TextAnalyzerUtils {
    private static Pattern pattern;
    private static Matcher matcher;

    public static void consAndWow(String inputText) {
        int vowels = 0;
        int consonants = 0;

        inputText = inputText.toLowerCase();
        char[] symbolArray = inputText.toCharArray();

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
        System.out.println(new TextSummary(vowels, consonants));

    } //count numbers of consonant and vowels

    public static void numbersOfWords(String inputText) {
        int i = 0;
        pattern = Pattern.compile("[a-zA-Z0-9]+(?=[,\\s\\.()\";:!?\\/\\-]*)");
        matcher = pattern.matcher(inputText);
        while (matcher.find()) {
            i++;
        }
        System.out.println("There are: " + i + " words");
    }

    public static void numberOfSymbols(String inputText) {
        int i = 0;
        pattern = Pattern.compile("[.]*");
        matcher = pattern.matcher(inputText);
        while (matcher.find()) {
            i++;
        }
        System.out.println("There are: " + i + " symbols");
    }

    public static void numberOfSentence(String inputText) {
        int i = 0;
        pattern = Pattern.compile("(?:([.!?][\\s]*[A-Z])|([.!?][\\s]*$))");
        matcher = pattern.matcher(inputText);

        while (matcher.find()) {
            i++;
        }
        System.out.println("There are: " + i + " Sentence(s)");

    }

    public static void findWord(String inputText, String searchWord) {
        int i = 0;
        pattern = Pattern.compile(searchWord);
        matcher = pattern.matcher(inputText);

        while (matcher.find()) {
            i++;
        }
        System.out.println("There are: " + i + " matches");
    }

}



