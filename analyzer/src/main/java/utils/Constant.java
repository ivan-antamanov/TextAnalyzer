package utils;

import java.util.ArrayList;

/**
 * Created by User on 21.10.2017.
 */
public class Constant {

    private static ArrayList<Character> letterList = new ArrayList<>(26);

    static {
        for (int i = 0; i < 26; i++) {
            int c = 'a' + i;
            char a = (char) c;
            letterList.add(new Character(a));
        }
    }

    public static ArrayList<Character> getLetterList() {
        return letterList;
    }

}
