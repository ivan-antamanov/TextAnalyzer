package TextAnalyzer.Application.scanner_adapter;

import TextAnalyzer.Application.utility.CommandList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by iantaman on 13.10.2015.
 */
public class ScannerForTest extends ScannerForUser {

    private ArrayList<String> readFileListCommand;
    private Iterator iterator;

    public ScannerForTest(String filePath, String searchWord) {
        super(null);

        readFileListCommand = new ArrayList<>(CommandList.values().length);
        for (CommandList en : CommandList.values()) {
            if (en.getShortCommand() != null && !en.getShortCommand().equals("ett")) { //not add "Enter the text" command
                readFileListCommand.add(en.getShortCommand());

            }
        }
        addFilePath(filePath);
        addSearchWord(searchWord);
        iterator = readFileListCommand.iterator();


    } //constructor for test application like Text-file-model

    @Override
    public String nextLine() {
        String str = null;
        while (iterator.hasNext()) {
            str = String.valueOf(iterator.next());
            return String.valueOf(str);
        }

        return "\nSuccessful test";
    }

    @Override
    public boolean hasNextLine() {
        return super.hasNextLine();
    }

    private void addFilePath(String filePath) {
        if (readFileListCommand.contains("efp")) {
            readFileListCommand.add(readFileListCommand.indexOf("efp") + 1, filePath);
        }
    }

    private void addSearchWord(String searchWord) {
        if (readFileListCommand.contains("ftw")) {
            readFileListCommand.add(readFileListCommand.indexOf("ftw") + 1, searchWord);
        }
    }


}
