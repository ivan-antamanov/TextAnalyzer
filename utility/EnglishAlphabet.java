package TextAnalyzer.Application.utility;

import java.util.ArrayList;

/**
 * Created by iantaman on 24.09.2015.
 */
public class EnglishAlphabet {
    private static ArrayList<Character> letterList = new ArrayList<>(26);

    static {
        for (int i = 0; i < 26; i++) {
            int c = 'a' + i;
            char a = (char) c;
            Character character = new Character(a);
            letterList.add(character);
        }
    }

    public static ArrayList<Character> getLetterList() {
        return letterList;
    }

}
