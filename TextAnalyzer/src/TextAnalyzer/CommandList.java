package TextAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by iantaman on 26.09.2015.
 */
public class CommandList {
    private static HashMap<Integer, String> commandMap = new HashMap<Integer, String>();
    private static String[] arrayCommand ={
            "The Number of symbols;",
            "The Number of sentences;",
            "The Number of vowels and consonants;",
            "Word repeater","How many sentence",
            "Exit"};
    private static CommandList commandList = new CommandList();

    private CommandList() {
        for (int i = 0; i < arrayCommand.length; i++) {
            commandMap.put(i + 1, arrayCommand[i]);
        }
    }

    @Override
    public String toString() {
        return ""+commandMap;
    }

    public static CommandList getCommandList(){
        return commandList;
    }

}
