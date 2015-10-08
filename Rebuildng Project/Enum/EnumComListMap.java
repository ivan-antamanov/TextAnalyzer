package TextAnalyzer.Enum;

import TextAnalyzer.Enum.CommandList;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by iantaman on 05.10.2015.
 */
public class EnumComListMap {

    private static HashMap<String, CommandList> stringEnumMap = new HashMap<String, CommandList>();

    static {
        for (CommandList e : CommandList.values()) {
            if (e.getShortCommand() != null) {
                stringEnumMap.put(e.getShortCommand(), e);
            } else {
                stringEnumMap.put(e.getCommand().toLowerCase(), e);
            }
        }
    }

    public static HashMap<String, CommandList> getStringEnumMap() {
        return stringEnumMap;
    }
}
