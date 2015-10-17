package main.java.TextAnalyzer.impl.utility;

import java.util.HashMap;

/**
 * Created by iantaman on 26.09.2015.
 */
public enum CommandList {
    TEXT_MODE("ett", "Enter the text and analyze it"),
    FILE_MODE("efp", "Enter text-file path like \"C:\\\\Users\\\\iantaman\\\\Desktop\\\\new 1.txt\" and analyze it"),
    NUMBER_OF_WORDS("now", "Numbers of words"),
    NUMBER_OF_SENTENCE("nos", "Numbers of sentence"),
    VOWELS_AND_CONSONANTS("nvc", "Numbers of vowels and consonants"),
    TO_FIND_THE_WORD("ftw", "To find the word"),
    NUMBER_OF_SYMBOLS("numsym", "To find the word"),
    HELP("help", "How use this application"),
    EXIT("--exit", "Exit from applications");

    private String description;
    private String shortCommand;

    CommandList(String shortCommand, String description) {
        this.shortCommand = shortCommand;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public String getShortCommand() {
        return shortCommand;
    }

    private static HashMap<String, CommandList> stringEnumMap = new HashMap<String, CommandList>();

    static {
        for (CommandList e : CommandList.values()) {
            if (e.getShortCommand() != null) {
                stringEnumMap.put(e.getShortCommand(), e);
            } else {
                stringEnumMap.put(e.getDescription().toLowerCase(), e);
            }
        }
    }

    public static HashMap<String, CommandList> getStringEnumMap() {
        return stringEnumMap;
    }

    @Override
    public String toString() {
        return shortCommand + "(description)" + "=" + description; //Can make through StringBuilder
    }
}
