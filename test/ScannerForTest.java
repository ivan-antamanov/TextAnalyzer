package main.java.TextAnalyzer.test;

import main.java.TextAnalyzer.impl.scanner_adapter.ScannerForUser;
import main.java.TextAnalyzer.impl.utility.CommandList;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
        while (iterator.hasNext()) {
            String currentCommand = String.valueOf(iterator.next());

            try (InputStream is = new ByteArrayInputStream(currentCommand.getBytes()); Scanner scanner = new Scanner(is)) {
                while (scanner.hasNextLine()) {
                    return scanner.nextLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return "Error";}

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
