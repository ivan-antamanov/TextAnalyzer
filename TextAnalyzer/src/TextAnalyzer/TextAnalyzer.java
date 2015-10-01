package TextAnalyzer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iantaman on 24.09.2015.
 */
public class TextAnalyzer {

    private static int vowels;
    private static int consonants;
    private Pattern pattern;
    private Matcher matcher;

    //переменные для работы с текстом
//    private static Scanner scanner;

    public TextAnalyzer() {
//        scanner = new Scanner(System.in);
    }  //конструктор

    void symbolanalyz(String string) {

            string = string.toLowerCase();
            char[] symbolArray = string.toCharArray();


            for (Character c : symbolArray) {
                if (Alphabet.getLetterList().contains(c)) {

                    switch (c) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            vowels++;
                            break;
                        default:
                            consonants++;
                            break;
                    }
                }
            }

            System.out.println("vowels: " + vowels);
            System.out.println("consonants: " + consonants);
            vowels = 0;
            consonants = 0;
            string = null;


        } //гласные и согласные символы
//    }
   void wordsNumbers(String string){
            String[] str = string.split(" +");
            System.out.println("Numbers of letters: " + str.length);
    } // количество символов

   public void sentenceNumbers(String string){
       int i = 0;
       pattern = Pattern.compile("(\\s)*([A-Z]){1}[^.]*[.]");
       matcher = pattern.matcher(string);

       while(matcher.find()){
           i++;
           System.out.println(matcher.group());
       }
       System.out.println("There are: "+i+" Sentence(s)");

    } //количесвто предложений

    void wordFinder (String string, String find){
        find= find.toUpperCase();
        String all=null;
        char[] chars = find.toCharArray();
        for(char c: chars) {
            String str = String.valueOf(c);
            str = str + str.toLowerCase();
            if (all == null) {
                all = "[" + str + "]";
            }else all =all+"[" + str + "]";
        }
        int i = 0;
        pattern = Pattern.compile(all);
        matcher = pattern.matcher(string);

        while( matcher.find()){
           i++;
            System.out.println(matcher.group());
        }
        System.out.println(i);
    } //поиск слов

}



