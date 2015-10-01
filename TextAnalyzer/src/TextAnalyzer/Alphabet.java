package TextAnalyzer;

import java.util.ArrayList;

/**
 * Created by iantaman on 24.09.2015.
 */
public class Alphabet {
    private static ArrayList<Character> letterList = new ArrayList<Character>();

    private static Alphabet alphabet = new Alphabet();

    private Alphabet() {
            for (int i = 0; i < 26; i++) {
            int c ='a'+i;
            char a = (char)c;
            Character character = new Character(a);
            letterList.add(character);
        }
    }

    public static ArrayList<Character> getLetterList() {
        return letterList;
    }


}
