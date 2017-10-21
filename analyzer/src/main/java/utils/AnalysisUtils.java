package utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisUtils {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String delimiter ="*****";

    public static void consAndWow(String inputText) {
        int vowels = 0;
        int consonants = 0;

        inputText = inputText.toLowerCase();
        char[] symbolArray = inputText.toCharArray();

        for (Character c : symbolArray) {
            if (Constant.getLetterList().contains(c)) {

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
        System.out.println(new TextSummary(vowels, consonants) +delimiter);

    } //count numbers of consonant and vowels

    public static void numbersOfWords(String inputText) {
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text");
        } else {
            int i = 0;
            pattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z0-9]+(?=[,\\s\\.()\";:!?\\/\\-]*)");
            matcher = pattern.matcher(inputText);
            while (matcher.find()) {
                i++;
            }
            System.out.println("There are: " + i + " words\n"+delimiter);
        }
    }

    public static void numberOfSymbols(String inputText) {
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text");
        } else {
            int i = 0;
            pattern = Pattern.compile("[.]*");
            matcher = pattern.matcher(inputText);
            while (matcher.find()) {
                i++;
            }
            System.out.println("There are: " + i + " symbols\n"+delimiter);
        }
    }

    public static void numberOfSentence(String inputText) {
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text");
        } else {
            int i = 0;
//            pattern = Pattern.compile("(?:([.!?][\\s]*[A-Z])|([.!?][\\s]*$))");
            pattern = Pattern.compile("(?:([.!?][\\s]*[а-яА-ЯёЁa-zA-Z0-9])|([.!?][\\s]*$))");
            matcher = pattern.matcher(inputText);

            while (matcher.find()) {
                i++;
            }
            System.out.println("There are: " + i + " Sentence(s)\n"+delimiter);

        }
    }

    public static void findWord(String inputText, String searchWord) {
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text");
        } else {
            int i = 0;
            pattern = Pattern.compile(searchWord);
            matcher = pattern.matcher(inputText);

            while (matcher.find()) {
                i++;
            }
            System.out.println("There are: " + i + " matches\n"+delimiter);
        }
    }
}
